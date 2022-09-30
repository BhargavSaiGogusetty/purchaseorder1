package com.ros.inventory.mapper;

import com.ros.inventory.controller.dto.wastageDto;
import com.ros.inventory.entities.Wastage;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-29T14:46:45+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class wastageDtoMapperImpl implements wastageDtoMapper {

    @Override
    public wastageDto convertToDto(Wastage product) {
        if ( product == null ) {
            return null;
        }

        wastageDto wastageDto = new wastageDto();

        wastageDto.setWastageId( product.getWastageId() );
        wastageDto.setProductCode( product.getProductCode() );
        wastageDto.setProductName( product.getProductName() );
        wastageDto.setPricePerUnit( product.getPricePerUnit() );
        wastageDto.setUnitMeasurement( product.getUnitMeasurement() );
        wastageDto.setQty( product.getQty() );

        return wastageDto;
    }

    @Override
    public Wastage convertToEntity(wastageDto product) {
        if ( product == null ) {
            return null;
        }

        Wastage wastage = new Wastage();

        wastage.setWastageId( product.getWastageId() );
        wastage.setProductCode( product.getProductCode() );
        wastage.setProductName( product.getProductName() );
        wastage.setPricePerUnit( product.getPricePerUnit() );
        wastage.setUnitMeasurement( product.getUnitMeasurement() );
        wastage.setQty( product.getQty() );

        return wastage;
    }
}
