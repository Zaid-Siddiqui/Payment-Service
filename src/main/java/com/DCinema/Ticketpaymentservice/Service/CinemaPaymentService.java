package com.DCinema.Ticketpaymentservice.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DCinema.Ticketpaymentservice.Entity.CinemaPayment;
import com.DCinema.Ticketpaymentservice.Repository.CinemaPaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CinemaPaymentService {

    @Autowired

    private CinemaPaymentRepository ticketPaymentRepository;



    private Logger log=LoggerFactory.getLogger(CinemaPaymentService.class);

    public CinemaPayment doTicketPayment(CinemaPayment payment) throws JsonProcessingException {
        payment.setPaymentStatus((paymentProcessing()));
        payment.setTransactionId(UUID.randomUUID().toString());
        log.info("CinemaPaymentService Request: {}",new ObjectMapper().writeValueAsString(payment));

        return ticketPaymentRepository.save(payment);
    }

    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "false";
    }

    public CinemaPayment findPaymentHistoryByTicketId(int ticketId) throws JsonProcessingException {
        CinemaPayment payment =ticketPaymentRepository.findByTicketId(ticketId);
        log.info("CinemaPaymentService Request: {}",new ObjectMapper().writeValueAsString(payment));

        return payment;
    }
}
