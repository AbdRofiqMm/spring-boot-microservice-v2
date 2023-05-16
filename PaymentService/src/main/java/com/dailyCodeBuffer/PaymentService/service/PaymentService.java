package com.dailyCodeBuffer.PaymentService.service;

import com.dailyCodeBuffer.PaymentService.model.PaymentRequest;

public interface PaymentService {

    Object doPayment(PaymentRequest paymentRequest);

}
