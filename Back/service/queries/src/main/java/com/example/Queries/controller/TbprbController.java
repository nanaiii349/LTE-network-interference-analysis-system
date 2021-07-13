package com.example.Queries.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Queries.entity.Tbprb;
import com.example.Queries.entity.TbprbNew;
import com.example.Queries.entity.Tbprbbyhour;
import com.example.Queries.entity.execl.Execlprb;
import com.example.Queries.service.TbprbService;
import com.example.Queries.service.TbprbbyhourService;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/Queries/tbprb")
public class TbprbController {

    @Autowired
    private TbprbService tbprbService;

    @Autowired
    private TbprbbyhourService tbprbbyhourService;

    @ApiOperation(value = "查询Kpi 前端展示")
    @PostMapping("getKpi")
    public R getPrbByHour(String filename){
        List<Tbprbbyhour> execlprbList = new ArrayList<>();
        QueryWrapper<Tbprb> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT cellName");
        List<Tbprb> cellnameList = tbprbService.list(wrapper);

        for (Tbprb item : cellnameList){
            System.out.println("name: "+ item.getCellName()+"\n");
            QueryWrapper<Tbprb> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("cellName",item.getCellName());
            List<Tbprb> quarter = tbprbService.list(wrapper1);
            execlprbList.addAll(tbprbService.getHourList(quarter));
//            System.out.println("In getPrbByHour:  "+execlprbList.size());
        }
        tbprbbyhourService.saveBatch(execlprbList);
        EasyExcel.write(filename, Tbprbbyhour.class).sheet("out").doWrite(execlprbList);
        return R.ok().data("list",execlprbList);
    }

    @ApiOperation(value = "查询站点 前端展示")
    @PostMapping("getENode")
    public R getPrbByENode(String ENode,int t,String start,String end,String filename){
        List<TbprbNew> tbprbNewList = new ArrayList<>();
        if(start.split(" ")[1].split(":")[1].equals("00")&&end.split(" ")[1].split(":")[1].equals("00")){
            QueryWrapper<Tbprb> wrapperLen = new QueryWrapper<>();
            wrapperLen.eq("eNode",ENode);
            int num = (tbprbService.count(wrapperLen)/288)*4;
            tbprbNewList = tbprbService.getHourByOneList(num,ENode,t,start,end);
        }
        else {
            return R.error();
        }
//        String selectSql = "start_time,t"+String.valueOf(t)+"as t";
//        QueryWrapper<Tbprb> wrapper = new QueryWrapper<>();
//        wrapper.between("start_time", start, end);
//        wrapper.eq("eNode", ENode);
//        wrapper.select(selectSql);
//        List<> quarter = tbprbService.get(wrapper);
//        execlprbList = tbprbService.getHourByOneList(num,ENode,t,start,end);
        EasyExcel.write(filename, TbprbNew.class).sheet("out").doWrite(tbprbNewList);
        return R.ok().data("tbprbNewList",tbprbNewList);
    }

}

