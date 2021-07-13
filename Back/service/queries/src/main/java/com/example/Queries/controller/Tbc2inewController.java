package com.example.Queries.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Queries.entity.Tbc2i3;
import com.example.Queries.entity.Tbc2inew;
import com.example.Queries.service.Tbc2i3Service;
import com.example.Queries.service.Tbc2inewService;
import com.example.commonutils.LoggerFormatter;
import com.example.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-28
 */
@RestController
@RequestMapping("/Queries/tbc2-inew")
public class Tbc2inewController {
    @Autowired
    private Tbc2inewService tbc2inewService;

    @Autowired
    private Tbc2i3Service tbc2i3Service;

    @PostMapping("getTbc2i3")
    public R getTbc2i3(double x) throws IOException {
        Logger logger = Logger.getLogger("com.nanaiii.Queries.controller.Tbc2inewController");
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        FileHandler fileHandler = new FileHandler("log/getTbc2i3.log");
        fileHandler.setFormatter(new LoggerFormatter());
        logger.addHandler(fileHandler);

        QueryWrapper<Tbc2inew> wrapper1 = new QueryWrapper<>();
        wrapper1.ge("PrbABS6",x);
        List<Tbc2inew> tmp = tbc2inewService.list(wrapper1);
        List<String> nameAllList = new ArrayList<>();
        List<String> res = new ArrayList<>();
        List<Tbc2i3> tbc2i3List = new ArrayList<>();
        for (Tbc2inew i : tmp){
            if(!nameAllList.contains(i.getScell())){
                nameAllList.add(i.getScell());
            }
            if (!nameAllList.contains(i.getNcell())){
                nameAllList.add(i.getNcell());
            }
        }
        for(Tbc2inew tbc2inew : tmp){
            String nameA = tbc2inew.getScell();
            String nameB = tbc2inew.getNcell();
            for(String nameC : nameAllList){
                if(!nameC.equals(nameA)&&!nameC.equals(nameB)){
                    if(tbc2inewService.exist(nameA,nameC)&&tbc2inewService.exist(nameB,nameC)){
                        List<String> strings = new ArrayList<>();
                        strings.add(nameA);
                        strings.add(nameB);
                        strings.add(nameC);
                        Collections.sort(strings);
                        String strTmp = strings.toString();
//                        logger.info(strTmp);
                        if(!res.contains(strTmp)){
                            logger.info("New getOne: "+nameA+" "+nameB+" "+nameC);
                            res.add(strTmp);
                            tbc2i3List.add(new Tbc2i3(nameA,nameB,nameC));
                        }
                    }
                }
            }
        }
//        for(String nameA : nameAList){
//            QueryWrapper<Tbc2inew> wrapper = new QueryWrapper<>();
//            wrapper.eq("SCELL",nameA);
//            List<Tbc2inew> tbc2inewList = tbc2inewService.list(wrapper);
//            for(Tbc2inew i : tbc2inewList){
//                String nameB = i.getNcell();
//                for (String nameC : nameAllList){
//                    if(!nameC.equals(nameA) && !nameC.equals(nameB)){
//                        if(tbc2inewService.getOne(nameA,nameC,x)&&tbc2inewService.getOne(nameC,nameB,x)){
//                            List<String> strings = new ArrayList<>();
//                            strings.add(nameA);
//                            strings.add(nameB);
//                            strings.add(nameC);
//                            Collections.sort(strings);
//                            String strTmp = strings.toString();
//                            logger.info(strTmp);
//                            if(!res.contains(strTmp)){
//                                logger.info("New getOne: "+nameA+" "+nameB+" "+nameC);
//                                res.add(strTmp);
//                                tbc2i3List.add(new Tbc2i3(nameA,nameB,nameC));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        tbc2i3Service.saveBatch(tbc2i3List);
        return R.ok().data("tbc2i3List",tbc2i3List);
//        return R.ok();
    }
}

