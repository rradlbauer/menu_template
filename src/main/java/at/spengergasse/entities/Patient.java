package at.spengergasse.entities;

import java.time.LocalDate;

public class Patient {
    private int id;
    private String name;
    private LocalDate birthdate;
    private char gender;

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender != 'f' && gender != 'm' && gender != 'd')
            throw new IllegalArgumentException("invalid value for gender");
        this.gender = gender;
    }
}
