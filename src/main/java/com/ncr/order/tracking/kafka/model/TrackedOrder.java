package com.ncr.order.tracking.kafka.model;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * OrderTracking model
 *
 * @author ma185394
 */
@Data
@Entity
@NoArgsConstructor
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

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    /**
     * The id from Pulse
     */
    @Column(name = "tracked_order_id")
    private String trackedOrderId;

    /**
     * Organization from the order
     */
    @Column(name = "organization")
    private String organization;

    /**
     * The body of the Log Message
     */
    @Type(type = "jsonb")
    @Column(name = "payload", columnDefinition = "jsonb")
    private String payload;

    /**
     * The unique identifier of the site
     */
    @Column(name = "site_id")
    private String siteId;

    /**
     * Timestamp when this message came into existence
     */
    @Column(name = "updated_date")
    private Instant updatedDate;
}

