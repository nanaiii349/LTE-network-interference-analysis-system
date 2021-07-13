package com.example.Data.service;

import com.example.Data.entity.Tbprb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Data.entity.excel.Execlprb;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
public interface TbprbService extends IService<Tbprb> {
    Tbprb construct(Execlprb execlprb);

    void saveExecl(MultipartFile file, TbprbService tbprbService);
}
