package com.qinmingxuan.fuzzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="综合矩阵")
public class Topsis {
    @ApiModelProperty("上限（松）")
    private double a111;
    private double a211;
    private double a311;
    private double a411;
    private double a511;
    private double a611;

    @ApiModelProperty("上限（紧）")
    private double a112;
    private double a212;
    private double a312;
    private double a412;
    private double a512;
    private double a612;

    @ApiModelProperty("下限（紧）")
    private double a121;
    private double a221;
    private double a321;
    private double a421;
    private double a521;
    private double a621;

    @ApiModelProperty("下限（松）")
    private double a122;
    private double a222;
    private double a322;
    private double a422;
    private double a522;
    private double a622;

    @ApiModelProperty("定量（上）")
    private double a71;
    private double a81;
    private double a91;

    @ApiModelProperty("定量（下）")
    private double a72;
    private double a82;
    private double a92;

    private String supper;
    private Integer id;
}
