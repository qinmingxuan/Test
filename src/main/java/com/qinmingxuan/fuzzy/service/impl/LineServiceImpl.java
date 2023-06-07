package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.Line;
import com.qinmingxuan.fuzzy.mapper.LineMapper;
import com.qinmingxuan.fuzzy.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements LineService {
    @Autowired
    private LineMapper lineMapper;

    @Autowired
    private LineService lineService;

    @Override
    public List<Line> queryAll() {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> notNull = lineQueryWrapper.lambda().isNotNull(Line::getExpert);
        List<Line> lineList = lineMapper.selectList(notNull);
        return lineList;
    }

    /**
     * 取第a列，b列，expert的评价值比大小min(1,1-a+b)
     * @param a
     * @param b
     * @param expert
     * @return
     */
    @Override
    public double cal(int a, int b, int expert){
        ArrayList<Double> doubles = save(expert);
        Double aDouble = doubles.get(a-1);
        Double bDouble = doubles.get(b-1);
        double min = Math.min(1 ,1 - aDouble + bDouble);
        return min;
    }

    /**
     * 取第a列，b列所有expert的评价值
     * @param a
     * @param b
     * @return
     */
    @Override
    public ArrayList<Double> cal(int a, int b){
        ArrayList<Double> allExperts = new ArrayList<>();
        for (int i = 1 ; i < 7; i++) {
            double cal = lineService.cal(a, b , i);
            allExperts.add(cal);
        }
        return allExperts;
    }

    /**
     * 计算a单列的上近似解
     * @param expert 目标专家
     * @return
     */
    @Override
    public ArrayList<Double> cal2(int a, int expert) {
        ArrayList<Double> experts = save(expert);
        ArrayList<Double> allMin = new ArrayList<>();
            for (int b = 1; b < 7; b++) {
                ArrayList<Double> allExperts = lineService.cal(a,b);
                Double min = Collections.min(allExperts);
                double expertBMin = Math.min(1, 1 - min + experts.get(b - 1));
                allMin.add(expertBMin);
            }
        return allMin;
    }

    /**
     * 计算a单列的下近似解
     * @param expert 目标专家
     * @return
     */
    @Override
    public ArrayList<Double> cal3(int a, int expert) {
        ArrayList<Double> experts = save(expert);
        ArrayList<Double> allMin = new ArrayList<>();
        for (int b = 1; b < 7; b++) {
            ArrayList<Double> allExperts = lineService.cal(a,b);
            Double min = Collections.min(allExperts);
            double expertBMin =  min +  experts.get(b - 1) - 1;
            allMin.add(expertBMin);
        }
        return allMin;
    }


    public ArrayList<Double> calLoose(int a, int b, double beta){
        ArrayList<Double> allExperts = new ArrayList<>();

        List<Line> lineList = new ArrayList<>();
        switch (a){
            case 1:
                lineList = greaterA1(beta);
                break;
            case 2:
                lineList = greaterA2(beta);
                break;
            case 3:
                lineList = greaterA3(beta);
                break;
            case 4:
                lineList = greaterA4(beta);
                break;
            case 5:
                lineList = greaterA5(beta);
                break;
            case 6:
                lineList = greaterA6(beta);
                break;
        }
        for (Line line : lineList) {
            Integer id = line.getId();
            double cal = lineService.cal(a, b , id);
            allExperts.add(cal);
        }
        return allExperts;
    }

    /**
     * 计算a单列的上近似解(松)
     * @param expert 目标专家
     * @return
     */
    @Override
    public ArrayList<Double> calLooses(int a, int expert, double beta) {
        ArrayList<Double> experts = save(expert);
        ArrayList<Double> allMin = new ArrayList<>();
        for (int b = 1; b < 7; b++) {
            ArrayList<Double> allExperts = calLoose(a,b,beta);
            Double min = Collections.min(allExperts);
            double expertBMin = Math.min(1, 1 - min + experts.get(b - 1));
            allMin.add(expertBMin);
        }
        return allMin;
    }

    /**
     * 计算a单列的下近似解(松)
     * @param expert 目标专家
     * @return
     */
    @Override
    public ArrayList<Double> calLoosesDown(int a, int expert, double beta) {
        ArrayList<Double> experts = save(expert);
        ArrayList<Double> allMin = new ArrayList<>();
        for (int b = 1; b < 7; b++) {
            ArrayList<Double> allExperts = calLoose(a,b,beta);
            Double min = Collections.min(allExperts);
            double expertBMin =  min +  experts.get(b - 1) - 1;
            allMin.add(expertBMin);
        }
        return allMin;
    }


    public  ArrayList<Double> save(int expert){
        Line line = lineMapper.selectById(expert);
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(line.getA1());
        doubles.add(line.getA2());
        doubles.add(line.getA3());
        doubles.add(line.getA4());
        doubles.add(line.getA5());
        doubles.add(line.getA6());
        return doubles;
    }



    public List<Line> greaterA1(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA1 = lineQueryWrapper.lambda().ge(Line::getA1,beta);
        List<Line> lineList = lineMapper.selectList(greaterA1);
        return lineList;
    }

    public List<Line> greaterA2(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA2 = lineQueryWrapper.lambda().ge(Line::getA2,beta);
        List<Line> lineList = lineMapper.selectList(greaterA2);
        return lineList;
    }

    public List<Line> greaterA3(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA3 = lineQueryWrapper.lambda().ge(Line::getA3,beta);
        List<Line> lineList = lineMapper.selectList(greaterA3);
        return lineList;
    }

    public List<Line> greaterA4(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA4 = lineQueryWrapper.lambda().ge(Line::getA4,beta);
        List<Line> lineList = lineMapper.selectList(greaterA4);
        return lineList;
    }

    public List<Line> greaterA5(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA5 = lineQueryWrapper.lambda().ge(Line::getA5,beta);
        List<Line> lineList = lineMapper.selectList(greaterA5);
        return lineList;
    }

    public List<Line> greaterA6(double beta) {
        QueryWrapper<Line> lineQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Line> greaterA6= lineQueryWrapper.lambda().ge(Line::getA6,beta);
        List<Line> lineList = lineMapper.selectList(greaterA6);
        return lineList;
    }

}
