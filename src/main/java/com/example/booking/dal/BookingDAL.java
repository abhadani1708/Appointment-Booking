package com.example.booking.dal;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.booking.model.Slot;
import com.example.booking.model.User;
import com.example.booking.model.Booking;

@Repository
@RequiredArgsConstructor
public class BookingDAL {

    @PersistenceContext
    private EntityManager em;

    public List<Slot> findAvailableSlots(LocalDate date) {
        return em.createQuery("SELECT s FROM Slot s WHERE s.date = :date AND s.booked = false", Slot.class)
                .setParameter("date", date)
                .getResultList();
    }

    public void bookSlot(String email, Long slotId) {
        User user = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        Slot slot = em.find(Slot.class, slotId);
        if (slot.isBooked())
            throw new RuntimeException("Slot already booked");
        slot.setBooked(true);
        em.persist(new Booking(null, user.getId(), slotId, LocalDateTime.now()));
        em.merge(slot);
    }

    public List<Booking> findAllBookings() {
        return em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
    }
}