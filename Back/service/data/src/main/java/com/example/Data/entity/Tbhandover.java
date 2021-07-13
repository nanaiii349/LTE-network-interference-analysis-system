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
@ApiModel(value="Tbhandover对象", description="")
public class Tbhandover implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("CITY")
    @TableField("CITY")
    private String city;

    @ExcelProperty("SCELL")
    @TableField("SCELL")
    private String scell;

    @ExcelProperty("NCELL")
    @TableField("NCELL")
    private String ncell;

    @ExcelProperty("HOATT")
    @TableField("HOATT")
    private Integer hoatt;

    @ExcelProperty("HOSUCC")
    @TableField("HOSUCC")
    private Integer hosucc;

    @ExcelProperty("HOSUCCRATE")
    @TableField("HOSUCCRATE")
    private Double hosuccrate;


}
