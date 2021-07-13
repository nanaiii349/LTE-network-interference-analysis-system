package com.example.Data.controller;


import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbc2i;
import com.example.Data.service.Tbc2iService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/Data/tbc2-i")
public class Tbc2iController {

    @Autowired
    private Tbc2iService tbc2iService;

    @ApiOperation("")
    @PostMapping("writeExecl")
    public R writeExecl(String filename){
        EasyExcel.write(filename, Tbc2i.class).sheet("out").doWrite(tbc2iService.list(null));
        return R.ok();
    }

}

