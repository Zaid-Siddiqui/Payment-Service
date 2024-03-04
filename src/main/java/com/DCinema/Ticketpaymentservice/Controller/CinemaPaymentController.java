package com.DCinema.Ticketpaymentservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DCinema.Ticketpaymentservice.Entity.CinemaPayment;
import com.DCinema.Ticketpaymentservice.Service.CinemaPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/payment")
public class CinemaPaymentController {
    @Autowired
    private CinemaPaymentService service;

    @PostMapping("/paymentdone")
    public CinemaPayment paymentdone(@RequestBody CinemaPayment payment) throws JsonProcessingException {
        return service.doTicketPayment(payment);
    }

    @GetMapping("/{ticketId}")
    public CinemaPayment findPaymentHistoryByTicketId(@PathVariable int ticketId) throws JsonProcessingException {
        return service.findPaymentHistoryByTicketId(ticketId);
    }
}