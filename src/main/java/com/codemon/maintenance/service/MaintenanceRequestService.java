package com.codemon.maintenance.service;

import com.codemon.maintenance.entity.MaintenanceRequest;
import com.codemon.maintenance.repository.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceRequestService {

    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;

    public List<MaintenanceRequest> getAllMaintenanceRequests() {
        return (List<MaintenanceRequest>) maintenanceRequestRepository.findAll();
    }

    public MaintenanceRequest saveMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
        return maintenanceRequestRepository.save(maintenanceRequest);
    }

    public MaintenanceRequest changeStatus(Long id, MaintenanceRequest maintenanceRequest) {
        MaintenanceRequest existingMaintenanceRequest = maintenanceRequestRepository.findById(id).orElse(null);
        assert existingMaintenanceRequest != null;
        existingMaintenanceRequest.setStatus(maintenanceRequest.getStatus());
        return maintenanceRequestRepository.save(existingMaintenanceRequest);
    }

}