package com.example.Queries.service;

import com.example.Queries.entity.Tbc2inew;
import com.example.Queries.entity.Tbmrodata;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.commons.math.MathException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-26
 */
public interface TbmrodataService extends IService<Tbmrodata> {

    Double getPrbC2I9(Double avg, Double std) throws MathException;

    Double getPrbABS6(Double avg, Double std) throws MathException;

    Tbc2inew createTbc2iNew(String servingSector, String interferingSector) throws MathException;
}


