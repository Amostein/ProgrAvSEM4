public class User {
    private String username;
    private String password;
    private String email;
    private String userID;
    private Role role;

    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public boolean login(String username, String password, Role role) {
        return  this.username.equals(username) && this.password.equals(password) && this.role.equals(role);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void updateProfile(String username, String password, Role role, boolean logged) {
        if(logged){
            this.username = username;
            this.password = password;
            this.role = role;

        }else {
            System.out.println("Login failed");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
