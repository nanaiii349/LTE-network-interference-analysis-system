package com.example.Data.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.Data.entity.Tbcellkpi;
import com.example.Data.entity.excel.Execlcellkpi;
import com.example.Data.service.TbcellkpiService;
import com.example.servicebase.exceptionhandler.NanaiiiException;
import org.apache.juli.logging.Log;

import java.util.ArrayList;
import java.util.List;

public class kpiListener extends AnalysisEventListener<Execlcellkpi> {

    public TbcellkpiService tbcellkpiService;
    private int BathSize = 50;
    private List<Tbcellkpi> tbcellkpiList = new ArrayList<>();
    public kpiListener(){};
    public kpiListener(TbcellkpiService tbcellkpiService){this.tbcellkpiService=tbcellkpiService;}


    @Override
    public void invoke(Execlcellkpi execlcellkpi, AnalysisContext analysisContext){
        if(execlcellkpi == null){
            throw  new NanaiiiException(20001,"文件数据为空");
        }
        Tbcellkpi tbcellkpi = tbcellkpiService.construct(execlcellkpi);
//        Tbcellkpi tbcellkpiNew = tbcellkpiService.trigger(tbcellkpi);
        tbcellkpiList.add(tbcellkpi);
        if(tbcellkpiList.size()==BathSize){
            tbcellkpiService.saveBatch(tbcellkpiList);
            tbcellkpiList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if(tbcellkpiList.size()>0){
            tbcellkpiService.saveBatch(tbcellkpiList);
        }
    }
}
