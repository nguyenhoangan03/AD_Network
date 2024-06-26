package com.adcompany.AD_Telecom.mapper;

import com.adcompany.AD_Telecom.entity.City;
import com.adcompany.AD_Telecom.entity.Province;
import com.adcompany.AD_Telecom.model.CityModel;
import com.adcompany.AD_Telecom.model.ProvinceModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DistrictMapper {
    ProvinceModel toProvinceModel(Province province);

    Province toProvince(Province province);
}
