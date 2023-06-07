package com.qinmingxuan.fuzzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinmingxuan.fuzzy.entity.Dream;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper
public interface DreamMapper extends BaseMapper<Dream> {
}
