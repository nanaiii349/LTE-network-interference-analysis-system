package com.example.Data.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbprb;
import com.example.Data.entity.excel.Execlprb;
import com.example.Data.listener.prbListener;
import com.example.Data.mapper.TbprbMapper;
import com.example.Data.service.TbprbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
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
public class TbprbServiceImpl extends ServiceImpl<TbprbMapper, Tbprb> implements TbprbService {

    @Override
    public Tbprb construct(Execlprb execlprb) {
        Tbprb tbprb = new Tbprb();
        String tmp= execlprb.getCellDesc().split(" ")[0].split("=")[1].replace(",","");
//        System.out.println("tmp::::::::"+tmp);
        tbprb.setCellDesc(execlprb.getCellDesc());
        tbprb.setCellName(execlprb.getCellName());
        tbprb.setENode(tmp);
        tbprb.setStartTime(execlprb.getStartTime());
        tbprb.setT0(execlprb.getT0());
        tbprb.setT1(execlprb.getT1());
        tbprb.setT2(execlprb.getT2());
        tbprb.setT3(execlprb.getT3());
        tbprb.setT4(execlprb.getT4());
        tbprb.setT5(execlprb.getT5());
        tbprb.setT6(execlprb.getT6());
        tbprb.setT7(execlprb.getT7());
        tbprb.setT8(execlprb.getT8());
        tbprb.setT9(execlprb.getT9());
        tbprb.setT10(execlprb.getT10());
        tbprb.setT11(execlprb.getT11());
        tbprb.setT12(execlprb.getT12());
        tbprb.setT13(execlprb.getT13());
        tbprb.setT14(execlprb.getT14());
        tbprb.setT15(execlprb.getT15());
        tbprb.setT16(execlprb.getT16());
        tbprb.setT17(execlprb.getT17());
        tbprb.setT18(execlprb.getT18());
        tbprb.setT19(execlprb.getT19());
        tbprb.setT20(execlprb.getT20());
        tbprb.setT21(execlprb.getT21());
        tbprb.setT22(execlprb.getT22());
        tbprb.setT23(execlprb.getT23());
        tbprb.setT24(execlprb.getT24());
        tbprb.setT25(execlprb.getT25());
        tbprb.setT26(execlprb.getT26());
        tbprb.setT27(execlprb.getT27());
        tbprb.setT28(execlprb.getT28());
        tbprb.setT29(execlprb.getT29());
        tbprb.setT30(execlprb.getT30());
        tbprb.setT31(execlprb.getT31());
        tbprb.setT32(execlprb.getT32());
        tbprb.setT33(execlprb.getT33());
        tbprb.setT34(execlprb.getT34());
        tbprb.setT35(execlprb.getT35());
        tbprb.setT36(execlprb.getT36());
        tbprb.setT37(execlprb.getT37());
        tbprb.setT38(execlprb.getT38());
        tbprb.setT39(execlprb.getT39());
        tbprb.setT40(execlprb.getT40());
        tbprb.setT41(execlprb.getT41());
        tbprb.setT42(execlprb.getT42());
        tbprb.setT43(execlprb.getT43());
        tbprb.setT44(execlprb.getT44());
        tbprb.setT45(execlprb.getT45());
        tbprb.setT46(execlprb.getT46());
        tbprb.setT47(execlprb.getT47());
        tbprb.setT48(execlprb.getT48());
        tbprb.setT49(execlprb.getT49());
        tbprb.setT50(execlprb.getT50());
        tbprb.setT51(execlprb.getT51());
        tbprb.setT52(execlprb.getT52());
        tbprb.setT53(execlprb.getT53());
        tbprb.setT54(execlprb.getT54());
        tbprb.setT55(execlprb.getT55());
        tbprb.setT56(execlprb.getT56());
        tbprb.setT57(execlprb.getT57());
        tbprb.setT58(execlprb.getT58());
        tbprb.setT59(execlprb.getT59());
        tbprb.setT60(execlprb.getT60());
        tbprb.setT61(execlprb.getT61());
        tbprb.setT62(execlprb.getT62());
        tbprb.setT63(execlprb.getT63());
        tbprb.setT64(execlprb.getT64());
        tbprb.setT65(execlprb.getT65());
        tbprb.setT66(execlprb.getT66());
        tbprb.setT67(execlprb.getT67());
        tbprb.setT68(execlprb.getT68());
        tbprb.setT69(execlprb.getT69());
        tbprb.setT70(execlprb.getT70());
        tbprb.setT71(execlprb.getT71());
        tbprb.setT72(execlprb.getT72());
        tbprb.setT73(execlprb.getT73());
        tbprb.setT74(execlprb.getT74());
        tbprb.setT75(execlprb.getT75());
        tbprb.setT76(execlprb.getT76());
        tbprb.setT77(execlprb.getT77());
        tbprb.setT78(execlprb.getT78());
        tbprb.setT79(execlprb.getT79());
        tbprb.setT80(execlprb.getT80());
        tbprb.setT81(execlprb.getT81());
        tbprb.setT82(execlprb.getT82());
        tbprb.setT83(execlprb.getT83());
        tbprb.setT84(execlprb.getT84());
        tbprb.setT85(execlprb.getT85());
        tbprb.setT86(execlprb.getT86());
        tbprb.setT87(execlprb.getT87());
        tbprb.setT88(execlprb.getT88());
        tbprb.setT89(execlprb.getT89());
        tbprb.setT90(execlprb.getT90());
        tbprb.setT91(execlprb.getT91());
        tbprb.setT92(execlprb.getT92());
        tbprb.setT93(execlprb.getT93());
        tbprb.setT94(execlprb.getT94());
        tbprb.setT95(execlprb.getT95());
        tbprb.setT96(execlprb.getT96());
        tbprb.setT97(execlprb.getT97());
        tbprb.setT98(execlprb.getT98());
        tbprb.setT99(execlprb.getT99());

        return tbprb;
    }

    @Override
    public void saveExecl(MultipartFile file, TbprbService tbprbService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, Execlprb.class,new prbListener(tbprbService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
