package com.example.Queries.service;

import com.example.Queries.entity.Tbcell;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
public interface TbcellService extends IService<Tbcell> {
    Boolean constraints(Tbcell tbcell);

    Tbcell trigger(Tbcell tbcell);
}
