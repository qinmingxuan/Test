package com.qinmingxuan.fuzzy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="评价值")
public class Line {
    private double a1;
    private double a2;
    private double a3;
    private double a4;
    private double a5;
    private double a6;
    private String expert;
    private Integer id;
}
