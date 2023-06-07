package com.qinmingxuan.fuzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinmingxuan.fuzzy.entity.Dream;
import com.qinmingxuan.fuzzy.entity.Topsis;
import com.qinmingxuan.fuzzy.entity.Weight;
import com.qinmingxuan.fuzzy.mapper.DreamMapper;
import com.qinmingxuan.fuzzy.mapper.TopsisMapper;
import com.qinmingxuan.fuzzy.mapper.WeightMapper;
import com.qinmingxuan.fuzzy.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class DreamServiceImpl extends ServiceImpl<DreamMapper, Dream> implements DreamService {

    @Autowired
    private DreamMapper dreamMapper;

    @Autowired
    private DreamService dreamService;

    @Autowired
    private TopsisMapper topsisMapper;

    @Autowired
    private WeightMapper weightMapper;

    @Override
    public ArrayList<Double> fuzzyMinMax(int supplyId, int dreamId){
        Topsis topsis = topsisMapper.selectById(supplyId);
        Dream dream = dreamMapper.selectById(dreamId);

        double dreamA111 = dream.getA111();
        double dreamA112 = dream.getA112();
        double dreamA121 = dream.getA121();
        double dreamA122 = dream.getA122();
        double topsisA111 = topsis.getA111();
        double topsisA112 = topsis.getA112();
        double topsisA121 = topsis.getA121();
        double topsisA122 = topsis.getA122();

        double A111 = dreamA111 - topsisA111;
        double A112 = dreamA112 - topsisA112;
        double A121 = dreamA121 - topsisA121;
        double A122 = dreamA122 - topsisA122;


        double dreamA211 = dream.getA211();
        double dreamA212 = dream.getA212();
        double dreamA221 = dream.getA221();
        double dreamA222 = dream.getA222();
        double topsisA211 = topsis.getA211();
        double topsisA212 = topsis.getA212();
        double topsisA221 = topsis.getA221();
        double topsisA222 = topsis.getA222();

        double A211 = dreamA211 - topsisA211;
        double A212 = dreamA212 - topsisA212;
        double A221 = dreamA221 - topsisA221;
        double A222 = dreamA222 - topsisA222;


        double dreamA311 = dream.getA311();
        double dreamA312 = dream.getA312();
        double dreamA321 = dream.getA321();
        double dreamA322 = dream.getA322();
        double topsisA311 = topsis.getA311();
        double topsisA312 = topsis.getA312();
        double topsisA321 = topsis.getA321();
        double topsisA322 = topsis.getA322();

        double A311 = dreamA311 - topsisA311;
        double A312 = dreamA312 - topsisA312;
        double A321 = dreamA321 - topsisA321;
        double A322 = dreamA322 - topsisA322;


        double dreamA411 = dream.getA411();
        double dreamA412 = dream.getA412();
        double dreamA421 = dream.getA421();
        double dreamA422 = dream.getA422();
        double topsisA411 = topsis.getA411();
        double topsisA412 = topsis.getA412();
        double topsisA421 = topsis.getA421();
        double topsisA422 = topsis.getA422();

        double A411 = dreamA411 - topsisA411;
        double A412 = dreamA412 - topsisA412;
        double A421 = dreamA421 - topsisA421;
        double A422 = dreamA422 - topsisA422;


        double dreamA511 = dream.getA511();
        double dreamA512 = dream.getA512();
        double dreamA521 = dream.getA521();
        double dreamA522 = dream.getA522();
        double topsisA511 = topsis.getA511();
        double topsisA512 = topsis.getA512();
        double topsisA521 = topsis.getA521();
        double topsisA522 = topsis.getA522();

        double A511 = dreamA511 - topsisA511;
        double A512 = dreamA512 - topsisA512;
        double A521 = dreamA521 - topsisA521;
        double A522 = dreamA522 - topsisA522;


        double dreamA611 = dream.getA611();
        double dreamA612 = dream.getA612();
        double dreamA621 = dream.getA621();
        double dreamA622 = dream.getA622();
        double topsisA611 = topsis.getA611();
        double topsisA612 = topsis.getA612();
        double topsisA621 = topsis.getA621();
        double topsisA622 = topsis.getA622();

        double A611 = dreamA611 - topsisA611;
        double A612 = dreamA612 - topsisA612;
        double A621 = dreamA621 - topsisA621;
        double A622 = dreamA622 - topsisA622;


        double dreamA71 = dream.getA71();
        double dreamA72 = dream.getA72();
        double topsisA71 = topsis.getA71();
        double topsisA72 = topsis.getA72();

        double A71 = dreamA71 - topsisA71;
        double A72 = dreamA72 - topsisA72;


        double dreamA81 = dream.getA81();
        double dreamA82 = dream.getA82();
        double topsisA81 = topsis.getA81();
        double topsisA82 = topsis.getA82();

        double A81 = dreamA81 - topsisA81;
        double A82 = dreamA82 - topsisA82;


        double dreamA91 = dream.getA91();
        double dreamA92 = dream.getA92();
        double topsisA91 = topsis.getA91();
        double topsisA92 = topsis.getA92();

        double A91 = dreamA91 - topsisA91;
        double A92 = dreamA92 - topsisA92;


        double a1 = Math.sqrt(0.25 * (Math.pow(A111, 2) + Math.pow(A112, 2) + Math.pow(A121, 2) + Math.pow(A122, 2)));
        double a2 = Math.sqrt(0.25 * (Math.pow(A211, 2) + Math.pow(A212, 2) + Math.pow(A221, 2) + Math.pow(A222, 2)));
        double a3 = Math.sqrt(0.254 * (Math.pow(A311, 2) + Math.pow(A312, 2) + Math.pow(A321, 2) + Math.pow(A322, 2)));
        double a4 = Math.sqrt(0.25 * (Math.pow(A411, 2) + Math.pow(A412, 2) + Math.pow(A421, 2) + Math.pow(A422, 2)));
        double a5 = Math.sqrt(0.25 * (Math.pow(A511, 2) + Math.pow(A512, 2) + Math.pow(A521, 2) + Math.pow(A522, 2)));
        double a6 = Math.sqrt(0.25 * (Math.pow(A611, 2) + Math.pow(A612, 2) + Math.pow(A621, 2) + Math.pow(A622, 2)));
        double a7 = Math.sqrt(0.5 * (Math.pow(A71, 2) + Math.pow(A72, 2)));
        double a8 = Math.sqrt(0.5 * (Math.pow(A81, 2) + Math.pow(A82, 2)));
        double a9 = Math.sqrt(0.5 * (Math.pow(A91, 2) + Math.pow(A92, 2)));

        ArrayList<Double> fuzzyDouble = new ArrayList<>();
        fuzzyDouble.add(a1);
        fuzzyDouble.add(a2);
        fuzzyDouble.add(a3);
        fuzzyDouble.add(a4);
        fuzzyDouble.add(a5);
        fuzzyDouble.add(a6);
        fuzzyDouble.add(a7);
        fuzzyDouble.add(a8);
        fuzzyDouble.add(a9);

        return fuzzyDouble;
    }

    /**
     * 正理想解距离最小值
     * @return
     */
    @Override
    public Double fuzzyMinC(){
        ArrayList<Double> fuzzy = new ArrayList<>();
        //总共6个供应商
        for (int i = 1; i < 7; i++) {
            ArrayList<Double> supply = fuzzyMinMax(i,1);
            Double min = Collections.min(supply);
            fuzzy.add(min);
        }
        Double min = Collections.min(fuzzy);
        return min;
    }

    /**
     * 正理想解距离最大值
     * @return
     */
    @Override
    public Double fuzzyMaxC(){
        ArrayList<Double> fuzzy = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            ArrayList<Double> supply = fuzzyMinMax(i,1);
            Double max = Collections.max(supply);
            fuzzy.add(max);
        }
        Double max = Collections.max(fuzzy);
        return max;
    }

    /**
     * 负理想解距离最小值
     * @return
     */
    @Override
    public Double fuzzyMinN(){
        ArrayList<Double> fuzzy = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            ArrayList<Double> supply = fuzzyMinMax(i,2);
            Double min = Collections.min(supply);
            fuzzy.add(min);
        }
        Double min = Collections.min(fuzzy);
        return min;
    }

    /**
     * 负理想解距离最大值
     * @return
     */
    @Override
    public Double fuzzyMaxN(){
        ArrayList<Double> fuzzy = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            ArrayList<Double> supply = fuzzyMinMax(i,2);
            Double max = Collections.max(supply);
            fuzzy.add(max);
        }
        double max = Collections.max(fuzzy);
        return max;
    }

    /**
     * 第supplyId的正理想解关联系数
     * @return
     */
    @Override
    public ArrayList<Double> GRAC(int supplyId, double R){
        double maxC = fuzzyMaxC();
        double minC = fuzzyMinC();

        ArrayList<Double> GRA = new ArrayList<>();
        ArrayList<Double> supplyFuzzy = fuzzyMinMax(supplyId, 1);

        //总共9个指标
        for (int i = 0; i < 9; i++) {
            double I = supplyFuzzy.get(i);
            double IGRA = (minC + R * maxC) / ( I + R * maxC);
            GRA.add(IGRA);
        }

        return GRA;
    }

    /**
     * 第supplyId的负理想解关联系数
     * @return
     */
    @Override
    public ArrayList<Double> GRAN(int supplyId, double R){
        Double maxN = fuzzyMaxN();
        Double minN = fuzzyMinN();

        ArrayList<Double> GRA = new ArrayList<>();
        ArrayList<Double> supplyFuzzy = fuzzyMinMax(supplyId, 1);

        //总共9个指标
        for (int i = 0; i < 9; i++) {
            double I = supplyFuzzy.get(i);
            double IGRA = (minN + R * maxN) / ( I + R * maxN);
            GRA.add(IGRA);
        }

        return GRA;
    }


    /**
     * 加权后的正理想解系数
     * @param supplyId
     * @param R
     * @return
     */
    @Override
    public Double WeightGRAC(int supplyId, double R){
        ArrayList<Double> GRAC = GRAC(supplyId, R);
        ArrayList<Double> weightIdex = weightIndex();
        double weightGRA = 0.0;
        //9个指标
        for (int i = 0; i < 9; i++) {
            double AI = GRAC.get(i);
            double weightI = weightIdex.get(i);
            weightGRA = weightGRA + AI * weightI;
        }
        return weightGRA;
    }

    /**
     * 加权后的负理想解系数
     * @param supplyId
     * @param R
     * @return
     */
    @Override
    public Double WeightGRAN(int supplyId, double R){
        ArrayList<Double> GRAN = GRAN(supplyId, R);
        ArrayList<Double> weightIdex = weightIndex();
        Double weightGRA = 0.0;
        //9个指标
        for (int i = 0; i < 9; i++) {
            Double AI = GRAN.get(i);
            Double weightI = weightIdex.get(i);
            weightGRA = weightGRA + AI * weightI;
        }
        return weightGRA;
    }


    /**
     * 计算贴近值
     * @param supplyId
     * @param R
     * @return
     */
    @Override
    public Double TOPSISGRA(int supplyId, double R){
        Double GRAC = WeightGRAC(supplyId, R);
        Double GRAN = WeightGRAN(supplyId, R);

        double topsisGRA = GRAC / (GRAC + GRAN);
        return topsisGRA;
    }



    /**
     * 各指标的权重
     * @return
     */
    public ArrayList<Double> weightIndex(){
        Weight weight = weightMapper.selectById(1);
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(weight.getA1());
        doubles.add(weight.getA2());
        doubles.add(weight.getA3());
        doubles.add(weight.getA4());
        doubles.add(weight.getA5());
        doubles.add(weight.getA6());
        doubles.add(weight.getA7());
        doubles.add(weight.getA8());
        doubles.add(weight.getA9());
        return doubles;
    }



}
