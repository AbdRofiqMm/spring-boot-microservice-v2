package com.dailyCodeBuffer.PaymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailyCodeBuffer.PaymentService.entity.TransactionDetails;

@Repository
public interface TransactionalDetailsRepository extends JpaRepository<TransactionDetails, Long> {

}
