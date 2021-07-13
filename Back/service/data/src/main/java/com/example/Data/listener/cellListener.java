package com.example.Data.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tbcell;
import com.example.Data.entity.excel.Execlcell;
import com.example.Data.service.TbcellService;
import com.example.commonutils.LoggerFormatter;
import com.example.servicebase.exceptionhandler.NanaiiiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cellListener extends AnalysisEventListener<Execlcell>{

    public TbcellService tbcellService;
    private int BathSize = 50;
    Logger logger = null;
    private List<Tbcell> tbcellList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    public cellListener(){};
    public cellListener(TbcellService tbcellService) throws IOException {
        logger = Logger.getLogger("com.nanaiii.Queries.cellListener");
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        FileHandler fileHandler = new FileHandler("log/cellListener.log");
        fileHandler.setFormatter(new LoggerFormatter());
        logger.addHandler(fileHandler);
        this.tbcellService=tbcellService;

        List<Tbcell> tmpList = tbcellService.list(null);
        for(Tbcell i:tmpList){
            nameList.add(i.getSectorId());
        }
        logger.info("数据库中原本有"+nameList.size()+"条数据");
    }

    @Override
    public void invoke(Execlcell execlcell,AnalysisContext analysisContext){
        if(execlcell == null){
            throw  new NanaiiiException(20001,"文件数据为空");
        }

        Boolean constraints = tbcellService.constraints(execlcell);
        if(constraints){
            Tbcell tbcell = tbcellService.construct(execlcell);
            if(nameList.contains(execlcell.getSectorId())){
                logger.info("数据:"+execlcell.getSectorId()+" 已更新数据");
                tbcellService.trigger(tbcell);
            }
            else {
                nameList.add(tbcell.getSectorId());
                tbcellList.add(tbcell);
            }
//            Tbcell tbcellNew = tbcellService.trigger(tbcell);
        }
        else {
            logger.info("数据:"+execlcell.getSectorId()+" 不满足合理性约束，无法导入");
        }
        if(tbcellList.size()==BathSize){
            tbcellService.saveBatch(tbcellList);
            tbcellList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if(tbcellList.size()>0){
            tbcellService.saveBatch(tbcellList);
        }
    }

}
