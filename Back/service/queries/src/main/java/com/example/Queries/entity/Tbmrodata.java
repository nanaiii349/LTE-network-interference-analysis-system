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
@ApiModel(value="Tbmrodata对象", description="")
public class Tbmrodata implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("TimeStamp")
    private String TimeStamp;

    @TableField("ServingSector")
    private String ServingSector;

    @TableField("InterferingSector")
    private String InterferingSector;

    @TableField("LteScRSRP")
    private Integer LteScRSRP;

    @TableField("LteNcRSRP")
    private Integer LteNcRSRP;

    @TableField("LteNcEarfcn")
    private Integer LteNcEarfcn;

    @TableField("LteNcPci")
    private Integer LteNcPci;


}
