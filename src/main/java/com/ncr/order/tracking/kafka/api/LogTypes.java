package com.ncr.order.tracking.kafka.api;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum  LogTypes {

    LOG_MESSAGE("log_message"),
    JOURNAL_EVENT("journal_event"),
    ORDER_TRACKING("order_tracking");

    private String logType;

   @Override
    public String toString() {
       return this.logType;
   }
}
