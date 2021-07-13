package com.example.Queries.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Queries.entity.Tbc2inew;
import com.example.Queries.entity.Tbmrodata;
import com.example.Queries.service.Tbc2inewService;
import com.example.Queries.service.TbmrodataService;
import com.example.commonutils.LoggerFormatter;
import com.example.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.math.MathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.logging.*;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/Queries/tbmrodata")
public class TbmrodataController {

    @Autowired
    private TbmrodataService tbmrodataService;

    @Autowired
    private Tbc2inewService tbc2inewService;

    private int minSize = 30;

    @PostMapping("getC2i")
    public R getC2i(String servingSector ,String InterferingSector) throws MathException, IOException {
        Logger logger = Logger.getLogger("com.nanaiii.Queries.controller.TbmrodataController");
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        FileHandler fileHandler = new FileHandler("log/getC2i.log");
        fileHandler.setFormatter(new LoggerFormatter());
        logger.addHandler(fileHandler);

        QueryWrapper<Tbmrodata> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("ServingSector",servingSector);
        wrapper2.eq("InterferingSector",InterferingSector);
        if (tbmrodataService.count(wrapper2) <= minSize){
            logger.info("<"+servingSector+","+InterferingSector+">:测量值太少无法计算");
            return R.error().data("meg","测量值太少无法计算");
        }
        Tbc2inew tbc2inew = tbmrodataService.createTbc2iNew(servingSector,InterferingSector);
        return R.ok().data("tbc2inew",tbc2inew);
    }

    @ApiOperation("不需要前端展示")
    @GetMapping("Create_Tbc2iNew")
    public R createTbC2iNew() throws MathException, IOException {
        Logger logger = Logger.getLogger("com.nanaiii.Queries.controller.TbmrodataController");
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        FileHandler fileHandler = new FileHandler("log/createTbC2iNew.log");
        fileHandler.setFormatter(new LoggerFormatter());
        logger.addHandler(fileHandler);

        QueryWrapper<Tbmrodata> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT ServingSector");
        List<Tbmrodata> servingSectorList = tbmrodataService.list(wrapper);
        for(Tbmrodata servingSector : servingSectorList){
            String servingSectorName = servingSector.getServingSector();
            QueryWrapper<Tbmrodata> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("ServingSector",servingSectorName);
            wrapper1.select("DISTINCT InterferingSector");
            List<Tbmrodata> InterferingSectorList = tbmrodataService.list(wrapper1);
            for (Tbmrodata InterferingSector : InterferingSectorList){
                String InterferingName = InterferingSector.getInterferingSector();
                QueryWrapper<Tbmrodata> wrapper2 = new QueryWrapper<>();
                wrapper2.eq("ServingSector",servingSectorName);
                wrapper2.eq("InterferingSector",InterferingName);
                if (tbmrodataService.count(wrapper2) <= minSize){
//                    System.out.println("<"+servingSectorName+","+InterferingName+">测量值太少无法计算");
                    logger.info("<"+servingSectorName+","+InterferingName+">:测量值太少无法计算");
                }
                else {
                    Tbc2inew tbc2inew = tbmrodataService.createTbc2iNew(servingSectorName,InterferingName);
                    tbc2inewService.save(tbc2inew);
                }
            }
        }
        return R.ok();
    }
}

