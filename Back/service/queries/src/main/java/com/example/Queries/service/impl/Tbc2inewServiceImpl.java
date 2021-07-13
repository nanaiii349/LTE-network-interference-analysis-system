package com.example.Queries.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Queries.entity.Tbc2i3;
import com.example.Queries.entity.Tbc2inew;
import com.example.Queries.mapper.Tbc2inewMapper;
import com.example.Queries.service.Tbc2inewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-28
 */
@Service
public class Tbc2inewServiceImpl extends ServiceImpl<Tbc2inewMapper, Tbc2inew> implements Tbc2inewService {

    @Override
    public Boolean exist(String nameA, String nameC) {
        QueryWrapper<Tbc2inew> wrapper = new QueryWrapper<>();
        wrapper.eq("SCELL",nameA);
        wrapper.eq("NCELL",nameC);
        int n1 = baseMapper.selectCount(wrapper);

        QueryWrapper<Tbc2inew> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("SCELL",nameC);
        wrapper2.eq("NCELL",nameA);
        int n2 = baseMapper.selectCount(wrapper2);

        return n1 != 0 || n2 != 0;
    }

    // @return 返回符合要求的表项的主小区
    @Override
    public Boolean getOne(String nameA,String nameC,double x){
        QueryWrapper<Tbc2inew> wrapper = new QueryWrapper<>();
        wrapper.eq("SCELL",nameA);
        wrapper.eq("NCELL",nameC);
        Tbc2inew tbc2inew = baseMapper.selectOne(wrapper);

        if(tbc2inew!=null){
            return tbc2inew.getPrbABS6() >= x;
        }
        else {
            QueryWrapper<Tbc2inew> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("SCELL",nameC);
            wrapper2.eq("NCELL",nameA);
            Tbc2inew tbc2inew2 = baseMapper.selectOne(wrapper2);
            if(tbc2inew2!=null){
                return tbc2inew2.getPrbABS6() >= x;
            }
            else
                return false;
        }
    }
}
