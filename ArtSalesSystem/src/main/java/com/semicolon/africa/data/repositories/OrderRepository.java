package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
