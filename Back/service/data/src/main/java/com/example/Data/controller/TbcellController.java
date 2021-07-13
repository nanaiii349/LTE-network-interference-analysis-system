package com.example.Data.controller;


import com.example.Data.service.TbcellService;
import com.example.Data.service.TbprbService;
import com.example.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/Data/tbcell")
public class TbcellController {


    @Autowired
    private TbcellService tbcellService;

    //添加课程分类
    //获取上传过来文件，把文件内容读取出来
    @PostMapping("addData")
    public R addSubject(MultipartFile file) {
        //上传过来excel文件
        tbcellService.saveExecl(file,tbcellService);
        return R.ok();
    }

}

