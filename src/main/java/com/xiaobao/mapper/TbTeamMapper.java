package com.xiaobao.mapper;

import com.xiaobao.pojo.TbTeam;
import com.xiaobao.pojo.TbTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTeamMapper {
    int countByExample(TbTeamExample example);

    int deleteByExample(TbTeamExample example);

    int deleteByPrimaryKey(Integer teamid);

    int insert(TbTeam record);

    int insertSelective(TbTeam record);

    List<TbTeam> selectByExample(TbTeamExample example);

    TbTeam selectByPrimaryKey(Integer teamid);

    int updateByExampleSelective(@Param("record") TbTeam record, @Param("example") TbTeamExample example);

    int updateByExample(@Param("record") TbTeam record, @Param("example") TbTeamExample example);

    int updateByPrimaryKeySelective(TbTeam record);

    int updateByPrimaryKey(TbTeam record);
}