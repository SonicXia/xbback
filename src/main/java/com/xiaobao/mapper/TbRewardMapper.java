package com.xiaobao.mapper;

import com.xiaobao.pojo.TbReward;
import com.xiaobao.pojo.TbRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRewardMapper {
    int countByExample(TbRewardExample example);

    int deleteByExample(TbRewardExample example);

    int deleteByPrimaryKey(String mobile);

    int insert(TbReward record);

    int insertSelective(TbReward record);

    List<TbReward> selectByExample(TbRewardExample example);

    TbReward selectByPrimaryKey(String mobile);

    int updateByExampleSelective(@Param("record") TbReward record, @Param("example") TbRewardExample example);

    int updateByExample(@Param("record") TbReward record, @Param("example") TbRewardExample example);

    int updateByPrimaryKeySelective(TbReward record);

    int updateByPrimaryKey(TbReward record);
}