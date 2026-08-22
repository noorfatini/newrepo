package com.example.AssetTracker.controller;

import com.example.AssetTracker.dto.CreateTicketRequest;
import com.example.AssetTracker.dto.TicketResponse;
import com.example.AssetTracker.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * TicketController
 * -----------------
 * Exposes the ticket read endpoint. Controllers stay thin: they call the
 * service and return the result, they do not hold data themselves.
 */
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // GET /api/tickets -> returns all tickets
    @GetMapping
    public List<TicketResponse> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // GET /api/tickets/{id} -> returns a single ticket by id
    @GetMapping("/{id}")
    public TicketResponse getTicketById(@PathVariable String id) {
        return ticketService.getTicketById(id);
    }

    // POST /api/tickets -> create a new ticket. @Valid triggers validation annotations
    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        TicketResponse created = ticketService.createTicket(request);
        // Return 201 Created with the created ticket in the body
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
