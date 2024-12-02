package com.tcs.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepo extends JpaRepository<Customer , String>{

}
