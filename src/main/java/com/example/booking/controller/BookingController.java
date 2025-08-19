package com.example.booking.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import com.example.booking.service.BookingService;
import com.example.booking.model.Slot;
import com.example.booking.model.Booking;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/slots")
    public List<Slot> getAvailableSlots(@RequestParam String date) {
        return bookingService.getAvailableSlots(LocalDate.parse(date));
    }

    @PostMapping("/book")
    @PreAuthorize("hasAuthority('PATIENT')")
    public ResponseEntity<String> bookSlot(@RequestParam Long slotId, Principal principal) {
        bookingService.bookSlot(principal.getName(), slotId);
        return ResponseEntity.ok("Booked successfully");
    }

    @GetMapping("/all-bookings")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Booking> allBookings() {
        return bookingService.getAllBookings();
    }
}