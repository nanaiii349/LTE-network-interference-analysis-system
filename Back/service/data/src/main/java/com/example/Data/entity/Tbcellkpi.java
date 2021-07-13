package com.example.Data.entity;

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
@ApiModel(value="Tbcellkpi对象", description="")
public class Tbcellkpi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("startTime")
    private String startTime;

    private String nodeName;

    private String sector;

    @TableField("sectorName")
    private String sectorName;

    @TableField("RRC_connect_times")
    private Integer rrcConnectTimes;

    @TableField("RRC_connect_request_times")
    private Integer rrcConnectRequestTimes;

    @TableField("RRC_con_suc_rate")
    private Double rrcConSucRate;

    @TableField("E_RAB_con_suc_times")
    private Integer e_rabConSucTimes;

    @TableField("E_RAB_con_try_times")
    private Integer e_rabConTryTimes;

    @TableField("E_RAB_con_suc_rate2")
    private Double e_rabConSucRate2;

    @TableField("eNodeB_E_RAB_wrong_times")
    private Integer enodebE_rabWrongTimes;

    @TableField("sector_switch_E_RAB_wrong_times")
    private Integer sectorSwitchE_rabWrongTimes;

    @TableField("E_RAB_outline_rate")
    private Double e_rabOutlineRate;

    private Double wirelessConRate;

    @TableField("eNodeB_2_S1_RESET_UE_Context_times")
    private Integer enodeb2S1_resetUe_contextTimes;

    @TableField("UE_Context_wrong_times")
    private Integer ue_contextWrongTimes;

    @TableField("UE_Context_con_suc_times")
    private Integer ue_contextConSucTimes;

    private Double wirelessOutlineRate;

    @TableField("eNodeB_in_dif_swi_suc_times")
    private Integer enodebInDifSwiSucTimes;

    @TableField("eNodeB_in_dif_swi_try_times")
    private Integer enodebInDifSwiTryTimes;

    @TableField("eNodeB_in_same_swi_suc_times")
    private Integer enodebInSameSwiSucTimes;

    @TableField("eNodeB_in_same_swi_try_times")
    private Integer enodebInSameSwiTryTimes;

    @TableField("eNodeB_amo_dif_swi_suc_times")
    private Integer enodebAmoDifSwiSucTimes;

    @TableField("eNodeB_amo_dif_swi_try_times")
    private Integer enodebAmoDifSwiTryTimes;

    @TableField("eNodeB_amo_same_swi_suc_times")
    private Integer enodebAmoSameSwiSucTimes;

    @TableField("eNodeB_amo_same_swi_try_times")
    private Integer enodebAmoSameSwiTryTimes;

    @TableField("eNB_in_swi_suc_rate")
    private String enbInSwiSucRate;

    @TableField("eNB_amon_swi_suc_rate")
    private String enbAmonSwiSucRate;

    //AC列
    @TableField("same_swi_suc_rate_zsp")
    private String sameSwiSucRateZsp;

    @TableField("dif_swi_suc_rate_zsp")
    private String difSwiSucRateZsp;

    @TableField("switch_suc_rate")
    private String switchSucRate;

    @TableField("PDCP_up_throughput")
    private Double pdcpUpThroughput;

    @TableField("PDCP_down_throughput")
    private Double pdcpDownThroughput;

    @TableField("RRC_recon_times")
    private Integer rrcReconTimes;

    @TableField("RRC_recon_rate")
    private Double rrcReconRate;

    @TableField("by_eNodeB_amon_same_exe_suc_times")
    private Integer byEnodebAmonSameExeSucTimes;

    @TableField("by_eNodeB_amon_dif_exe_suc_times")
    private Integer byEnodebAmonDifExeSucTimes;

    @TableField("by_eNodeB_in_same_exe_suc_times")
    private Integer byEnodebInSameExeSucTimes;

    @TableField("by_eNodeB_in_dif_exe_suc_times")
    private Integer byEnodebInDifExeSucTimes;

    @TableField("eNB_in_suc_times")
    private Integer enbInSucTimes;

    @TableField("eNB_in_req_times")
    private Integer enbInReqTimes;


}
