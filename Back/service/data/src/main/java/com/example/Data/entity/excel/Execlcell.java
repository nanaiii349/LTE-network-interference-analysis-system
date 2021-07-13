package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execlcell {

    @ExcelProperty(index = 0)
    private String city;

    @ExcelProperty(index = 1)
    private String sectorId;

    @ExcelProperty(index = 2)
    private String sectorName;

    @ExcelProperty(index = 3)
    private String enodebid;

    @ExcelProperty(index = 4)
    private String enodebName;

    @ExcelProperty(index = 5)
    private Integer earfcn;

    @ExcelProperty(index = 6)
    private Integer pci;

    @ExcelProperty(index = 7)
    private Integer pss;

    @ExcelProperty(index = 8)
    private Integer sss;

    @ExcelProperty(index = 9)
    private Integer tac;

    @ExcelProperty(index = 10)
    private String vendor;

    @ExcelProperty(index = 11)
    private Double longitude;

    @ExcelProperty(index = 12)
    private Double latitude;

    @ExcelProperty(index = 13)
    private String style;

    @ExcelProperty(index = 14)
    private Integer azimuth;

    @ExcelProperty(index = 15)
    private Integer height;

    @ExcelProperty(index = 16)
    private Integer electtilt;

    @ExcelProperty(index = 17)
    private Integer mechtilt;

    @ExcelProperty(index = 18)
    private Integer totletilt;

}
