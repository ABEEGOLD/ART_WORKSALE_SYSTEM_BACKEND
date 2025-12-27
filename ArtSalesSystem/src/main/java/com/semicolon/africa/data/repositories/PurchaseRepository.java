package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends  JpaRepository<Purchase,Long> {

}
