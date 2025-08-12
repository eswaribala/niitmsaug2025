package com.niit.customerapi.repositories;

import com.niit.customerapi.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
