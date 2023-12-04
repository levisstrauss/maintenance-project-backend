package com.codemon.maintenance.controller;
import com.codemon.maintenance.entity.MaintenanceRequest;
import com.codemon.maintenance.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/requests")
public class MaintenanceRequestController {

    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public void setMaintenanceRequestService(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @CrossOrigin
    @GetMapping
    public List<MaintenanceRequest> getAllMaintenanceRequests() {
        return maintenanceRequestService.getAllMaintenanceRequests();
    }

    @CrossOrigin
    @PostMapping
    public MaintenanceRequest submitMaintenanceRequest(@RequestBody MaintenanceRequest maintenanceRequest) {
        return maintenanceRequestService.saveMaintenanceRequest(maintenanceRequest);

    }

    @CrossOrigin
    @PutMapping("/{id}")
    public MaintenanceRequest updateStatus(@PathVariable Long id, @RequestBody MaintenanceRequest maintenanceRequest) {
        return maintenanceRequestService.changeStatus(id, maintenanceRequest);
    }

}