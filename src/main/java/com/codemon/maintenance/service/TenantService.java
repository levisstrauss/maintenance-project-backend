package com.codemon.maintenance.service;

import com.codemon.maintenance.entity.Tenant;
import com.codemon.maintenance.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public List<Tenant> getAllTenants() {
        return (List<Tenant>) tenantRepository.findAll();
    }

    public Tenant getTenantById(String id) {
        return tenantRepository.findById(id).orElse(null);
    }


    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);

    }

    public void deleteTenantById(String id) {
        tenantRepository.deleteById(id);
    }

    public Tenant moveTenant(String id, Tenant tenant) {
        Tenant existingTenant = tenantRepository.findById(id).orElse(null);
        assert existingTenant != null;
        existingTenant.setFirstName(tenant.getFirstName());
        existingTenant.setLastName(tenant.getLastName());
        existingTenant.setPhoneNumber(tenant.getPhoneNumber());
        existingTenant.setEmail(tenant.getEmail());
        existingTenant.setCheckIn(tenant.getCheckIn());
        existingTenant.setCheckOut(tenant.getCheckOut());
        existingTenant.setApartmentNumber(tenant.getApartmentNumber());
        return tenantRepository.save(existingTenant);
    }
}
