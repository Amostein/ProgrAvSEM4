𝙰𝚜𝚝𝚛𝚊
astraxys
ingineria programarii

Teodor00 added ᓚᘏᗢ to the group. — Today at 16:04
anarky changed the channel name: ingineria programarii — Today at 16:05
anarky — Today at 16:05
https://structurizr.com/dsl
Structurizr - DSL
Visualise, document and explore your software architecture with Structurizr
Forwarded
Diagrama de Context 

workspace {
    model {
        user = person "Utilizator" "Caută și rezervă terenuri sportive."
        owner = person "Proprietar de teren" "Adaugă terenuri disponibile pentru închiriere."
        admin = person "Administrator" "Administrează platforma."
        
        sportbnb = softwareSystem "sportBNB" "Platformă de rezervări pentru terenuri sportive."

        payment = softwareSystem "Serviciu de plăți" "Stripe/PayPal"
        notifications = softwareSystem "Serviciu de notificări" "Email/SMS"
        auth = softwareSystem "Sistem de autentificare" "Google/Facebook/MariaDB"

        user -> sportbnb "Caută și rezervă terenuri"
        owner -> sportbnb "Adaugă terenuri pentru închiriere"
        admin -> sportbnb "Administrează platforma"

        sportbnb -> payment "Procesează plăți"
        sportbnb -> notifications "Trimite notificări"
        user -> auth "Autentificare"
        sportbnb -> auth "Validare utilizatori"
    }
    views {
        systemContext sportbnb {
            include *
            autolayout lr
        }
        theme default
    }
}
Image
Forwarded
Diagrama de Container

workspace {
    model {
        user = person "Utilizator" "Caută și rezervă terenuri sportive."
        owner = person "Proprietar de teren" "Adaugă terenuri pentru închiriere."
        admin = person "Administrator" "Administrează platforma."

        sportbnb = softwareSystem "sportBNB" "Platformă de rezervări pentru terenuri sportive." {
            frontend = container "Frontend Web/Mobile" "Interfața utilizatorilor și proprietarilor" "React Native / Vue.js"
            backend = container "Backend API" "Gestionează logica aplicației" "Node.js / Express"
            database = container "Baza de date" "Stochează utilizatori, terenuri și rezervări" "MariaDB"
        }

        payment = softwareSystem "Serviciu de plăți" "Stripe/PayPal"
        notifications = softwareSystem "Serviciu de notificări" "Email/SMS"
        auth = softwareSystem "Sistem de autentificare" "Google/Facebook/MariaDB"

        user -> frontend "Accesează aplicația"
        owner -> frontend "Adaugă terenuri"
        admin -> frontend "Administrează platforma"
        
        frontend -> backend "Solicită date / acțiuni prin API"
        backend -> database "Stochează și preia date"
        backend -> payment "Trimite cereri de plată"
        backend -> notifications "Trimite notificări"
        backend -> auth "Validează utilizatori"
    }

    views {
        systemContext sportbnb {
            include *
            autolayout lr
        }

        container sportbnb {
            include *
            autolayout lr
        }

        theme default
    }
}
Image
Image
Forwarded
Diagrama de componentă

workspace {
    model {
        user = person "Utilizator" "Caută și rezervă terenuri sportive."
        owner = person "Proprietar de teren" "Adaugă terenuri pentru închiriere."

        sportbnb = softwareSystem "sportBNB" "Platformă de rezervări pentru terenuri sportive." {
            backend = container "Backend API" "Gestionează logica aplicației" "Node.js / Express" {
                userController = component "UserController" "Gestionarea autentificării și a utilizatorilor"
                bookingController = component "BookingController" "Gestionarea rezervărilor"
                paymentService = component "PaymentService" "Procesarea plăților"
                notificationService = component "NotificationService" "Trimiterea notificărilor"
                dbRepository = component "Database Repository" "Interfață pentru accesul la baza de date"
            }
            
            database = container "Baza de date" "Stochează utilizatori, terenuri și rezervări" "MariaDB"
        }

        payment = softwareSystem "Serviciu de plăți" "Stripe/PayPal"
        notifications = softwareSystem "Serviciu de notificări" "Email/SMS"

        user -> userController "Autentificare și gestionare cont"
        user -> bookingController "Rezervare terenuri"
        owner -> bookingController "Adaugă și administrează terenuri"

        userController -> dbRepository "Acces utilizatori"
        bookingController -> dbRepository "Acces rezervări"
        paymentService -> payment "Plăți online"
        notificationService -> notifications "Notificări utilizatori"
        dbRepository -> database "Citire și scriere date"
    }

    views {
        component backend {
            include *
            autolayout lr
        }

        theme default
    }
}
Image
Forwarded
Diagrama de Cod

workspace {
    model {
        user = person "Utilizator" "Interacționează cu API-ul pentru autentificare și gestionarea contului."

        sportbnb = softwareSystem "sportBNB" "Platformă de rezervări pentru terenuri sportive." {
            backend = container "Backend API" "Gestionează logica aplicației" "Node.js / Express" {
                userController = component "UserController" "Expune API pentru autentificare și utilizatori"
                userService = component "UserService" "Logica de business pentru utilizatori"
                userRepository = component "UserRepository" "Interfață pentru baza de date"
                userEntity = component "User" "Reprezintă un utilizator în baza de date"
            }

            database = container "Baza de date" "Stochează utilizatori, terenuri și rezervări" "MariaDB"
        }

        user -> userController "Solicită autentificare și gestionare cont"
        userController -> userService "Apelare metode de business"
        userService -> userRepository "Interogări în baza de date"
        userRepository -> database "Operații CRUD asupra utilizatorilor"
    }

    views {
        component backend {
            include *
            autolayout lr
        }

        theme default
    }
}
Image
Teodor00 — Today at 16:10
https://github.com/Amostein/ProgrAvSEM4
GitHub
GitHub - Amostein/ProgrAvSEM4
Contribute to Amostein/ProgrAvSEM4 development by creating an account on GitHub.
GitHub - Amostein/ProgrAvSEM4
Teodor00 removed Serban Robert-Stefan (2A3) from the group. — Today at 16:15
anarky — Today at 16:15
l ai exilat?
リヨンズ added Serban Robert-Stefan (2A3) to the group. — Today at 16:15
リヨンズ — Today at 16:15
am admin fraiere
anarky — Today at 16:15
0w0
Teodor00 — Today at 16:17
https://trello.com/b/WDoHDSbh/seminar4
Trello
Organize anything, together. Trello is a collaboration tool that organizes your projects into boards. In one glance, know what's being worked on, who's working on what, and where something is in a process.
Teodor00 added paul to the group. — Today at 16:20
Teodor00 — Today at 16:21
https://trello.com/invite/63e2298fb9f3556548ccf51d/ATTIf943b0f63d05c17a72e42dc82073a37435D86D0D
Trello
Organize anything, together. Trello is a collaboration tool that organizes your projects into boards. In one glance, know what's being worked on, who's working on what, and where something is in a process.
Teodor00 added 𝙰𝚜𝚝𝚛𝚊 to the group. — Today at 16:22
𝙰𝚜𝚝𝚛𝚊 — Today at 16:27
DraganClaudia
paul — Today at 16:27
1️⃣ Entități principale (Modele)
User (Reprezintă utilizatorii aplicației)

register(String name, String email, String phone, Role role): User
login(String email, String password): boolean
updateProfile(String name, String phone): void
Expand
message.txt
3 KB
リヨンズ — Today at 16:33
C4 Model - LEVEL 1
Teodor00 pinned a message to this channel. See all pinned messages. — Today at 16:34
Teodor00 pinned a message to this channel. See all pinned messages. — Today at 16:34
リヨンズ — Today at 16:42
workspace {
    model {
        user = person "Utilizator" "Caută și rezervă terenuri sportive."
        owner = person "Proprietar de teren" "Adaugă terenuri disponibile pentru închiriere."
        admin = person "Administrator" "Administrează platforma."
        
        sportbnb = softwareSystem "sportBNB" "Platformă de rezervări pentru terenuri sportive."

       payment = softwareSystem "Serviciu de plăți" "Stripe/PayPal" {
    tags "External System"
}

        notifications = softwareSystem "Serviciu de notificări" "Email/SMS"{
            tags "External System"
        }

        user -> sportbnb "Caută și rezervă terenuri"
        owner -> sportbnb "Adaugă terenuri pentru închiriere"
        admin -> sportbnb "Administrează platforma"

        sportbnb -> payment "Procesează plăți"
        sportbnb -> notifications "Trimite Email folosind [SMTP]"
        notifications -> user "Trimite Mail"
        notifications -> owner " Trimite Mail"
    }
    views {
    systemContext sportbnb {
        include *
        autolayout lr
    }

    styles {
        element "External System" {
            background "#D3D3D3" 
            border dashed
        }
    }

    theme default
}
}
Image
ᓚᘏᗢ — Today at 16:54
a3326a
paul — Today at 17:06
paul.pasnicu
public class Main {
    public static void main(String[] args) {
        User cont = new User("Ana","alumni","anaaremere@gmail.com",Role.PLAYER);

        if(cont.login("Ana","alumni",Role.PLAYER)){
            System.out.println("Login successful");
Expand
Main.java
1 KB
import java.util.*;

public class Reservation {
    private static int counter = 10000;
    private int reservationId;
    private int userId;
Expand
Reservation.java
2 KB
public enum Role {
    PLAYER,ADMIN,OWNER
}
Role.java
1 KB
public class User {
    private String username;
    private String password;
    private String email;
    private String userID;
    private Role role;
Expand
User.java
2 KB
Teodor00 — Today at 17:14
Image
anarky — Today at 17:15
Attachment file type: archive
Servicii (Business Logic) AI.zip
2.97 KB
paul — Today at 17:15
Attachment file type: archive
NonAI Classes.zip
3.86 KB
﻿
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
Reservation.java
2 KB
