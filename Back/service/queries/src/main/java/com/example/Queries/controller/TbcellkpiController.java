package com.example.Queries.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Queries.entity.Tbcell;
import com.example.Queries.entity.Tbcellkpi;
import com.example.Queries.entity.Tbprb;
import com.example.Queries.entity.vo.TbcellQuery;
import com.example.Queries.service.TbcellService;
import com.example.Queries.service.TbcellkpiService;
import com.example.Queries.service.impl.TbcellkpiServiceImpl;
import com.example.commonutils.R;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/Queries/tbcellkpi")
public class TbcellkpiController {

    @Autowired
    private TbcellkpiService tbcellkpiService;

    @ApiOperation(value = "查询Kpi 前端展示")
    @PostMapping("getKpi")
    public R getKpi(String sectorName,String start,String end,String filename){
        QueryWrapper<Tbcellkpi> wrapper = new QueryWrapper<>();
        wrapper.eq("sectorName",sectorName);
        wrapper.between("startTime",start,end);

        List<Tbcellkpi> records = tbcellkpiService.list(wrapper); //数据list集合
        EasyExcel.write(filename,Tbcellkpi.class).sheet("1").doWrite(records);
        return R.ok().data("rows",records);
    }
}

