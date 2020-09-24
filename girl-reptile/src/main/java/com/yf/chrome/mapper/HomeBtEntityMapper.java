package com.yf.chrome.mapper;

import com.yf.chrome.model.HomeBtEntity;
import com.yf.chrome.model.HomeBtEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeBtEntityMapper {
    long countByExample(HomeBtEntityExample example);

    int deleteByExample(HomeBtEntityExample example);

    int insert(HomeBtEntity record);

    int insertSelective(HomeBtEntity record);

    HomeBtEntity selectOneByExample(HomeBtEntityExample example);

    HomeBtEntity selectOneByExampleWithBLOBs(HomeBtEntityExample example);

    List<HomeBtEntity> selectByExampleWithBLOBs(HomeBtEntityExample example);

    List<HomeBtEntity> selectByExample(HomeBtEntityExample example);

    int updateByExampleSelective(@Param("record") HomeBtEntity record, @Param("example") HomeBtEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") HomeBtEntity record, @Param("example") HomeBtEntityExample example);

    int updateByExample(@Param("record") HomeBtEntity record, @Param("example") HomeBtEntityExample example);
}