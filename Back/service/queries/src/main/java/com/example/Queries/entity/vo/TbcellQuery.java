package com.example.Queries.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TbcellQuery {

    @ApiModelProperty(value = "cell ID")
    public String sectorId;

    @ApiModelProperty(value = "cell name")
    public String sectorName;

    @ApiModelProperty(value = "enode id")
    private String enodebid;

    @ApiModelProperty(value = "enode name")
    private String enodebName;

}

