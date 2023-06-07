package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.Line;
import com.qinmingxuan.fuzzy.entity.LineWeight;
import com.qinmingxuan.fuzzy.entity.Orginal;
import com.qinmingxuan.fuzzy.entity.Weight;
import com.qinmingxuan.fuzzy.mapper.LineMapper;
import com.qinmingxuan.fuzzy.mapper.LineWeightMapper;
import com.qinmingxuan.fuzzy.mapper.OrginalMapper;
import com.qinmingxuan.fuzzy.mapper.WeightMapper;
import com.qinmingxuan.fuzzy.service.LineService;
import com.qinmingxuan.fuzzy.service.LineWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineWeightServiceImpl extends ServiceImpl<LineWeightMapper, LineWeight> implements LineWeightService {

    @Autowired
    private LineWeightMapper lineWeightMapper;

    @Autowired
    private WeightMapper weightMapper;

    @Autowired
    private OrginalMapper orginalMapper;

    /**
     * 权重加权运算
     */
    public void saveWeight(int supplyId){
        Weight weight = weightMapper.selectById(1);
        Orginal orginal = orginalMapper.selectById(supplyId);
        LineWeight lineWeight = lineWeightMapper.selectById(supplyId);
        lineWeight.setA1(orginal.getA1() * weight.getA1());
        lineWeight.setA2(orginal.getA2() * weight.getA2());
        lineWeight.setA3(orginal.getA3() * weight.getA3());
        lineWeight.setA4(orginal.getA4() * weight.getA4());
        lineWeight.setA5(orginal.getA5() * weight.getA5());
        lineWeight.setA6(orginal.getA6() * weight.getA6());
        lineWeight.setA7(orginal.getA7() * weight.getA7());
        lineWeight.setA8(orginal.getA8() * weight.getA8());
        lineWeight.setA9(orginal.getA9() * weight.getA9());
        lineWeightMapper.updateById(lineWeight);
    }


    /**
     * 6个供应商循环保存
     */
    public void circulate(){
        for (int i = 1; i < 7; i++) {
            saveWeight(i);
        }
    }
}
