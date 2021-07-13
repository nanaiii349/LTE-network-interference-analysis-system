package com.example.Data.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tbatuhandover;
import com.example.Data.entity.Tbc2i;
import com.example.Data.entity.excel.Execlc2i;
import com.example.Data.service.Tbc2iService;
import com.example.servicebase.exceptionhandler.NanaiiiException;

import java.util.ArrayList;
import java.util.List;

public class c2iListenter extends AnalysisEventListener<Execlc2i> {

    public Tbc2iService tbc2iService;
    public c2iListenter() {}
    public c2iListenter(Tbc2iService tbc2iService) {
        this.tbc2iService = tbc2iService;
    }
    List<Tbc2i> tbc2iList = new ArrayList<>();
    int BathSize = 50;

    //读取execl内容
    @Override
    public void invoke(Execlc2i execlc2i, AnalysisContext analysisContext){
        if(execlc2i == null){
            throw new NanaiiiException(20001,"文件数据为空");
        }

        Tbc2i tbc2i = new Tbc2i();
        tbc2i.setCity(execlc2i.getCity());
        tbc2i.setNcell(execlc2i.getNcell());
        tbc2i.setScell(execlc2i.getScell());
        tbc2i.setPrC2I9(execlc2i.getPrC2I9());
        tbc2i.setC2iMean(execlc2i.getC2iMean());
        tbc2i.setStd(execlc2i.getStd());
        tbc2i.setSampleCount(execlc2i.getSampleCount());
        tbc2i.setWeightedC2I(execlc2i.getWeightedC2I());
        tbc2iList.add(tbc2i);
        if(tbc2iList.size()==BathSize){
            tbc2iService.saveBatch(tbc2iList);
            tbc2iList.clear();
        }
    }

    private Tbc2i existKey(Tbc2iService tbc2iService,String key){
        QueryWrapper<Tbc2i> wrapper = new QueryWrapper<>();
        wrapper.eq("SCELL",key);
        Tbc2i one = tbc2iService.getOne(wrapper);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext){
        if(tbc2iList.size()!=0){
            tbc2iService.saveBatch(tbc2iList);
        }
    }
}
