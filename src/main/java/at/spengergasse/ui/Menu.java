package at.spengergasse.ui;

import at.spengergasse.persistence.IPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu<T> {
    private Scanner scanner = new Scanner(System.in);
    private IInputOutput<T> inputOutput;
    private IPersistence<T> persistence;
    private List<T> list = new ArrayList<>();

    public Menu(IInputOutput<T> inputOutput, IPersistence<T> persistence) {
        this.inputOutput = inputOutput;
        this.persistence = persistence;
        if (persistence != null) {
            try {
                list = persistence.load();
            } catch (Exception e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        }
    }

    public boolean show() throws Exception {
        System.out.println("==========================================================");
        System.out.println("1) new entry");
        System.out.println("2) show all entries");
        System.out.println("3) remove entry");
        System.out.println("4) show entry details");
        System.out.println("5) save and exit");
        System.out.println("==========================================================");
        System.out.print("Please enter your choice: ");
        switch (scanner.nextLine()) {
            case "1":
                list.add(inputOutput.input());
                break;
            case "2":
                showList();
                break;
            case "3":
                removeEntry();
                break;
            case "4":
                showDetails();
                break;
            case "5":
                if (persistence != null) {
                    persistence.save(list);
                }
                return false;
            default:
                throw new Exception("Invalid choice");
        }
        return true;
    }

    private void showDetails() {
        showList();
        System.out.print("Please enter the number of the entry to show details: ");
        int i = Integer.parseInt(scanner.nextLine());
        System.out.println(inputOutput.detailInfo(list.get(i - 1)));
    }

    private void removeEntry() {
        showList();
        System.out.print("Please enter the number of the entry to remove: ");
        int i = Integer.parseInt(scanner.nextLine());
        list.remove(i - 1);
    }

    private void showList() {
        int i = 1;
        System.out.println("---------------------------------");
        for (T t : list) {
            System.out.println((i++) + ") " + inputOutput.shortInfo(t));
        }
        System.out.println("---------------------------------");
    }
}


