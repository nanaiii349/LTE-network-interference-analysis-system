package com.example.Data.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tbatuc2i对象", description="")
public class Tbatuc2i implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("SECTOR_ID")
    @TableField("SECTOR_ID")
    private String sectorId;

    @ExcelProperty("NCELL_ID")
    @TableField("NCELL_ID")
    private String ncellId;

    @ExcelProperty("RATIO_ALL")
    @TableField("RATIO_ALL")
    private Double ratioAll;

    @ExcelProperty("RANK")
    @TableField("RANK")
    private Integer rank;

    @ExcelProperty("COSITE")
    @TableField("COSITE")
    private Integer cosite;


}
