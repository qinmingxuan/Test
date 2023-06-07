package com.qinmingxuan.fuzzy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Marcos结果")
public class Marcos {
    private double ua;
    private double us;
    private double fa;
    private double fs;
    private double fi;

    private String supply;
    private Integer id;
}
