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
 * @since 2021-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Tbc2inew对象", description="")
public class Tbc2inew implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SCELL")
    private String scell;

    @TableField("NCELL")
    private String ncell;

    @TableField("avg")
    private Double avg;

    @TableField("std")
    private Double std;

    @TableField("PrbC2I9")
    private Double PrbC2I9;

    @TableField("PrbABS6")
    private Double PrbABS6;


    public Tbc2inew(String scell, String ncell, Double avg, Double std, Double prbC2I9, Double prbABS6) {
        this.scell = scell;
        this.ncell = ncell;
        this.avg = avg;
        this.std = std;
        PrbC2I9 = prbC2I9;
        PrbABS6 = prbABS6;
    }
}
