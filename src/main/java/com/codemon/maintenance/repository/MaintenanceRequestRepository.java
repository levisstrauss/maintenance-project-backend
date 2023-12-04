package com.codemon.maintenance.repository;

import com.codemon.maintenance.entity.MaintenanceRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaintenanceRequestRepository extends CrudRepository<MaintenanceRequest, Long> {
}