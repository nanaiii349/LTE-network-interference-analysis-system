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
@ApiModel(value="Tbatuc2i对象", description="")
public class Tbatuc2i implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SECTOR_ID")
    private String sectorId;

    @TableField("NCELL_ID")
    private String ncellId;

    @TableField("RATIO_ALL")
    private Double ratioAll;

    @TableField("RANK")
    private Integer rank;

    @TableField("COSITE")
    private Integer cosite;


}
