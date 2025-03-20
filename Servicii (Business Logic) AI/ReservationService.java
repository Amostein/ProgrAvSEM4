package services;

import models.Reservation;
import java.util.List;
import java.util.ArrayList;

public class ReservationService {
    private List<Reservation> rezervari = new ArrayList<>();

    public boolean createReservation(Reservation reservation) {
        rezervari.add(reservation);
        return true;
    }

    public boolean cancelReservation(int reservationId) {
        return rezervari.removeIf(r -> r.getId() == reservationId);
    }

    public boolean confirmReservation(int reservationId) {
        for (Reservation rez : rezervari) {
            if (rez.getId() == reservationId) {
                rez.setConfirmata(true);
                return true;
            }
        }
        return false;
    }

    public List<Reservation> getReservationsForUser(int userId) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation rez : rezervari) {
            if (rez.getUserId() == userId) {
                userReservations.add(rez);
            }
        }
        return userReservations;
    }

    public List<Reservation> getReservationsForField(int fieldId) {
        List<Reservation> fieldReservations = new ArrayList<>();
        for (Reservation rez : rezervari) {
            if (rez.getTerenId() == fieldId) {
                fieldReservations.add(rez);
            }
        }
        return fieldReservations;
    }
}
