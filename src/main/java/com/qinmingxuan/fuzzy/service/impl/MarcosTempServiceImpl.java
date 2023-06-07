package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.LineWeight;
import com.qinmingxuan.fuzzy.entity.MarcosTemp;
import com.qinmingxuan.fuzzy.mapper.LineWeightMapper;
import com.qinmingxuan.fuzzy.mapper.MarcosTempMapper;
import com.qinmingxuan.fuzzy.service.MarcosTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class MarcosTempServiceImpl extends ServiceImpl<MarcosTempMapper, MarcosTemp> implements MarcosTempService {

    @Autowired
    private LineWeightMapper lineWeightMapper;

    @Autowired
    private MarcosTempMapper marcosTempMapper;


    /**
     * 求Q
     */
    public void temp(){
        ArrayList<Double> A1Double = new ArrayList<>();
        ArrayList<Double> A2Double = new ArrayList<>();
        ArrayList<Double> A3Double = new ArrayList<>();
        ArrayList<Double> A4Double = new ArrayList<>();
        ArrayList<Double> A5Double = new ArrayList<>();
        ArrayList<Double> A6Double = new ArrayList<>();
        ArrayList<Double> A7Double = new ArrayList<>();
        ArrayList<Double> A8Double = new ArrayList<>();
        ArrayList<Double> A9Double = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            LineWeight lineWeight = lineWeightMapper.selectById(i);
            double a1 = lineWeight.getA1();
            double a2 = lineWeight.getA2();
            double a3 = lineWeight.getA3();
            double a4 = lineWeight.getA4();
            double a5 = lineWeight.getA5();
            double a6 = lineWeight.getA6();
            double a7 = lineWeight.getA7();
            double a8 = lineWeight.getA8();
            double a9 = lineWeight.getA9();

            A1Double.add(a1);
            A2Double.add(a2);
            A3Double.add(a3);
            A4Double.add(a4);
            A5Double.add(a5);
            A6Double.add(a6);
            A7Double.add(a7);
            A8Double.add(a8);
            A9Double.add(a9);

            double sumQ = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9;
            MarcosTemp marcosTemp = MarcosTemp.builder()
                    .id(i)
                    .Q(sumQ)
                    .build();
            marcosTempMapper.updateById(marcosTemp);
        }
        double sumMax = Collections.max(A1Double) + Collections.max(A2Double) +Collections.max(A3Double) +Collections.max(A4Double) +Collections.max(A5Double) +
                Collections.max(A6Double) +Collections.max(A7Double) +Collections.max(A8Double) + Collections.max(A9Double);

        double sumMin = Collections.min(A1Double) + Collections.min(A2Double) +Collections.min(A3Double) +Collections.min(A4Double) +Collections.min(A5Double) +
                Collections.min(A6Double) +Collections.min(A7Double) +Collections.min(A8Double) + Collections.min(A9Double);

        MarcosTemp marcosTempMax = MarcosTemp.builder()
                .id(7)
                .Q(sumMax)
                .build();
        marcosTempMapper.updateById(marcosTempMax);

        MarcosTemp marcosTempMin = MarcosTemp.builder()
                .id(8)
                .Q(sumMin)
                .build();
        marcosTempMapper.updateById(marcosTempMin);


    }

}
