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
@ApiModel(value="Tbc2i对象", description="")
public class Tbc2i implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("CITY")
    @TableField("CITY")
    private String city;

    @ExcelProperty("SCELL")
    @TableId(value = "SCELL", type = IdType.ID_WORKER_STR)
    private String scell;

    @ExcelProperty("NCELL")
    @TableField("NCELL")
    private String ncell;

    @ExcelProperty("PrC2I9")
    @TableField("PrC2I9")
    private Integer PrC2I9;

    @ExcelProperty("C2I_Mean")
    @TableField("C2I_Mean")
    private Double c2iMean;

    @ExcelProperty("std")
    @TableField("std")
    private Double std;

    @ExcelProperty("SampleCount")
    @TableField("SampleCount")
    private Integer SampleCount;

    @ExcelProperty("WeightedC2I")
    @TableField("WeightedC2I")
    private Integer WeightedC2I;


}
