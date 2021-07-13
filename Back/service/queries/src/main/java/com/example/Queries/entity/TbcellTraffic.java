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
@ApiModel(value="TbcellTraffic对象", description="")
public class TbcellTraffic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Date")
    private String Date;

    @TableField("Hour")
    private Integer Hour;

    @TableField("Sector_ID")
    private String sectorId;

    @TableField("Traffic")
    private Double Traffic;


}
