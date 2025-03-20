package services;

import models.User;
import models.Reservation;
import java.util.List;
import java.util.ArrayList;

public class UserService {
    private List<User> utilizatori = new ArrayList<>();
    private List<Reservation> rezervari = new ArrayList<>();

    public boolean registerUser(User user) {
        utilizatori.add(user);
        return true;
    }

    public User authenticateUser(String email, String password) {
        for (User user : utilizatori) {
            if (user.getEmail().equals(email) && user.getParola().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void updateUserInfo(User user) {
        System.out.println("✏ Actualizare utilizator: " + user.getNume());
    }

    public List<Reservation> getUserReservations(int userId) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation rez : rezervari) {
            if (rez.getUserId() == userId) {
                userReservations.add(rez);
            }
        }
        return userReservations;
    }
}
