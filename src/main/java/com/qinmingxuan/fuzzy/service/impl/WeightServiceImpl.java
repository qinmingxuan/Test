package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.Weight;
import com.qinmingxuan.fuzzy.mapper.WeightMapper;
import com.qinmingxuan.fuzzy.service.WeightService;
import org.springframework.stereotype.Service;

@Service
public class WeightServiceImpl extends ServiceImpl<WeightMapper, Weight> implements WeightService {
}
