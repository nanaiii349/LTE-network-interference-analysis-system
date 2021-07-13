package com.example.Data.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tbprb;
import com.example.Data.entity.excel.Execlprb;
import com.example.Data.service.TbprbService;
import com.example.servicebase.exceptionhandler.NanaiiiException;

import java.util.ArrayList;
import java.util.List;


public class prbListener extends AnalysisEventListener<Execlprb>{
    public TbprbService tbprbService;
    private int BathSize = 50;
    private List<Tbprb> tbprbList = new ArrayList<>();
    public prbListener(){}
    public prbListener(TbprbService tbprbService){this.tbprbService = tbprbService;}

    @Override
    public void invoke(Execlprb execlprb,AnalysisContext analysisContext){
        if(execlprb == null){
            throw new NanaiiiException(20001,"文件数据为空");
        }

        Tbprb tbprb = tbprbService.construct(execlprb);
//        tbprbService.save(tbprb);
        tbprbList.add(tbprb);
        if(tbprbList.size()==BathSize){
            tbprbService.saveBatch(tbprbList);
            tbprbList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if(tbprbList.size()>0){
            tbprbService.saveBatch(tbprbList);
        }
    }

}
