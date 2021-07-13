package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execlatuhandover {

    @ExcelProperty(index = 0)
    private String ssectorId;

    @ExcelProperty(index = 1)
    private String nsectorId;

    @ExcelProperty(index = 2)
    private Integer hoatt;

}
