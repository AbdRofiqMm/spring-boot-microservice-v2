package com.dailyCodeBuffer.PaymentService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailyCodeBuffer.PaymentService.entity.TransactionDetails;
import com.dailyCodeBuffer.PaymentService.model.PaymentRequest;
import com.dailyCodeBuffer.PaymentService.repository.TransactionalDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionalDetailsRepository transactionalDetailsRepository;

    @Override
    public Object doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        transactionalDetailsRepository.save(transactionDetails);
        log.info("Transaction Completed with Id: {}", transactionDetails.getId());
        return transactionDetails.getId();

    }

}
