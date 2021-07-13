package com.example.Data.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tbhandover;
import com.example.Data.entity.excel.Execlhandover;
import com.example.Data.service.TbhandoverService;
import com.example.servicebase.exceptionhandler.NanaiiiException;

import java.util.ArrayList;
import java.util.List;

public class handoverListener extends AnalysisEventListener<Execlhandover>{

    public TbhandoverService tbhandoverService;
    public handoverListener() {}
    public handoverListener(TbhandoverService tbhandoverService) {
        this.tbhandoverService = tbhandoverService;
    }
    List<Tbhandover> tbhandoverList = new ArrayList<>();
    int BathSize = 50;

    //读取execl内容
    @Override
    public void invoke(Execlhandover execlhandover, AnalysisContext analysisContext){
        if(execlhandover == null){
            throw new NanaiiiException(20001,"文件数据为空");
        }

        Tbhandover tbhandover = new Tbhandover();
        tbhandover.setCity(execlhandover.getCity());
        tbhandover.setHoatt(execlhandover.getHoatt());
        tbhandover.setHosucc(execlhandover.getHosucc());
        tbhandover.setNcell(execlhandover.getNcell());
        tbhandover.setScell(execlhandover.getScell());
        tbhandover.setHosuccrate(execlhandover.getHosuccrate());
        tbhandoverList.add(tbhandover);
        if(tbhandoverList.size()==BathSize){
            tbhandoverService.saveBatch(tbhandoverList);
            tbhandoverList.clear();
        }
    }

    private Tbhandover existKey(TbhandoverService tbhandoverService,String key){
        QueryWrapper<Tbhandover> wrapper = new QueryWrapper<>();
        wrapper.eq("SCELL",key);
        Tbhandover one = tbhandoverService.getOne(wrapper);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext){
        if(tbhandoverList.size()>0){
            tbhandoverService.saveBatch(tbhandoverList);
        }
    }
}
