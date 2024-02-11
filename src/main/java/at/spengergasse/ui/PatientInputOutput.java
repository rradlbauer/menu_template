package at.spengergasse.ui;

import at.spengergasse.entities.Patient;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PatientInputOutput implements IInputOutput<Patient>{
    private final static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("d.M.y");
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Patient input() throws Exception {
        Patient p = new Patient();
        System.out.print("name: ");
        p.setName(scanner.nextLine());
        System.out.print("birthdate (dd.MM.yyyy): ");
        p.setBirthdate(java.time.LocalDate.parse(scanner.nextLine(), FMT));
        System.out.print("gender (f/m/d): ");
        p.setGender(scanner.nextLine().charAt(0));
        return p;
    }

    @Override
    public String shortInfo(Patient patient) {
        return patient.getName();
    }

    @Override
    public String detailInfo(Patient patient) {
        return String.format("Name: %s\nBirthdate: %s\nGender: %s",
                patient.getName(), patient.getBirthdate().format(FMT), patient.getGender());
    }
}
