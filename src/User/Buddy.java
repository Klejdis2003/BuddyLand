package User;

import java.util.Objects;

public class Buddy {
    private String firstName, lastName;
    private String email;
    private String username;
    private String password;

    public Buddy(String username){
        this.username = username;
    }

    public Buddy(String firstName, String lastName, String email, String userName, String password) {
        this.email = email;
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() { //since username is different for every User.Buddy, the hash code is the hash of the username
        return Objects.hash(username);
    }

    @Override
    public boolean equals(Object b){
        Buddy buddy = (Buddy) b;
        return username.equalsIgnoreCase(buddy.username);
    }
    public int compareTo(Buddy buddy){
        return username.compareToIgnoreCase(buddy.username);
    }
}

