package com.example.Data.controller;


import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbatuhandover;
import com.example.Data.entity.Tbc2i;
import com.example.Data.service.TbatuhandoverService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/Data/tbatuhandover")
public class TbatuhandoverController {

    @Autowired
    private TbatuhandoverService tbatuhandoverService;

    @ApiOperation("")
    @PostMapping("writeExecl")
    public R writeExecl(String filename){
        EasyExcel.write(filename, Tbatuhandover.class).sheet("out").doWrite(tbatuhandoverService.list(null));
        return R.ok();
    }

}

