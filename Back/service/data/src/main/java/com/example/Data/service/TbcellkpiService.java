package com.example.Data.service;

import com.example.Data.entity.Tbcellkpi;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Data.entity.excel.Execlcellkpi;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
public interface TbcellkpiService extends IService<Tbcellkpi> {

    Tbcellkpi construct(Execlcellkpi execlcellkpi);

    void saveExecl(MultipartFile file, TbcellkpiService tbcellkpiService);

    Tbcellkpi trigger(Tbcellkpi tbcellkpi);
}
