package com.example.Data.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tbcell;
import com.example.Data.listener.cellListener;
import com.example.Data.mapper.TbcellMapper;
import com.example.Data.entity.excel.Execlcell;
import com.example.Data.service.TbcellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
@Service
public class TbcellServiceImpl extends ServiceImpl<TbcellMapper, Tbcell> implements TbcellService {

    @Override
    public Boolean constraints(Execlcell excelcell){
        if(excelcell.getSectorId()==null&&excelcell.getSectorName()==null&&excelcell.getEnodebid()==null&&excelcell.getEnodebName()==null)
            return false;
        if(excelcell.getAzimuth()==null&&excelcell.getTotletilt()==null&&excelcell.getEarfcn()==null)
            return false;
        if(excelcell.getSss()!=null&&excelcell.getPss()!=null)
            if(excelcell.getPci()!=excelcell.getSss()*3+excelcell.getPss())
                return false;
        if(excelcell.getSss()==null||excelcell.getPss()==null)
            if(excelcell.getPci()>503||excelcell.getPci()<0)
                return false;
        if(excelcell.getElecttilt()!=null&&excelcell.getMechtilt()!=null)
            if(excelcell.getTotletilt()!=excelcell.getElecttilt()+excelcell.getMechtilt())
                return false;
        if(excelcell.getLongitude()<=-180||excelcell.getLongitude()>=180)
            return false;
        if(excelcell.getLatitude()<=-90||excelcell.getLatitude()>=90)
            return false;
        return true;
    }

    @Override
    public void trigger(Tbcell tbcell){
        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
        wrapper.eq("SECTOR_ID",tbcell.getSectorId());
        baseMapper.update(tbcell,wrapper);
    }

    @Override
    public Tbcell construct(Execlcell execlcell) {
        Tbcell tbcell = new Tbcell();
        tbcell.setEarfcn(execlcell.getEarfcn());
        tbcell.setSectorName(execlcell.getSectorName());
        tbcell.setEnodebid(execlcell.getEnodebid());
        tbcell.setEnodebName(execlcell.getEnodebName());
        tbcell.setCity(execlcell.getCity());
        tbcell.setAzimuth(execlcell.getAzimuth());
        tbcell.setSss(execlcell.getSss());
        tbcell.setPss(execlcell.getPss());
        tbcell.setSectorId(execlcell.getSectorId());
        tbcell.setPci(execlcell.getPci());
        tbcell.setTac(execlcell.getTac());
        tbcell.setVendor(execlcell.getVendor());
        tbcell.setLatitude(execlcell.getLatitude());
        tbcell.setLongitude(execlcell.getLongitude());
        tbcell.setStyle(execlcell.getStyle());
        tbcell.setElecttilt(execlcell.getElecttilt());
        tbcell.setMechtilt(execlcell.getMechtilt());
        tbcell.setTotletilt(execlcell.getTotletilt());
        if(tbcell.getPss()==null)
            tbcell.setPss(tbcell.getPci() % 3);
        if(tbcell.getSss()==null)
            tbcell.setSss((tbcell.getPci()-tbcell.getPss())/3);
        return tbcell;
    }

    @Override
    public void saveExecl(MultipartFile file, TbcellService tbcellService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, Execlcell.class,new cellListener(tbcellService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
