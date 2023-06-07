package com.qinmingxuan.fuzzy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Marcos中间表")
public class MarcosTemp {
    private double Q;
    private String supply;
    private Integer id;

//    private String supply;
}
