package com.example.Service.controller;

import com.example.Service.service.TbprbService;
import com.example.commonutils.R;
import com.example.Service.entity.Tbprb;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/Service/tbprb")
@CrossOrigin //解决跨域
public class TbprbController {

    @Autowired
    private TbprbService tbprbService;

    @ApiOperation(value = "查询")
    @GetMapping("findAll")
    public R findAllInfo(){
        List<Tbprb> list= tbprbService.list(null);
        return R.ok().data("items",list);
    }

    @GetMapping("getPrb/{id}")
    public R getDSchedule(@PathVariable String id) {
        Tbprb TbPrb = tbprbService.getById(id);
        return R.ok().data("TbPrb",TbPrb);
    }


}

