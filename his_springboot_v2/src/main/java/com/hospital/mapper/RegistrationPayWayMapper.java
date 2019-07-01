package com.hospital.mapper;

import com.hospital.model.sf.RegistrationPayWay;
import com.hospital.model.sf.RegistrationPayWayExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RegistrationPayWayMapper {
    long countByExample(RegistrationPayWayExample example);

    int deleteByExample(RegistrationPayWayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegistrationPayWay record);

    int insertSelective(RegistrationPayWay record);

    List<RegistrationPayWay> selectByExample(RegistrationPayWayExample example);

    RegistrationPayWay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegistrationPayWay record, @Param("example") RegistrationPayWayExample example);

    int updateByExample(@Param("record") RegistrationPayWay record, @Param("example") RegistrationPayWayExample example);

    int updateByPrimaryKeySelective(RegistrationPayWay record);

    int updateByPrimaryKey(RegistrationPayWay record);
}