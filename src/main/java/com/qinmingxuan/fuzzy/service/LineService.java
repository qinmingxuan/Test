package com.qinmingxuan.fuzzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinmingxuan.fuzzy.entity.Line;

import java.util.ArrayList;
import java.util.List;

public interface LineService extends IService<Line> {
    List<Line> queryAll();

    double cal(int a, int b, int expert);

    ArrayList<Double> cal(int a, int b);

    ArrayList<Double> cal2(int a,int expert);

    ArrayList<Double> cal3(int a, int expert);

    ArrayList<Double> calLooses(int a, int expert, double beta);
    ArrayList<Double> calLoosesDown(int a, int expert, double beta);
}
