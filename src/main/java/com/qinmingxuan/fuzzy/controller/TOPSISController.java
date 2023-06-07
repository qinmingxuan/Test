package com.qinmingxuan.fuzzy.controller;

import com.qinmingxuan.fuzzy.entity.Result;
import com.qinmingxuan.fuzzy.http.HttpResult;
import com.qinmingxuan.fuzzy.mapper.ResultMapper;
import com.qinmingxuan.fuzzy.service.DreamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/TOPSIS-GRA")
@Api(tags = "TOPSIS-GRA")
public class TOPSISController {

    @Autowired
    private DreamService dreamService;

    @Autowired
    private ResultMapper resultMapper;

    @GetMapping("/MinC")
    @ApiOperation("正理想解距离最小值")
    public HttpResult<Double> MinC(){
        Double minC = dreamService.fuzzyMinC();
        return HttpResult.ok(minC);
    }

    @GetMapping("/MaxC")
    @ApiOperation("正理想解距离最大值")
    public HttpResult<Double> MaxC(){
        Double maxC = dreamService.fuzzyMaxC();
        return HttpResult.ok(maxC);
    }

    @GetMapping("/MinN")
    @ApiOperation("负理想解距离最小值")
    public HttpResult<Double> MinN(){
        Double minN = dreamService.fuzzyMinN();
        return HttpResult.ok(minN);
    }

    @GetMapping("/MaxN")
    @ApiOperation("负理想解距离最小值")
    public HttpResult<Double> MaxN(){
        Double maxN = dreamService.fuzzyMaxN();
        return HttpResult.ok(maxN);
    }

    @GetMapping("/GRAC")
    @ApiOperation("正理想解关联系数")
    public HttpResult<ArrayList<Double>> GRAC(int supplyId, double R){
        ArrayList<Double> grac = dreamService.GRAC(supplyId, R);
        return HttpResult.ok(grac);
    }

    @GetMapping("/GRAN")
    @ApiOperation("负理想解关联系数")
    public HttpResult<ArrayList<Double>> GRAN(int supplyId, double R){
        ArrayList<Double> gran = dreamService.GRAN(supplyId, R);
        return HttpResult.ok(gran);
    }

    @GetMapping("/WeightGRAC")
    @ApiOperation("加权后的正理想解关联系数")
    public HttpResult<Double> WeightGRAC(int supplyId, double R){
        Double aDouble = dreamService.WeightGRAC(supplyId, R);
        return HttpResult.ok(aDouble);
    }

    @GetMapping("/TOPSIS")
    @ApiOperation("TOPSIS-GRA")
    public HttpResult<Double> TOPSISGRA(int supplyId, double R){
        Double aDouble = dreamService.TOPSISGRA(supplyId, R);
        return HttpResult.ok(aDouble);
    }
    @GetMapping("/TOPSISSave")
    @ApiOperation("TOPSIS-GRA-Save")
    public HttpResult<Double> TOPSISGRASave(double R){
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            Double aDouble = dreamService.TOPSISGRA(i, R);
            doubleArrayList.add(aDouble);
        }
        Result result = Result.builder()
                .id(1)
                .s1(doubleArrayList.get(0))
                .s2(doubleArrayList.get(1))
                .s3(doubleArrayList.get(2))
                .s4(doubleArrayList.get(3))
                .s5(doubleArrayList.get(4))
                .s6(doubleArrayList.get(5))
                .build();
        resultMapper.updateById(result);
        return HttpResult.ok();
    }


}
