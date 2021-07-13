package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execlhandover {

    @ExcelProperty(index = 0)
    private String city;
    @ExcelProperty(index = 1)
    private String scell;
    @ExcelProperty(index = 2)
    private String ncell;
    @ExcelProperty(index = 3)
    private Integer hoatt;
    @ExcelProperty(index = 4)
    private Integer hosucc;
    @ExcelProperty(index = 5)
    private Double hosuccrate;
}
