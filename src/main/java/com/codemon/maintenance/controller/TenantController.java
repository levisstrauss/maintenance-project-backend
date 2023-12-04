package com.codemon.maintenance.controller;
import com.codemon.maintenance.entity.Tenant;
import com.codemon.maintenance.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tenants")
public class TenantController {

        private TenantService tenantService;

        @Autowired
        public void setTenantService(TenantService tenantService) {
            this.tenantService =  tenantService;
        }

        @CrossOrigin
        @GetMapping
        public List<Tenant> getAllTenants() {
            return tenantService.getAllTenants();
        }

        @CrossOrigin
        @GetMapping("/{id}")
        public Tenant getTenantById(@PathVariable String id) {
            return tenantService.getTenantById(id);
        }

        @CrossOrigin
        @PostMapping
        public Tenant addTenant(@RequestBody Tenant tenant) {
            return tenantService.saveTenant(tenant);

        }

        @CrossOrigin
        @DeleteMapping("/{id}")
        public void deleteTenantById(@PathVariable String id) {
            tenantService.deleteTenantById(id);
        }

        @CrossOrigin
        @PutMapping("/{id}")
        public Tenant moveTenant(@PathVariable String id, @RequestBody Tenant tenant) {
            return tenantService.moveTenant(id, tenant);
        }

}

