package com.ncr.order.tracking.kafka.mapstruct;

import com.ncr.order.tracking.kafka.model.TrackedOrder;

import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = InstantMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTrackingKafkaMapper {
    @Mapping(target = "trackedOrderId", source = "body.correlationId")
    @Mapping(target = "updatedDate", source = "timeUtc")
    TrackedOrder logMessageProtoToTrackedOrder(LogMessageProto.LogMessage message);


    @AfterMapping
    default void protoMessageToTrackedOrderAfter(LogMessageProto.LogMessage message, @MappingTarget TrackedOrder trackedOrder) {
        if (message.getSiteInfo() != null && message.getSiteInfo().getSiteIdsList() != null) {
            for (LogMessageProto.SiteIdentification site : message.getSiteInfo().getSiteIdsList()) {
                setTrackedOrderAndSiteId(site, trackedOrder);
                }
            }
        }

    default void setTrackedOrderAndSiteId(LogMessageProto.SiteIdentification sites, TrackedOrder trackedOrder){
        switch(sites.getIdType()){
            case BSP_EU_ID:
                trackedOrder.setSiteId(sites.getId());
                break;

            case BSP_COMPANY_ID:
                trackedOrder.setOrganization(sites.getId());
                break;
        }
    }
}
