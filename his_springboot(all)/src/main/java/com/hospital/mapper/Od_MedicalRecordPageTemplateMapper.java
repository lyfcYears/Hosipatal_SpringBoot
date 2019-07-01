package com.hospital.mapper;

import java.util.List;

import com.hospital.model.od.MedicalRecordPageTemplate;
import com.hospital.model.od.MedicalRecordPageTemplateExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Od_MedicalRecordPageTemplateMapper {
    long countByExample(MedicalRecordPageTemplateExample example);

    int deleteByExample(MedicalRecordPageTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecordPageTemplate record);

    int insertSelective(MedicalRecordPageTemplate record);

    List<MedicalRecordPageTemplate> selectByExample(MedicalRecordPageTemplateExample example);

    MedicalRecordPageTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicalRecordPageTemplate record, @Param("example") MedicalRecordPageTemplateExample example);

    int updateByExample(@Param("record") MedicalRecordPageTemplate record, @Param("example") MedicalRecordPageTemplateExample example);

    int updateByPrimaryKeySelective(MedicalRecordPageTemplate record);

    int updateByPrimaryKey(MedicalRecordPageTemplate record);
}