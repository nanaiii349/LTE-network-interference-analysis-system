package com.example.Queries.controller;


import com.example.commonutils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/Queries/tbc2-i")
public class Tbc2iController {

    @PostMapping("test")
    public R test(String roomId){
        System.out.println(roomId);
        return R.ok();
    }
}

