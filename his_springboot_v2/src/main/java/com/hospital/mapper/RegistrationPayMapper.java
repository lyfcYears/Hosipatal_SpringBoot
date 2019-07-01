package com.hospital.mapper;

import com.hospital.model.sf.RegistrationPay;
import com.hospital.model.sf.RegistrationPayExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RegistrationPayMapper {
    long countByExample(RegistrationPayExample example);

    int deleteByExample(RegistrationPayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegistrationPay record);

    int insertSelective(RegistrationPay record);

    List<RegistrationPay> selectByExample(RegistrationPayExample example);

    RegistrationPay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegistrationPay record, @Param("example") RegistrationPayExample example);

    int updateByExample(@Param("record") RegistrationPay record, @Param("example") RegistrationPayExample example);

    int updateByPrimaryKeySelective(RegistrationPay record);

    int updateByPrimaryKey(RegistrationPay record);
}