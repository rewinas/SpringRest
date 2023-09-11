package com.kuraz.Rest.entity;

public class Student {
    private String firstName;
    private String lastName;

public Student(){

}

    public String getFirstName() {
        return firstName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
