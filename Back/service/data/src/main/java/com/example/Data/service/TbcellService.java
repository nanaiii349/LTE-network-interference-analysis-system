package com.example.Data.service;

import com.example.Data.entity.Tbcell;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Data.entity.excel.Execlcell;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-05-18
 */
public interface TbcellService extends IService<Tbcell> {
    Boolean constraints(Execlcell execlcell);

    void trigger(Tbcell tbcell);

    Tbcell construct(Execlcell execlcell);

    void saveExecl(MultipartFile file, TbcellService tbcellService);
}
