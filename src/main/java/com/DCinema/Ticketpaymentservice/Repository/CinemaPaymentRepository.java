package com.DCinema.Ticketpaymentservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DCinema.Ticketpaymentservice.Entity.CinemaPayment;

public interface CinemaPaymentRepository extends JpaRepository<CinemaPayment, Integer> {
    CinemaPayment findByTicketId(int ticketId);

}
