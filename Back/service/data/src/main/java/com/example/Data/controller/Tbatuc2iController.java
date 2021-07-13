package com.example.Data.controller;


import com.alibaba.excel.EasyExcel;
import com.example.Data.entity.Tbatuc2i;
import com.example.Data.entity.Tbc2i;
import com.example.Data.service.Tbatuc2iService;
import com.example.Data.service.Tbc2iService;
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
 * @since 2021-05-22
 */
@RestController
@RequestMapping("/Data/tbatuc2-i")
public class Tbatuc2iController {

    @Autowired
    private Tbatuc2iService tbatuc2iService;

    @ApiOperation("")
    @PostMapping("writeExecl")
    public R writeExecl(String filename){
        EasyExcel.write(filename, Tbatuc2i.class).sheet("out").doWrite(tbatuc2iService.list(null));
        return R.ok();
    }
}

