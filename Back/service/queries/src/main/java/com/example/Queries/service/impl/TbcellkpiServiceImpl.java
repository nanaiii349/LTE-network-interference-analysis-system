package com.example.Queries.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Queries.entity.Tbcellkpi;
import com.example.Queries.entity.Tbprb;
import com.example.Queries.mapper.TbcellkpiMapper;
import com.example.Queries.service.TbcellkpiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@Service
public class TbcellkpiServiceImpl extends ServiceImpl<TbcellkpiMapper, Tbcellkpi> implements TbcellkpiService {

//    @Override
//    public List<String> getCellName(){
//        List<String> cellName = new ArrayList<>();
//        QueryWrapper<Tbprb> wrapper = new QueryWrapper<>();
//        wrapper.select("sectorName");
//        List<Tbcellkpi> records = TbcellkpiService.list(wrapper); //数据list集合
//
//        for (Tbcellkpi i : records){
//            cellName.add(i.getSectorName());
//            System.out.println(i.getSectorName());
//        }
//        return cellName;
//    }
}
