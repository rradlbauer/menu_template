package at.spengergasse;

import at.spengergasse.entities.Patient;
import at.spengergasse.ui.Menu;
import at.spengergasse.ui.PatientInputOutput;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Menu<Patient> m = new Menu<>(new PatientInputOutput(), null);
        boolean run = true;
        while (run) {
            try {
                run = m.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
