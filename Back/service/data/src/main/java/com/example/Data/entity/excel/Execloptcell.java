package com.example.Data.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Execloptcell {

    @ExcelProperty(index = 0)
    private String sectorId;

    @ExcelProperty(index = 1)
    private Integer earfcn;

    @ExcelProperty(index = 2)
    private String cellType;
}
