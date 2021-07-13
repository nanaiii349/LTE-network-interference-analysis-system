package com.example.Queries.service;

import com.example.Queries.entity.Tbprb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Queries.entity.TbprbNew;
import com.example.Queries.entity.Tbprbbyhour;
import com.example.Queries.entity.execl.Execlprb;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
public interface TbprbService extends IService<Tbprb> {

    List<Tbprbbyhour> getHourList(List<Tbprb> quarter);

    List<TbprbNew> getHourByOneList(int num, String ENode, int t, String start, String end);

//    List<Tbprb> getHourByOneList(List<Tbprb> quarter,int num);
}

