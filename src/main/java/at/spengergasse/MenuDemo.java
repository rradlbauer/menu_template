package at.spengergasse;

import items.io.Menu;
import test.Patient;
import test.PatientIO;

public class MenuDemo {
    public static void main(String[] args) {
        // hier werden als Demo die Klassen Patient und PatientIO verwendet, welche in menu.jar
        // enthalten sind. Deine Aufgabe ist es, eine andere Entity-Klasse zu verwenden.
        PatientIO patientIO = new PatientIO();
        Menu<Patient> menu = new Menu<>(patientIO);
        boolean run = true;
        while(run){
            try {
                run = menu.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
