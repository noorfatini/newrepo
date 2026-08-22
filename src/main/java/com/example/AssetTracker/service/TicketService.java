package com.example.AssetTracker.service;

import com.example.AssetTracker.dto.CreateTicketRequest;
import com.example.AssetTracker.dto.TicketResponse;
import com.example.AssetTracker.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/*
 * TicketService
 * -------------
 * Services contain business logic. This example uses an in-memory list
 * to keep things simple for students, same as AssetService.
 */
@Service
public class TicketService {

    // In-memory data store used for teaching/demo purposes only
    private final List<TicketResponse> tickets = new ArrayList<>();

    public TicketService() {
        // Seed with example data so the app has something to return right away.
        tickets.add(new TicketResponse(
                "T001",
                "Cannot access email",
                "User cannot login to company email account.",
                "Email",
                "HIGH",
                "OPEN",
                "amir@example.com",
                "2026-07-03"
        ));

        tickets.add(new TicketResponse(
                "T002",
                "Laptop is slow",
                "Laptop takes a long time to start up and open applications.",
                "Hardware",
                "MEDIUM",
                "OPEN",
                "siti@example.com",
                "2026-07-05"
        ));

        tickets.add(new TicketResponse(
                "T003",
                "VPN connection not working",
                "User is unable to connect to the office VPN from home.",
                "Network",
                "HIGH",
                "IN_PROGRESS",
                "farid@example.com",
                "2026-07-08"
        ));
    }

    // Return all tickets.
    public List<TicketResponse> getAllTickets() {
        return tickets;
    }

    // Find a ticket by id or throw a ResourceNotFoundException which is
    // handled globally by GlobalExceptionHandler.
    public TicketResponse getTicketById(String id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " was not found"));
    }

    // Create a new ticket from the request DTO. New tickets always start
    // with status OPEN and today's date.
    public TicketResponse createTicket(CreateTicketRequest request) {
        TicketResponse created = new TicketResponse(
                createNextId(),
                request.getTitle().trim(),
                request.getDescription().trim(),
                request.getCategory().trim(),
                request.getPriority().trim(),
                "OPEN",
                request.getCreatedBy().trim(),
                LocalDate.now().toString()
        );

        tickets.add(created);
        return created;
    }

    // Helper to create a simple sequential id. Not thread-safe but fine for demo.
    private String createNextId() {
        return "T" + String.format("%03d", tickets.size() + 1);
    }
}
