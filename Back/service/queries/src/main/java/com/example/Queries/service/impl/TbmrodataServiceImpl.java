package com.example.Queries.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Queries.entity.Tbc2inew;
import com.example.Queries.entity.Tbmrodata;
import com.example.Queries.mapper.TbmrodataMapper;
import com.example.Queries.service.TbmrodataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
@Service
public class TbmrodataServiceImpl extends ServiceImpl<TbmrodataMapper, Tbmrodata> implements TbmrodataService {

    private int minSize = 30;

    @Override
    public Double getPrbC2I9(Double avg, Double std) throws MathException {
        NormalDistribution out;
        out = new NormalDistributionImpl(avg,std);
        return out.cumulativeProbability(9);
    }

    @Override
    public Double getPrbABS6(Double avg, Double std) throws MathException {
        NormalDistribution out;
        out = new NormalDistributionImpl(avg,std);
        return out.cumulativeProbability(6)- out.cumulativeProbability(-6);
    }

    @Override
    public Tbc2inew createTbc2iNew(String servingSector, String interferingSector) throws MathException {
        Map<String ,String> map = new HashMap<>();
        map.put("servingSector",servingSector);
        map.put("InterferingSector",interferingSector);
        QueryWrapper<Tbmrodata> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        wrapper.select("std(LteScRSRP-LteNcRSRP) as std,avg(LteScRSRP-LteNcRSRP) as avg");
        List<Map<String ,Object>> res =  baseMapper.selectMaps(wrapper);
        BigDecimal avg_big = (BigDecimal) res.get(0).get("avg");
        Double avg = avg_big.doubleValue();
        Double std = (Double) res.get(0).get("std");
        return new Tbc2inew(servingSector,interferingSector,avg,std,getPrbC2I9(avg,std),getPrbABS6(avg,std));
    }
}
