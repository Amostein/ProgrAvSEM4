public class Main {
    public static void main(String[] args) {
        User cont = new User("Ana","alumni","anaaremere@gmail.com",Role.PLAYER);

        if(cont.login("Ana","alumni",Role.PLAYER)){
            System.out.println("Login successful");
        }else
            System.out.println("Login failed");

        cont.updateProfile("Anca","admin", Role.OWNER,cont.login("Ana","alumni",Role.PLAYER));

        if(cont.login("Anca","admin",Role.OWNER)){
            System.out.println("Login successful");
        }else
            System.out.println("Login failed");


    }
}
