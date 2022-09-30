package com.ros.inventory.mapper;

import com.ros.inventory.controller.dto.ApprovedDto;
import com.ros.inventory.controller.dto.ApprovedDto.ApprovedDtoBuilder;
import com.ros.inventory.entities.PurchaseOrder;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.entities.SupplierBasicInfo;
import com.ros.inventory.entities.SupplierType;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-29T14:46:45+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class ApprovedMapperImpl implements ApprovedMapper {

    @Override
    public ApprovedDto convertToApprovedDto(PurchaseOrder purchase) {
        if ( purchase == null ) {
            return null;
        }

        ApprovedDtoBuilder approvedDto = ApprovedDto.builder();

        approvedDto.supplierName( purchaseSupplierSupplierBasicSupplierBusinessName( purchase ) );
        SupplierType supplierType = purchaseSupplierSupplierType( purchase );
        if ( supplierType != null ) {
            approvedDto.supplierType( supplierType.name() );
        }
        approvedDto.purchasedNumber( purchase.getPurchasedId() );
        if ( purchase.getPurchaseOrderDate() != null ) {
            approvedDto.purchaseDate( DateTimeFormatter.ISO_LOCAL_DATE.format( purchase.getPurchaseOrderDate() ) );
        }
        approvedDto.status( purchase.getPurchaseOrderStatus() );

        return approvedDto.build();
    }

    private String purchaseSupplierSupplierBasicSupplierBusinessName(PurchaseOrder purchaseOrder) {
        if ( purchaseOrder == null ) {
            return null;
        }
        Supplier supplier = purchaseOrder.getSupplier();
        if ( supplier == null ) {
            return null;
        }
        SupplierBasicInfo supplierBasic = supplier.getSupplierBasic();
        if ( supplierBasic == null ) {
            return null;
        }
        String supplierBusinessName = supplierBasic.getSupplierBusinessName();
        if ( supplierBusinessName == null ) {
            return null;
        }
        return supplierBusinessName;
    }

    private SupplierType purchaseSupplierSupplierType(PurchaseOrder purchaseOrder) {
        if ( purchaseOrder == null ) {
            return null;
        }
        Supplier supplier = purchaseOrder.getSupplier();
        if ( supplier == null ) {
            return null;
        }
        SupplierType supplierType = supplier.getSupplierType();
        if ( supplierType == null ) {
            return null;
        }
        return supplierType;
    }
}
