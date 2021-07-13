package com.example.Queries.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TbcellKpiQuery {

    @ApiModelProperty(value = "cell name")
    public String sectorName;

    @ApiModelProperty(value = "startTime")
    private String startTime;
}
