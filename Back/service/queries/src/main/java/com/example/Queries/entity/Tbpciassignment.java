package com.example.Queries.entity;

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
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tbpciassignment对象", description="")
public class Tbpciassignment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer nu;

    @TableField("EARFCN")
    private Integer earfcn;

    @TableField("SECTOR_ID")
    private String sectorId;

    @TableField("SECTOR_NAME")
    private String sectorName;

    @TableField("ENODEB_ID")
    private Integer enodebId;

    @TableField("PCI")
    private Integer pci;

    @TableField("PSS")
    private Integer pss;

    @TableField("SSS")
    private Integer sss;

    @TableField("LONGITUDE")
    private Double longitude;

    @TableField("LATITUDE")
    private Double latitude;

    @TableField("STYLE")
    private String style;

    @TableField("OPT_DATETIME")
    private String optDatetime;


}
