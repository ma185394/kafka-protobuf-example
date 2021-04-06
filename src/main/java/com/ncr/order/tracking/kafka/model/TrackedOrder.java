package com.ncr.order.tracking.kafka.model;

//import com.ncr.order.tracking.kafka.converter.LogBodyConverter;
import com.ncr.order.tracking.kafka.converter.LogBodyConverter;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * OrderTracking model
 *
 * @author ma185394
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "ORDERS", schema = "tracked_orders")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class TrackedOrder implements Serializable {

    /**
     *  Default serial version Id
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id of the order
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    /**
     * The id of the order from Pulse
     */
    @Column(name = "tracked_order_id")
    private String trackedOrderId;

    /**
     * Organization of order
     */
    @Column(name = "organization")
    private String organization;

    /**
     * The body from the Log Message
     */
    @Convert(converter = LogBodyConverter.class, attributeName = "logBody")
//    @Type(type = "jsonb")
    @Column(name = "tracked_order_body")
//    @Embedded
    private LogMessageProto.LogBody trackedOrderBody;

    /**
     * The unique identifier of the site
     */
    @Column(name = "site_id")
    private String siteId;

    /**
     * The date the tracked order was created
     */
    @Column(name = "date_created")
    private Date dateCreated;

}
