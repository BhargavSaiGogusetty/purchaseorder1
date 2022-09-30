package com.ros.inventory.mapper;

import com.ros.inventory.controller.dto.RejectedDto;
import com.ros.inventory.controller.dto.RejectedDto.RejectedDtoBuilder;
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
public class RejectedProductMapperImpl implements RejectedProductMapper {

    @Override
    public RejectedDto convertToRejectedDto(PurchaseOrder purchase) {
        if ( purchase == null ) {
            return null;
        }

        RejectedDtoBuilder rejectedDto = RejectedDto.builder();

        rejectedDto.supplierName( purchaseSupplierSupplierBasicSupplierBusinessName( purchase ) );
        SupplierType supplierType = purchaseSupplierSupplierType( purchase );
        if ( supplierType != null ) {
            rejectedDto.supplierType( supplierType.name() );
        }
        rejectedDto.purchasedNumber( purchase.getPurchasedId() );
        if ( purchase.getPurchaseOrderDate() != null ) {
            rejectedDto.purchaseDate( DateTimeFormatter.ISO_LOCAL_DATE.format( purchase.getPurchaseOrderDate() ) );
        }
        rejectedDto.RejectionDate( purchase.getPurchaseRejectedDate() );

        return rejectedDto.build();
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
