package com.qinmingxuan.fuzzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinmingxuan.fuzzy.entity.Marcos;


public interface MarcosService extends IService<Marcos> {

    void circulate();
}
