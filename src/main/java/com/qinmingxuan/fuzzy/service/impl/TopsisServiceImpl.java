package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.Dream;
import com.qinmingxuan.fuzzy.entity.Line;
import com.qinmingxuan.fuzzy.entity.Topsis;
import com.qinmingxuan.fuzzy.mapper.DreamMapper;
import com.qinmingxuan.fuzzy.mapper.TopsisMapper;
import com.qinmingxuan.fuzzy.service.DreamService;
import com.qinmingxuan.fuzzy.service.TopsisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class TopsisServiceImpl extends ServiceImpl<TopsisMapper, Topsis> implements TopsisService {

    @Autowired
    private TopsisMapper topsisMapper;

    private TopsisService topsisService;

    @Autowired
    private DreamMapper dreamMapper;

    /**
     * 上限取大
     * @param
     * @return
     */
    public ArrayList<Double> UpMax(){
        QueryWrapper<Topsis> topsisQueryWrapper = new QueryWrapper<>();
        topsisQueryWrapper.lambda().isNotNull(Topsis::getId);
        List<Topsis> topsisList = topsisMapper.selectList(topsisQueryWrapper);
        ArrayList<Double> doubleUpTight = new ArrayList<>();

        ArrayList<Double> doubleUpTightA111 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA211 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA311 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA411 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA511 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA611 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA112 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA212 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA312 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA412 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA512 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA612 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA7 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA8 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA9 = new ArrayList<>();

        topsisList.stream().forEach(topsis -> {
            doubleUpTightA111.add(topsis.getA111());
            doubleUpTightA211.add(topsis.getA211());
            doubleUpTightA311.add(topsis.getA311());
            doubleUpTightA411.add(topsis.getA411());
            doubleUpTightA511.add(topsis.getA511());
            doubleUpTightA611.add(topsis.getA611());

            doubleUpTightA112.add(topsis.getA112());
            doubleUpTightA212.add(topsis.getA212());
            doubleUpTightA312.add(topsis.getA312());
            doubleUpTightA412.add(topsis.getA412());
            doubleUpTightA512.add(topsis.getA512());
            doubleUpTightA612.add(topsis.getA612());

            doubleUpTightA7.add(topsis.getA71());
            doubleUpTightA8.add(topsis.getA81());
            doubleUpTightA9.add(topsis.getA91());
        });
        doubleUpTight.add(Collections.max(doubleUpTightA111));
        doubleUpTight.add(Collections.max(doubleUpTightA211));
        doubleUpTight.add(Collections.max(doubleUpTightA311));
        doubleUpTight.add(Collections.max(doubleUpTightA411));
        doubleUpTight.add(Collections.max(doubleUpTightA511));
        doubleUpTight.add(Collections.max(doubleUpTightA611));
        doubleUpTight.add(Collections.max(doubleUpTightA112));
        doubleUpTight.add(Collections.max(doubleUpTightA212));
        doubleUpTight.add(Collections.max(doubleUpTightA312));
        doubleUpTight.add(Collections.max(doubleUpTightA412));
        doubleUpTight.add(Collections.max(doubleUpTightA512));
        doubleUpTight.add(Collections.max(doubleUpTightA612));
        doubleUpTight.add(Collections.max(doubleUpTightA7));
        doubleUpTight.add(Collections.max(doubleUpTightA8));
        doubleUpTight.add(Collections.max(doubleUpTightA9));

        Dream dream = dreamMapper.selectById(1);
        dream.setA111(doubleUpTight.get(0));
        dream.setA211(doubleUpTight.get(1));
        dream.setA311(doubleUpTight.get(2));
        dream.setA411(doubleUpTight.get(3));
        dream.setA511(doubleUpTight.get(4));
        dream.setA611(doubleUpTight.get(5));
        dream.setA112(doubleUpTight.get(6));
        dream.setA212(doubleUpTight.get(7));
        dream.setA312(doubleUpTight.get(8));
        dream.setA412(doubleUpTight.get(9));
        dream.setA512(doubleUpTight.get(10));
        dream.setA612(doubleUpTight.get(11));
        dream.setA71(doubleUpTight.get(12));
        dream.setA81(doubleUpTight.get(13));
        dream.setA91(doubleUpTight.get(14));
        dreamMapper.updateById(dream);

        return doubleUpTight;
    }

    /**
     * 上限取小
     * @param
     * @return
     */
    public ArrayList<Double> UpMin(){
        QueryWrapper<Topsis> topsisQueryWrapper = new QueryWrapper<>();
        topsisQueryWrapper.lambda().isNotNull(Topsis::getId);
        List<Topsis> topsisList = topsisMapper.selectList(topsisQueryWrapper);
        ArrayList<Double> doubleUpTight = new ArrayList<>();

        ArrayList<Double> doubleUpTightA111 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA211 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA311 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA411 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA511 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA611 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA112 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA212 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA312 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA412 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA512 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA612 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA7 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA8 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA9 = new ArrayList<>();

        topsisList.stream().forEach(topsis -> {
            doubleUpTightA111.add(topsis.getA111());
            doubleUpTightA211.add(topsis.getA211());
            doubleUpTightA311.add(topsis.getA311());
            doubleUpTightA411.add(topsis.getA411());
            doubleUpTightA511.add(topsis.getA511());
            doubleUpTightA611.add(topsis.getA611());

            doubleUpTightA112.add(topsis.getA112());
            doubleUpTightA212.add(topsis.getA212());
            doubleUpTightA312.add(topsis.getA312());
            doubleUpTightA412.add(topsis.getA412());
            doubleUpTightA512.add(topsis.getA512());
            doubleUpTightA612.add(topsis.getA612());

            doubleUpTightA7.add(topsis.getA71());
            doubleUpTightA8.add(topsis.getA81());
            doubleUpTightA9.add(topsis.getA91());
        });
        doubleUpTight.add(Collections.min(doubleUpTightA111));
        doubleUpTight.add(Collections.min(doubleUpTightA211));
        doubleUpTight.add(Collections.min(doubleUpTightA311));
        doubleUpTight.add(Collections.min(doubleUpTightA411));
        doubleUpTight.add(Collections.min(doubleUpTightA511));
        doubleUpTight.add(Collections.min(doubleUpTightA611));
        doubleUpTight.add(Collections.min(doubleUpTightA112));
        doubleUpTight.add(Collections.min(doubleUpTightA212));
        doubleUpTight.add(Collections.min(doubleUpTightA312));
        doubleUpTight.add(Collections.min(doubleUpTightA412));
        doubleUpTight.add(Collections.min(doubleUpTightA512));
        doubleUpTight.add(Collections.min(doubleUpTightA612));
        doubleUpTight.add(Collections.min(doubleUpTightA7));
        doubleUpTight.add(Collections.min(doubleUpTightA8));
        doubleUpTight.add(Collections.min(doubleUpTightA9));

        Dream dream = dreamMapper.selectById(2);
        dream.setA111(doubleUpTight.get(0));
        dream.setA211(doubleUpTight.get(1));
        dream.setA311(doubleUpTight.get(2));
        dream.setA411(doubleUpTight.get(3));
        dream.setA511(doubleUpTight.get(4));
        dream.setA611(doubleUpTight.get(5));
        dream.setA112(doubleUpTight.get(6));
        dream.setA212(doubleUpTight.get(7));
        dream.setA312(doubleUpTight.get(8));
        dream.setA412(doubleUpTight.get(9));
        dream.setA512(doubleUpTight.get(10));
        dream.setA612(doubleUpTight.get(11));
        dream.setA71(doubleUpTight.get(12));
        dream.setA81(doubleUpTight.get(13));
        dream.setA91(doubleUpTight.get(14));
        dreamMapper.updateById(dream);
        return doubleUpTight;
    }

    /**
     * 下限取小
     * @param
     * @return
     */
    public ArrayList<Double> downMin(){
        QueryWrapper<Topsis> topsisQueryWrapper = new QueryWrapper<>();
        topsisQueryWrapper.lambda().isNotNull(Topsis::getId);
        List<Topsis> topsisList = topsisMapper.selectList(topsisQueryWrapper);
        ArrayList<Double> doubleUpTight = new ArrayList<>();

        ArrayList<Double> doubleUpTightA111 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA211 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA311 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA411 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA511 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA611 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA112 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA212 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA312 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA412 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA512 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA612 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA7 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA8 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA9 = new ArrayList<>();

        topsisList.stream().forEach(topsis -> {
            doubleUpTightA111.add(topsis.getA121());
            doubleUpTightA211.add(topsis.getA221());
            doubleUpTightA311.add(topsis.getA321());
            doubleUpTightA411.add(topsis.getA421());
            doubleUpTightA511.add(topsis.getA521());
            doubleUpTightA611.add(topsis.getA621());

            doubleUpTightA112.add(topsis.getA122());
            doubleUpTightA212.add(topsis.getA222());
            doubleUpTightA312.add(topsis.getA322());
            doubleUpTightA412.add(topsis.getA422());
            doubleUpTightA512.add(topsis.getA522());
            doubleUpTightA612.add(topsis.getA622());

            doubleUpTightA7.add(topsis.getA72());
            doubleUpTightA8.add(topsis.getA82());
            doubleUpTightA9.add(topsis.getA92());
        });
        doubleUpTight.add(Collections.min(doubleUpTightA111));
        doubleUpTight.add(Collections.min(doubleUpTightA211));
        doubleUpTight.add(Collections.min(doubleUpTightA311));
        doubleUpTight.add(Collections.min(doubleUpTightA411));
        doubleUpTight.add(Collections.min(doubleUpTightA511));
        doubleUpTight.add(Collections.min(doubleUpTightA611));
        doubleUpTight.add(Collections.min(doubleUpTightA112));
        doubleUpTight.add(Collections.min(doubleUpTightA212));
        doubleUpTight.add(Collections.min(doubleUpTightA312));
        doubleUpTight.add(Collections.min(doubleUpTightA412));
        doubleUpTight.add(Collections.min(doubleUpTightA512));
        doubleUpTight.add(Collections.min(doubleUpTightA612));
        doubleUpTight.add(Collections.min(doubleUpTightA7));
        doubleUpTight.add(Collections.min(doubleUpTightA8));
        doubleUpTight.add(Collections.min(doubleUpTightA9));


        Dream dream = dreamMapper.selectById(1);
        dream.setA121(doubleUpTight.get(0));
        dream.setA221(doubleUpTight.get(1));
        dream.setA321(doubleUpTight.get(2));
        dream.setA421(doubleUpTight.get(3));
        dream.setA521(doubleUpTight.get(4));
        dream.setA621(doubleUpTight.get(5));
        dream.setA122(doubleUpTight.get(6));
        dream.setA222(doubleUpTight.get(7));
        dream.setA322(doubleUpTight.get(8));
        dream.setA422(doubleUpTight.get(9));
        dream.setA522(doubleUpTight.get(10));
        dream.setA622(doubleUpTight.get(11));
        dream.setA72(doubleUpTight.get(12));
        dream.setA82(doubleUpTight.get(13));
        dream.setA92(doubleUpTight.get(14));
        dreamMapper.updateById(dream);
        return doubleUpTight;
    }

    /**
     * 下限取大
     * @param
     * @return
     */
    public ArrayList<Double> downMax(){
        QueryWrapper<Topsis> topsisQueryWrapper = new QueryWrapper<>();
        topsisQueryWrapper.lambda().isNotNull(Topsis::getId);
        List<Topsis> topsisList = topsisMapper.selectList(topsisQueryWrapper);
        ArrayList<Double> doubleUpTight = new ArrayList<>();

        ArrayList<Double> doubleUpTightA111 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA211 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA311 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA411 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA511 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA611 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA112 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA212 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA312 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA412 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA512 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA612 = new ArrayList<>();

        ArrayList<Double> doubleUpTightA7 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA8 = new ArrayList<>();
        ArrayList<Double> doubleUpTightA9 = new ArrayList<>();

        topsisList.stream().forEach(topsis -> {
            doubleUpTightA111.add(topsis.getA121());
            doubleUpTightA211.add(topsis.getA221());
            doubleUpTightA311.add(topsis.getA321());
            doubleUpTightA411.add(topsis.getA421());
            doubleUpTightA511.add(topsis.getA521());
            doubleUpTightA611.add(topsis.getA621());

            doubleUpTightA112.add(topsis.getA122());
            doubleUpTightA212.add(topsis.getA222());
            doubleUpTightA312.add(topsis.getA322());
            doubleUpTightA412.add(topsis.getA422());
            doubleUpTightA512.add(topsis.getA522());
            doubleUpTightA612.add(topsis.getA622());

            doubleUpTightA7.add(topsis.getA72());
            doubleUpTightA8.add(topsis.getA82());
            doubleUpTightA9.add(topsis.getA92());
        });
        doubleUpTight.add(Collections.max(doubleUpTightA111));
        doubleUpTight.add(Collections.max(doubleUpTightA211));
        doubleUpTight.add(Collections.max(doubleUpTightA311));
        doubleUpTight.add(Collections.max(doubleUpTightA411));
        doubleUpTight.add(Collections.max(doubleUpTightA511));
        doubleUpTight.add(Collections.max(doubleUpTightA611));
        doubleUpTight.add(Collections.max(doubleUpTightA112));
        doubleUpTight.add(Collections.max(doubleUpTightA212));
        doubleUpTight.add(Collections.max(doubleUpTightA312));
        doubleUpTight.add(Collections.max(doubleUpTightA412));
        doubleUpTight.add(Collections.max(doubleUpTightA512));
        doubleUpTight.add(Collections.max(doubleUpTightA612));
        doubleUpTight.add(Collections.max(doubleUpTightA7));
        doubleUpTight.add(Collections.max(doubleUpTightA8));
        doubleUpTight.add(Collections.max(doubleUpTightA9));

        Dream dream = dreamMapper.selectById(2);
        dream.setA121(doubleUpTight.get(0));
        dream.setA221(doubleUpTight.get(1));
        dream.setA321(doubleUpTight.get(2));
        dream.setA421(doubleUpTight.get(3));
        dream.setA521(doubleUpTight.get(4));
        dream.setA621(doubleUpTight.get(5));
        dream.setA122(doubleUpTight.get(6));
        dream.setA222(doubleUpTight.get(7));
        dream.setA322(doubleUpTight.get(8));
        dream.setA422(doubleUpTight.get(9));
        dream.setA522(doubleUpTight.get(10));
        dream.setA622(doubleUpTight.get(11));
        dream.setA72(doubleUpTight.get(12));
        dream.setA82(doubleUpTight.get(13));
        dream.setA92(doubleUpTight.get(14));
        dreamMapper.updateById(dream);

        return doubleUpTight;
    }

    /**
     * 保存 上限（紧）
     * @param id
     * @param a
     * @param max
     */
    public void saveTightUp(int id , int a, double max){
        Topsis topsis = topsisMapper.selectById(id);
        switch (a){
            case 1:
                topsis.setA112(max);
                break;
            case 2:
                topsis.setA212(max);
                break;
            case 3:
                topsis.setA312(max);
                break;
            case 4:
                topsis.setA412(max);
                break;
            case 5:
                topsis.setA512(max);
                break;
            case 6:
                topsis.setA612(max);
                break;
        }
        topsisMapper.updateById(topsis);
    }

    /**
     * 保存 下限（紧）
     * @param id
     * @param a
     * @param max
     */
    public void saveTightdown(int id , int a, double max){
        Topsis topsis = topsisMapper.selectById(id);
        switch (a){
            case 1:
                topsis.setA121(1-max);
                break;
            case 2:
                topsis.setA221(1-max);
                break;
            case 3:
                topsis.setA321(1-max);
                break;
            case 4:
                topsis.setA421(1-max);
                break;
            case 5:
                topsis.setA521(1-max);
                break;
            case 6:
                topsis.setA621(1-max);
                break;
        }
        topsisMapper.updateById(topsis);
    }

    /**
     * 保存 上限（松）
     * @param id
     * @param a
     * @param max
     */
    public void saveLooseUp(int id , int a, double max){
        Topsis topsis = topsisMapper.selectById(id);
        switch (a){
            case 1:
                topsis.setA111(max);
                break;
            case 2:
                topsis.setA211(max);
                break;
            case 3:
                topsis.setA311(max);
                break;
            case 4:
                topsis.setA411(max);
                break;
            case 5:
                topsis.setA511(max);
                break;
            case 6:
                topsis.setA611(max);
                break;
        }
        topsisMapper.updateById(topsis);
    }


    /**
     * 保存 下限（松）
     * @param id
     * @param a
     * @param max
     */
    public void saveLoosedown(int id , int a, double max){
        Topsis topsis = topsisMapper.selectById(id);
        switch (a){
            case 1:
                topsis.setA122(1-max);
                break;
            case 2:
                topsis.setA222(1-max);
                break;
            case 3:
                topsis.setA322(1-max);
                break;
            case 4:
                topsis.setA422(1-max);
                break;
            case 5:
                topsis.setA522(1-max);
                break;
            case 6:
                topsis.setA622(1-max);
                break;
        }
        topsisMapper.updateById(topsis);
    }

}
