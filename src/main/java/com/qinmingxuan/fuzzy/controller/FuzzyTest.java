package com.qinmingxuan.fuzzy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qinmingxuan.fuzzy.entity.Line;
import com.qinmingxuan.fuzzy.http.HttpResult;
import com.qinmingxuan.fuzzy.mapper.LineMapper;
import com.qinmingxuan.fuzzy.service.LineService;
import com.qinmingxuan.fuzzy.service.TopsisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
@Api(tags = "转换接口")
public class FuzzyTest {

    @Autowired
    private LineMapper lineMapper;

    @Autowired
    private LineService lineService;

    @Autowired
    private TopsisService topsisService;


    @GetMapping("/query")
    @ApiOperation("查询")
    public HttpResult<List<Line>> query(){
        List<Line> lineList = lineService.queryAll();
        return HttpResult.ok(lineList);
    }


    @GetMapping("/cal")
    @ApiOperation("第一步")
    public HttpResult<Double> cal(int a, int b){
        ArrayList<Double> allExperts = lineService.cal(a,b);
        Double min = Collections.min(allExperts);
        return HttpResult.ok(min);
    }

    @GetMapping("/up")
    @ApiOperation("上近似解(紧)")
    public HttpResult<ArrayList<Double>> up(int expert){
        ArrayList<Double> downDouble = new ArrayList<>();
        for (int a = 1; a < 7; a++) {
            ArrayList<Double> expertMin = lineService.cal2(a, expert);
            Double min = Collections.min(expertMin);
            downDouble.add(min);
            topsisService.saveTightUp(expert, a, min);
        }
        return HttpResult.ok(downDouble);
    }


    @GetMapping("/down")
    @ApiOperation("下近似解(紧)")
    public HttpResult<ArrayList<Double>> down(int expert){
        ArrayList<Double> downDouble = new ArrayList<>();
        for (int a = 1; a < 7; a++) {
            ArrayList<Double> expertMin = lineService.cal3(a, expert);
            Double max = Collections.max(expertMin);
            downDouble.add(max);
            topsisService.saveTightdown(expert, a, max);
        }
        return HttpResult.ok(downDouble);
    }


    @GetMapping("/upLoose")
    @ApiOperation("上近似解(松)")
    public HttpResult<ArrayList<Double>> upLoose(int expert, double beta){
        ArrayList<Double> downDouble = new ArrayList<>();
        for (int a = 1; a < 7; a++) {
            ArrayList<Double> expertMin = lineService.calLooses(a, expert,beta);
            Double min = Collections.min(expertMin);
            downDouble.add(min);
            topsisService.saveLooseUp(expert, a, min);
        }
        return HttpResult.ok(downDouble);
    }

    @GetMapping("/downLoose")
    @ApiOperation("下近似解(松)")
    public HttpResult<ArrayList<Double>> downLoose(int expert,double beta){
        ArrayList<Double> downDouble = new ArrayList<>();
        for (int a = 1; a < 7; a++) {
            ArrayList<Double> expertMin = lineService.calLoosesDown(a, expert,beta);
            Double max = Collections.max(expertMin);
            topsisService.saveLoosedown(expert, a, max);
            downDouble.add(max);
        }
        return HttpResult.ok(downDouble);
    }

    @GetMapping("/save")
    @ApiOperation("最大理想值")
    public HttpResult<ArrayList<Double>> save(){
        topsisService.UpMax();
        topsisService.UpMin();
        topsisService.downMax();
        topsisService.downMin();
        return HttpResult.ok();
    }

    @GetMapping("/saveData")
    @ApiOperation("保存数据")
    public HttpResult saveData(double beta){
        for (int i = 1; i < 7; i++) {
            up(i);
            down(i);
            upLoose(i,beta);
            downLoose(i,beta);
        }
        return HttpResult.ok();
    }





}
