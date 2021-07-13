package com.example.Data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tbcell对象", description="")
public class Tbcell implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("CITY")
    private String city;

    @TableField("SECTOR_ID")
    private String sectorId;

    @TableField("SECTOR_NAME")
    private String sectorName;

    @TableField("ENODEBID")
    private String enodebid;

    @TableField("ENODEB_NAME")
    private String enodebName;

    @TableField("EARFCN")
    private Integer earfcn;

    @TableField("PCI")
    private Integer pci;

    @TableField("PSS")
    private Integer pss;

    @TableField("SSS")
    private Integer sss;

    @TableField("TAC")
    private Integer tac;

    @TableField("VENDOR")
    private String vendor;

    @TableField("LONGITUDE")
    private Double longitude;

    @TableField("LATITUDE")
    private Double latitude;

    @TableField("STYLE")
    private String style;

    @TableField("AZIMUTH")
    private Integer azimuth;

    @TableField("HEIGHT")
    private Integer height;

    @TableField("ELECTTILT")
    private Integer electtilt;

    @TableField("MECHTILT")
    private Integer mechtilt;

    @TableField("TOTLETILT")
    private Integer totletilt;


}
