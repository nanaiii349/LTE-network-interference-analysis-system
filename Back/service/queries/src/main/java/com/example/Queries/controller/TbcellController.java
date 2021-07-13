package com.example.Queries.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Queries.entity.Tbcell;
import com.example.Queries.entity.Tbcellkpi;
import com.example.Queries.entity.vo.TbcellQuery;
import com.example.Queries.service.TbcellService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/Queries/tbcell")
public class TbcellController {

    @Autowired
    private TbcellService tbcellService;

//    @ApiOperation(value = "查询")
//    @GetMapping("findAll")
//    public R findAllInfo(){
//        List<Tbcell> list= tbcellService.list(null);
//        return R.ok().data("items",list);
//    }
//
//    //4 条件查询带分页的方法
//    @ApiOperation(value = "条件查询带分页的方法")
//    @PostMapping("pageTbcellCondition/{current}/{limit}")
//    public R pageTbcellCondition(@PathVariable long current, @PathVariable long limit,
//                                 @RequestBody(required = false) TbcellQuery TbcellQuery){
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
//
//    @PostMapping("addTbcell")
//    public R addTbCell(@RequestBody Tbcell TbCell) {
//        if(tbcellService.constraints(TbCell))
//            return R.error();
//        Tbcell TbcellNew = tbcellService.trigger(TbCell);
//        boolean save = tbcellService.save(TbcellNew);
//        if(save) {
//            return R.ok();
//        } else {
//            return R.error();
//        }
//    }

    @ApiOperation(value = "查询小区by id 前端展示")
    @PostMapping("getCellById")
    public R getCellById(String sectorId,String filename){
        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(sectorId))
            wrapper.eq("SECTOR_ID",sectorId);
        else
            return R.error();

        List<Tbcell> records = tbcellService.list(wrapper); //数据list集合
        //数据导出
        EasyExcel.write(filename,Tbcell.class).sheet("1").doWrite(records);
        return R.ok().data("rows",records);
    }

    @ApiOperation(value = "查询eNode 前端展示")
    @PostMapping("geteNodeByName")
    public R geteNodeByName(String enodeName,String filename){
        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
        wrapper.eq("ENODEB_NAME",enodeName);
        List<Tbcell> records = tbcellService.list(wrapper); //数据list集合
        EasyExcel.write(filename,Tbcell.class).sheet("1").doWrite(records);
        return R.ok().data("rows",records);
    }

    @ApiOperation(value = "查询eNode 前端展示")
    @PostMapping("geteNodeById")
    public R geteNodeById(String enodeId,String filename){
        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
        wrapper.eq("ENODEBID",enodeId);
        List<Tbcell> records = tbcellService.list(wrapper); //数据list集合
        EasyExcel.write(filename,Tbcell.class).sheet("1").doWrite(records);
        return R.ok().data("rows",records);
    }


    @ApiOperation(value = "查询小区by name 前端展示")
    @PostMapping("getCellByName")
    public R getCellByName(String sectorName,String filename){
        QueryWrapper<Tbcell> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(sectorName))
            wrapper.eq("SECTOR_Name",sectorName);
        else
            return R.error();

        List<Tbcell> records = tbcellService.list(wrapper); //数据list集合
        EasyExcel.write(filename,Tbcell.class).sheet("1").doWrite(records);
        return R.ok().data("rows",records);
    }

}

