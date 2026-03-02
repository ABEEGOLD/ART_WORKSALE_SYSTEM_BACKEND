package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
