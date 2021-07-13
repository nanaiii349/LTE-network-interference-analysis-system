package com.example.Queries.service.impl;

import com.example.Queries.entity.Tbcell;
import com.example.Queries.mapper.TbcellMapper;
import com.example.Queries.service.TbcellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bouncycastle.pqc.math.linearalgebra.IntUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@Service
public class TbcellServiceImpl extends ServiceImpl<TbcellMapper, Tbcell> implements TbcellService {

    @Override
    public Boolean constraints(Tbcell tbcell){
        if(tbcell.getSectorId()==null&&tbcell.getSectorName()==null&&tbcell.getEnodebid()==null&&tbcell.getEnodebName()==null)
            return false;
        if(tbcell.getAzimuth()==null&&tbcell.getTotletilt()==null&&tbcell.getEarfcn()==null)
            return false;
        if(tbcell.getSss()!=null&&tbcell.getPss()!=null)
            if(tbcell.getPci()!=tbcell.getSss()*3+tbcell.getPss())
                return false;
        if(tbcell.getSss()==null||tbcell.getPss()==null)
            if(tbcell.getPci()>503||tbcell.getPci()<0)
                return false;
        if(tbcell.getElecttilt()!=null&&tbcell.getMechtilt()!=null)
            if(tbcell.getTotletilt()!=tbcell.getElecttilt()+tbcell.getMechtilt())
                return false;
        if(tbcell.getLongitude()<=-180||tbcell.getLongitude()>=180)
            return false;
        if(tbcell.getLatitude()<=-90||tbcell.getLatitude()>=90)
            return false;
        return true;
    }

    @Override
    public Tbcell trigger(Tbcell tbcell){
        int PCI = tbcell.getPci();
        if(tbcell.getPss()==null)
            tbcell.setPss(PCI % 3);
        if(tbcell.getSss()==null)
            tbcell.setSss((PCI-tbcell.getPss())/3);
        return tbcell;
    }
}
