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
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tboptcell对象", description="")
public class Tboptcell implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("SECTOR_ID")
    @TableField("SECTOR_ID")
    private String sectorId;

    @ExcelProperty("EARFCN")
    @TableField("EARFCN")
    private Integer earfcn;

    @ExcelProperty("CELL_TYPE")
    @TableField("CELL_TYPE")
    private String cellType;


}
