package com.example.Queries.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TbprbNew {

    @ExcelProperty("ENODE")
    private String eNode;

    @ExcelProperty("startTime")
    private String startTime;

    @ExcelProperty("t")
    private Double t;
}
