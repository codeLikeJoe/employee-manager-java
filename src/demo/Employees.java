package demo;

import java.util.ArrayList;

public class Employees {
    private String name;
    private String id;
    private String email;


    public Employees(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void getDetails() {
        System.out.println("Name: " + this.getName() +
                "\nID: " + this.getNumber() +
                "\nEmail: " + this.getEmail());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return id;
    }

    public void setNumber(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
