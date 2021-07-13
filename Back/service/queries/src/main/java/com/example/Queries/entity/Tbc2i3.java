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
 * @since 2021-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tbc2i3对象", description="")
public class Tbc2i3 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("CELLA")
    private String cella;

    @TableField("CELLB")
    private String cellb;

    @TableField("CELLC")
    private String cellc;

    public Tbc2i3(String cella, String cellb, String cellc) {
        this.cella = cella;
        this.cellb = cellb;
        this.cellc = cellc;
    }

}
