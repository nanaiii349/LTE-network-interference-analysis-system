package com.example.Queries.service;

import com.example.Queries.entity.Tbc2i3;
import com.example.Queries.entity.Tbc2inew;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-28
 */
public interface Tbc2inewService extends IService<Tbc2inew> {

    Boolean exist(String nameA, String nameC);

    Boolean getOne(String nameA,String nameC,double x);
}
