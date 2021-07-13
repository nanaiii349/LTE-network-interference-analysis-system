package com.example.Data.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Data.entity.Tboptcell;
import com.example.Data.entity.excel.Execloptcell;
import com.example.Data.service.TboptcellService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/Data/tboptcell")
public class TboptcellController {
    @Autowired
    private TboptcellService tboptcellService;

    @ApiOperation(value = "")
    @PostMapping("writeExecl")
    public R writeExecl(String filename){
        EasyExcel.write(filename, Tboptcell.class).sheet("test").doWrite(getData());
        return R.ok();
    }

    private List<Tboptcell> getData(){
        List<Tboptcell> optCellList = new ArrayList<>();
//        QueryWrapper<Tboptcell> wrapper = new QueryWrapper<>();
//        wrapper.like("SECTOR_ID","15113-3");
        optCellList = tboptcellService.list(null);
        return optCellList;
    }
}

