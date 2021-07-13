package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execlcellkpi {

    @ExcelProperty(index = 0)
    private String startTime;

    @ExcelProperty(index = 1)
    private String nodeName;

    @ExcelProperty(index = 2)
    private String sector;

    @ExcelProperty(index = 3)
    private String sectorName;

    @ExcelProperty(index = 4)
    private Integer rrcConnectTimes;

    @ExcelProperty(index = 5)
    private Integer rrcConnectRequestTimes;

    @ExcelProperty(index = 6)
    private Double rrcConSucRate;

    @ExcelProperty(index = 7)
    private Integer e_rabConSucTimes;

    @ExcelProperty(index = 8)
    private Integer e_rabConTryTimes;

    @ExcelProperty(index = 9)
    private Double e_rabConSucRate2;

    @ExcelProperty(index = 10)
    private Integer enodebE_rabWrongTimes;

    @ExcelProperty(index = 11)
    private Integer sectorSwitchE_rabWrongTimes;

    @ExcelProperty(index = 12)
    private Double e_rabOutlineRate;

    @ExcelProperty(index = 13)
    private Double wirelessConRate;

    @ExcelProperty(index = 14)
    private Integer enodeb2S1_resetUe_contextTimes;

    @ExcelProperty(index = 15)
    private Integer ue_contextWrongTimes;

    @ExcelProperty(index = 16)
    private Integer ue_contextConSucTimes;

    @ExcelProperty(index = 17)
    private Double wirelessOutlineRate;

    @ExcelProperty(index = 18)
    private Integer enodebInDifSwiSucTimes;

    @ExcelProperty(index = 19)
    private Integer enodebInDifSwiTryTimes;

    @ExcelProperty(index = 20)
    private Integer enodebInSameSwiSucTimes;

    @ExcelProperty(index = 21)
    private Integer enodebInSameSwiTryTimes;

    @ExcelProperty(index = 22)
    private Integer enodebAmoDifSwiSucTimes;

    @ExcelProperty(index = 23)
    private Integer enodebAmoDifSwiTryTimes;

    @ExcelProperty(index = 24)
    private Integer enodebAmoSameSwiSucTimes;

    @ExcelProperty(index = 25)
    private Integer enodebAmoSameSwiTryTimes;

    @ExcelProperty(index = 26)
    private String enbInSwiSucRate;

    @ExcelProperty(index = 27)
    private String enbAmonSwiSucRate;

    // TODO 在service中将execl中string特判为nil的至改为0存入数据库中
    @ExcelProperty(index = 28)
    private String sameSwiSucRateZsp;

    @ExcelProperty(index = 29)
    private String difSwiSucRateZsp;

    @ExcelProperty(index = 30)
    private String switchSucRate;

    @ExcelProperty(index = 31)
    private Double pdcpUpThroughput;

    @ExcelProperty(index = 32)
    private Double pdcpDownThroughput;

    @ExcelProperty(index = 33)
    private Integer rrcReconTimes;

    @ExcelProperty(index = 34)
    private Double rrcReconRate;

    @ExcelProperty(index = 35)
    private Integer byEnodebAmonSameExeSucTimes;

    @ExcelProperty(index = 36)
    private Integer byEnodebAmonDifExeSucTimes;

    @ExcelProperty(index = 37)
    private Integer byEnodebInSameExeSucTimes;

    @ExcelProperty(index = 38)
    private Integer byEnodebInDifExeSucTimes;

    @ExcelProperty(index = 39)
    private Integer enbInSucTimes;

    @ExcelProperty(index = 40)
    private Integer enbInReqTimes;


}
