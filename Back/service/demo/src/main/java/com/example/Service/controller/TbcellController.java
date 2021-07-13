package com.example.Service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Service.entity.Tbcell;
import com.example.Service.entity.Tbprb;
import com.example.Service.entity.vo.TbcellQuery;
import com.example.Service.service.TbcellService;
import com.example.Service.service.TbprbService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RequestMapping("/Service/tbcell")
public class TbcellController {

    @Autowired
    private TbcellService tbcellService;

    @ApiOperation(value = "查询")
    @GetMapping("findAll")
    public R findAllInfo(){
        List<Tbcell> list= tbcellService.list(null);
        return R.ok().data("items",list);
    }
//
//    //4 条件查询带分页的方法
//    @ApiOperation(value = "条件查询带分页的方法")
//    @PostMapping("pageTbcellCondition/{current}/{limit}")
//    public R pageTbcellCondition(@PathVariable long current,@PathVariable long limit,
//                                    @RequestBody(required = false) TbcellQuery TbcellQuery){
//        Page<Tbcell> pageTbcell = new Page<>(current,limit);
//        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
//        String sectorId = TbcellQuery.getSectorId();
//        wrapper.like("SECTOR_ID",sectorId);
//        tbcellService.page(pageTbcell,wrapper);
//        long total = pageTbcell.getTotal();//总记录数
//
//        List<Tbcell> records = pageTbcell.getRecords(); //数据list集合
//        return R.ok().data("total",pageTbcell.getTotal()).data("rows",records);
//
//    }
//
//    @PostMapping("addTbcell")
//    public R addTbCell(@RequestBody Tbcell TbCell) {
//        boolean save = tbcellService.save(TbCell);
//        if(save) {
//            return R.ok();
//        } else {
//            return R.error();
//        }
//    }
//
//    @ApiOperation(value = "查询小区by id")
//    @PostMapping("getCellById")
//    public R getCellById(@RequestBody(required = true) TbcellQuery TbcellQuery){
//        Page<Tbcell> pageTbcell = new Page<>(1,1);
//        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
//        String sectorId = TbcellQuery.getSectorId();
//        if(!StringUtils.isEmpty(sectorId))
//            wrapper.eq("SECTOR_ID",sectorId);
//        else
//            return R.error();
//        tbcellService.page(pageTbcell,wrapper);
//
//        List<Tbcell> records = pageTbcell.getRecords(); //数据list集合
//        return R.ok().data("rows",records);
//    }
//
//    @ApiOperation(value = "查询eNode")
//    @PostMapping("geteNode")
//    public R geteNode(@RequestBody(required = true) TbcellQuery TbcellQuery){
//        Page<Tbcell> pageTbcell = new Page<>(1,1);
//        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
//        String enodeId = TbcellQuery.getEnodebid();
//        String enodeName = TbcellQuery.getEnodebName();
//        if(!StringUtils.isEmpty(enodeId))
//            wrapper.eq("ENODEBID",enodeId);
//        else if(!StringUtils.isEmpty(enodeName))
//            wrapper.eq("ENODEB_NAME",enodeName);
//        tbcellService.page(pageTbcell,wrapper);
//
//        List<Tbcell> records = pageTbcell.getRecords(); //数据list集合
//        return R.ok().data("rows",records);
//    }
//
//
//    @ApiOperation(value = "查询小区by name")
//    @PostMapping("getCellByName")
//    public R getCellByName(@RequestBody(required = true) TbcellQuery TbcellQuery){
//        Page<Tbcell> pageTbcell = new Page<>(1,1);
//        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
//        String sectorName = TbcellQuery.getSectorName();
//        if(!StringUtils.isEmpty(sectorName))
//            wrapper.eq("SECTOR_Name",sectorName);
//        else
//            return R.error();
//        tbcellService.page(pageTbcell,wrapper);
//
//        List<Tbcell> records = pageTbcell.getRecords(); //数据list集合
//        return R.ok().data("rows",records);
//    }

}

