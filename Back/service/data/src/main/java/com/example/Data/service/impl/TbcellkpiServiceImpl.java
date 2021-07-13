package com.example.Data.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbcellkpi;
import com.example.Data.entity.excel.Execlcellkpi;
import com.example.Data.entity.excel.Execlprb;
import com.example.Data.listener.kpiListener;
import com.example.Data.listener.prbListener;
import com.example.Data.mapper.TbcellkpiMapper;
import com.example.Data.service.TbcellkpiService;
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
public class TbcellkpiServiceImpl extends ServiceImpl<TbcellkpiMapper, Tbcellkpi> implements TbcellkpiService {

    @Override
    public Tbcellkpi construct(Execlcellkpi execlcellkpi) {
        Tbcellkpi tbcellkpi = new Tbcellkpi();
        tbcellkpi.setStartTime(execlcellkpi.getStartTime());
        tbcellkpi.setNodeName(execlcellkpi.getNodeName());
        tbcellkpi.setSector(execlcellkpi.getSector());
        tbcellkpi.setSectorName(execlcellkpi.getSectorName());
        tbcellkpi.setRrcConnectTimes(execlcellkpi.getRrcConnectTimes());
        tbcellkpi.setRrcConnectRequestTimes(execlcellkpi.getRrcConnectRequestTimes());
        tbcellkpi.setRrcConSucRate(execlcellkpi.getRrcConSucRate());
        tbcellkpi.setE_rabConSucTimes(execlcellkpi.getE_rabConSucTimes());
        tbcellkpi.setE_rabConTryTimes(execlcellkpi.getE_rabConTryTimes());
        tbcellkpi.setE_rabConSucRate2(execlcellkpi.getE_rabConSucRate2());
        tbcellkpi.setEnodebE_rabWrongTimes(execlcellkpi.getEnodebE_rabWrongTimes());
        tbcellkpi.setSectorSwitchE_rabWrongTimes(execlcellkpi.getSectorSwitchE_rabWrongTimes());
        tbcellkpi.setE_rabOutlineRate(execlcellkpi.getE_rabOutlineRate());
        tbcellkpi.setWirelessConRate(execlcellkpi.getWirelessConRate());
        tbcellkpi.setEnodeb2S1_resetUe_contextTimes(execlcellkpi.getEnodeb2S1_resetUe_contextTimes());
        tbcellkpi.setUe_contextWrongTimes(execlcellkpi.getUe_contextWrongTimes());
        tbcellkpi.setUe_contextConSucTimes(execlcellkpi.getUe_contextConSucTimes());
        tbcellkpi.setWirelessOutlineRate(execlcellkpi.getWirelessOutlineRate());
        tbcellkpi.setEnodebInDifSwiSucTimes(execlcellkpi.getEnodebInDifSwiSucTimes());
        tbcellkpi.setEnodebInDifSwiTryTimes(execlcellkpi.getEnodebInDifSwiTryTimes());
        tbcellkpi.setEnodebInSameSwiSucTimes(execlcellkpi.getEnodebInSameSwiSucTimes());
        tbcellkpi.setEnodebInSameSwiTryTimes(execlcellkpi.getEnodebInSameSwiTryTimes());
        tbcellkpi.setEnodebAmoDifSwiSucTimes(execlcellkpi.getEnodebAmoDifSwiSucTimes());
        tbcellkpi.setEnodebAmoDifSwiTryTimes(execlcellkpi.getEnodebAmoDifSwiTryTimes());
        tbcellkpi.setEnodebAmoSameSwiSucTimes(execlcellkpi.getEnodebAmoSameSwiSucTimes());
        tbcellkpi.setEnodebAmoSameSwiTryTimes(execlcellkpi.getEnodebAmoSameSwiTryTimes());
        tbcellkpi.setEnbInSwiSucRate(execlcellkpi.getEnbInSwiSucRate());
        tbcellkpi.setEnbAmonSwiSucRate(execlcellkpi.getEnbAmonSwiSucRate());
        tbcellkpi.setSameSwiSucRateZsp(execlcellkpi.getSameSwiSucRateZsp());
        tbcellkpi.setDifSwiSucRateZsp(execlcellkpi.getDifSwiSucRateZsp());
        tbcellkpi.setSwitchSucRate(execlcellkpi.getSwitchSucRate());
        tbcellkpi.setPdcpUpThroughput(execlcellkpi.getPdcpUpThroughput());
        tbcellkpi.setPdcpDownThroughput(execlcellkpi.getPdcpDownThroughput());
        tbcellkpi.setRrcReconTimes(execlcellkpi.getRrcReconTimes());
        tbcellkpi.setRrcReconRate(execlcellkpi.getRrcReconRate());
        tbcellkpi.setByEnodebAmonSameExeSucTimes(execlcellkpi.getByEnodebAmonSameExeSucTimes());
        tbcellkpi.setByEnodebAmonDifExeSucTimes(execlcellkpi.getByEnodebAmonDifExeSucTimes());
        tbcellkpi.setByEnodebInSameExeSucTimes(execlcellkpi.getByEnodebInSameExeSucTimes());
        tbcellkpi.setByEnodebInDifExeSucTimes(execlcellkpi.getByEnodebInDifExeSucTimes());
        tbcellkpi.setEnbInSucTimes(execlcellkpi.getEnbInSucTimes());
        tbcellkpi.setEnbInReqTimes(execlcellkpi.getEnbInReqTimes());
        if(tbcellkpi.getRrcConnectTimes()!=0&&tbcellkpi.getRrcConnectRequestTimes()!=0){
            tbcellkpi.setRrcConSucRate(((double)tbcellkpi.getRrcConnectTimes())/((double)tbcellkpi.getRrcConnectRequestTimes()));
        }
        else {
            tbcellkpi.setRrcConSucRate(null);
        }
        return tbcellkpi;
    }

    @Override
    public void saveExecl(MultipartFile file, TbcellkpiService tbcellkpiService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, Execlcellkpi.class,new kpiListener(tbcellkpiService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Tbcellkpi trigger(Tbcellkpi tbcellkpi) {
        if(tbcellkpi.getRrcConnectTimes()!=0&&tbcellkpi.getRrcConnectRequestTimes()!=0){
            tbcellkpi.setRrcConSucRate(((double)tbcellkpi.getRrcConnectTimes())/((double)tbcellkpi.getRrcConnectRequestTimes()));
        }
        else {
            tbcellkpi.setRrcConSucRate(null);
        }
        return tbcellkpi;
    }
}
