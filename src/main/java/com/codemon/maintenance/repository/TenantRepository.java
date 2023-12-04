package com.codemon.maintenance.repository;
import com.codemon.maintenance.entity.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends CrudRepository<Tenant, String> {
}
