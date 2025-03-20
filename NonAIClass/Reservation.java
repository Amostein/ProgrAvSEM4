import java.util.*;

public class Reservation {
    private static int counter = 10000;
    private int reservationId;
    private int userId;
    private int fieldId;
    private Date startTime;
    private Date endTime;
    private boolean confirmed;
    private double pret = 50.0;

    private static List<Reservation> rezervari = new ArrayList<>();

    public Reservation(int userId, int fieldId, Date startTime, Date endTime) {
        this.reservationId = counter++;
        this.userId = userId;
        this.fieldId = fieldId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.confirmed = false;
        rezervari.add(this);
    }

    public Reservation createReservation(int userId, int fieldId, Date startTime, Date endTime) {
        return new Reservation(userId, fieldId, startTime, endTime);
    }

    public void cancelReservation(int reservationId) {
        for (Reservation r : rezervari) {
            if (r.reservationId == reservationId) {
                r.confirmed = false;
            }
        }
    }

    public void confirmReservation(int reservationId) {
        for (Reservation res : rezervari) {
            if (res.reservationId == reservationId) {
                res.confirmed = true;
            }
        }
    }

    public int getUserId() {
        return userId;
    }
    public int getFieldId() {
        return fieldId;
    }

    public double calculateTotalPrice() {
        long durationMillis = endTime.getTime() - startTime.getTime();
        double hours = durationMillis / (1000.0 * 60 * 60);
        return hours * pret;
    }

    public int getReservationId() {
        return reservationId;
    }

    @Override
    public String toString() {
        return "Reservation {" +
                "reservationId='" + getReservationId() + '\'' +
                ", userId='" + getUserId() + '\'' +
                ", fieldID='" + getFieldId() + '\'' +
                '}';
    }
}
