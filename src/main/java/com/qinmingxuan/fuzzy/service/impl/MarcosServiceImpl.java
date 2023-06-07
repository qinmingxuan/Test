package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.LineWeight;
import com.qinmingxuan.fuzzy.entity.Marcos;
import com.qinmingxuan.fuzzy.entity.MarcosTemp;
import com.qinmingxuan.fuzzy.mapper.MarcosMapper;
import com.qinmingxuan.fuzzy.mapper.MarcosTempMapper;
import com.qinmingxuan.fuzzy.service.MarcosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcosServiceImpl extends ServiceImpl<MarcosMapper, Marcos> implements MarcosService {

    @Autowired
    private MarcosTempMapper marcosTempMapper;

    @Autowired
    private MarcosMapper marcosMapper;

    public void result(int supplyId){
        MarcosTemp marcosTemp = marcosTempMapper.selectById(supplyId);
        MarcosTemp marcosTempMax = marcosTempMapper.selectById(7);
        MarcosTemp marcosTempMin = marcosTempMapper.selectById(8);
//
        double US = marcosTemp.getQ() / marcosTempMax.getQ();
        double UA = marcosTemp.getQ() / marcosTempMin.getQ();

        double FS = UA / (US + UA);
        double FA = US / (US + UA);

        double Fi = (UA + US) / (1 + ((1 - FS) / FS) + ((1 - FA) / FA));

        Marcos marcos = Marcos.builder()
                .ua(UA)
                .fa(FA)
                .fi(Fi)
                .fs(FS)
                .id(supplyId)
                .us(US)
                .build();
        marcosMapper.updateById(marcos);

    }

    /**
     * 6个供应商循环保存
     */
    public void circulate(){
        for (int i = 1; i < 7; i++) {
            result(i);
        }
    }
}
