package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execlc2i {

    @ExcelProperty(index = 0)
    private String city;

    @ExcelProperty(index = 1)
    private String scell;

    @ExcelProperty(index = 2)
    private String ncell;

    @ExcelProperty(index = 3)
    private Integer PrC2I9;

    @ExcelProperty(index = 4)
    private Double c2iMean;

    @ExcelProperty(index = 5)
    private Double std;

    @ExcelProperty(index = 6)
    private Integer SampleCount;

    @ExcelProperty(index = 7)
    private Integer WeightedC2I;

}
