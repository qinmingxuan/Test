package com.qinmingxuan.fuzzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinmingxuan.fuzzy.entity.Topsis;

import java.util.ArrayList;

public interface TopsisService extends IService<Topsis> {

    void saveLoosedown(int id , int a, double max);
    void saveLooseUp(int id , int a, double max);
    void saveTightdown(int id , int a, double max);
    void saveTightUp(int id , int a, double max);
    ArrayList<Double> UpMax();
    ArrayList<Double> UpMin();
    ArrayList<Double> downMin();
    ArrayList<Double> downMax();

}
