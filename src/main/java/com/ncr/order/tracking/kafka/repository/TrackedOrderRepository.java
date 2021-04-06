package com.ncr.order.tracking.kafka.repository;

import com.ncr.order.tracking.kafka.model.TrackedOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackedOrderRepository extends CrudRepository<TrackedOrder, String> {
}
