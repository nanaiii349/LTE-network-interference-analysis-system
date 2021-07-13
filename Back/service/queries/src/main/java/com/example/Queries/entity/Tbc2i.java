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
@ApiModel(value="Tbc2i对象", description="")
public class Tbc2i implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("CITY")
    private String city;

    @TableField("SCELL")
    private String scell;

    @TableField("NCELL")
    private String ncell;

    @TableField("PrC2I9")
    private Integer PrC2I9;

    @TableField("C2I_Mean")
    private Double c2iMean;

    private Double std;

    @TableField("SampleCount")
    private Integer SampleCount;

    @TableField("WeightedC2I")
    private Integer WeightedC2I;


}
