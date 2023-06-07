package com.qinmingxuan.fuzzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinmingxuan.fuzzy.entity.Dream;

import java.util.ArrayList;

public interface DreamService extends IService<Dream> {

    ArrayList<Double> fuzzyMinMax(int supplyId, int dreamId);
    Double fuzzyMinC();
    Double fuzzyMaxC();
    Double fuzzyMinN();
    Double fuzzyMaxN();
    ArrayList<Double> GRAC(int supplyId, double R);
    ArrayList<Double> GRAN(int supplyId, double R);
    Double WeightGRAC(int supplyId, double R);
    Double WeightGRAN(int supplyId, double R);
    Double TOPSISGRA(int supplyId, double R);
}
