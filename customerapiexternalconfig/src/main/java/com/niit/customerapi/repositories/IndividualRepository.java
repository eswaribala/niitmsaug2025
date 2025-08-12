package com.niit.customerapi.repositories;

import com.niit.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
}
