package com.ncr.order.tracking.kafka.model;

import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Log Body model
 *
 * @author ma185394
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody implements Serializable {
    /**
     *  Default serial version Id
     */
    private static final long serialVersionUID = 1L;

    private LogMessageProto.LogBody.SeverityLevels severityLevels;

    private String logName;

    /**
     * Name of the application that created this message.
     */
//    @Column(name = "application_info")
    private String applicationName;

    private String message;


    /**
     * Additional log labels to be associated with the log message
     */
//    @Type(type = "jsonb")
//    @Column(name = "log_body_labels", columnDefinition = "jsonb")
    private HashMap<String, String> labels;

    private String correlationId;

    private LogMessageProto.LogBody.LogTypes logTypes;


}
