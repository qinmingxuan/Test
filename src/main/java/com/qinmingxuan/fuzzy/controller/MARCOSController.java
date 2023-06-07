package com.qinmingxuan.fuzzy.controller;

import com.qinmingxuan.fuzzy.entity.Marcos;
import com.qinmingxuan.fuzzy.entity.MarcosTemp;
import com.qinmingxuan.fuzzy.http.HttpResult;
import com.qinmingxuan.fuzzy.service.LineWeightService;
import com.qinmingxuan.fuzzy.service.MarcosService;
import com.qinmingxuan.fuzzy.service.MarcosTempService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/MARCOS")
@Api(tags = "MARCOS")
public class MARCOSController {

    @Autowired
    private LineWeightService lineWeightService;

    @Autowired
    private MarcosTempService marcosTempService;

    @Autowired
    private MarcosService marcosService;

    @GetMapping("/saveWeight")
    @ApiOperation("加权保存")
    public HttpResult saveWeight(){
        lineWeightService.circulate();
        return HttpResult.ok();
    }

    @GetMapping("/temp")
    @ApiOperation("求Q")
    public HttpResult temp(){
        marcosTempService.temp();
        return HttpResult.ok();
    }

    @GetMapping("/marcos")
    @ApiOperation("MARCOS结果")
    public HttpResult result(){
        marcosService.circulate();
        return HttpResult.ok();
    }
}
