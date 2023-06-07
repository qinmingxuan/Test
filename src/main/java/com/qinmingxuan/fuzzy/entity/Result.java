package com.qinmingxuan.fuzzy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="贴近度结果")
public class Result {
    private double s1;
    private double s2;
    private double s3;
    private double s4;
    private double s5;
    private double s6;

    private Integer id;
}
