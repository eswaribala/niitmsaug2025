package com.niit.customerapi.repositories;

import com.niit.customerapi.models.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepository extends JpaRepository<Corporate,Long> {
}
