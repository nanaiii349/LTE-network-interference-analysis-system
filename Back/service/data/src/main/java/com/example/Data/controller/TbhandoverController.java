package com.example.Data.controller;


import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbhandover;
import com.example.Data.service.TbhandoverService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Data/tbhandover")
public class TbhandoverController {
    @Autowired
    private TbhandoverService tbhandoverService;

    @ApiOperation(value = "writeExecl")
    @PostMapping("writeExecl")
    public R writeExecl(String filename){
        EasyExcel.write(filename, Tbhandover.class).sheet("test").doWrite(getData());
        return R.ok();
    }

    private List<Tbhandover> getData(){
        List<Tbhandover> handoversList = new ArrayList<>();
//        QueryWrapper<Tboptcell> wrapper = new QueryWrapper<>();
//        wrapper.like("SECTOR_ID","15113-3");
        handoversList = tbhandoverService.list(null);
        return handoversList;
    }
}

