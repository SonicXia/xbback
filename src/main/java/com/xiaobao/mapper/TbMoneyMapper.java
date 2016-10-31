package com.xiaobao.mapper;

import com.xiaobao.pojo.TbMoney;
import com.xiaobao.pojo.TbMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMoneyMapper {
    int countByExample(TbMoneyExample example);

    int deleteByExample(TbMoneyExample example);

    int insert(TbMoney record);

    int insertSelective(TbMoney record);

    List<TbMoney> selectByExample(TbMoneyExample example);

    int updateByExampleSelective(@Param("record") TbMoney record, @Param("example") TbMoneyExample example);

    int updateByExample(@Param("record") TbMoney record, @Param("example") TbMoneyExample example);
}