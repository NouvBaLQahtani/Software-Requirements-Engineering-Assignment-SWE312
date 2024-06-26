package SWE312;

import java.util.Scanner;

public class BirthdayBook {
    static Scanner input = new Scanner(System.in);
    static final int MAX_SIZE = 100;
    static NAME[] names = new NAME[MAX_SIZE];
    static DATE[] dates = new DATE[MAX_SIZE];
    static int hwm = 0;

    public static void main(String[] args) {
        // Input loop
        while (true) {
            // Get name input
            System.out.print("Enter name (or 'quit' to exit): ");
            String nameinput = input.nextLine();
            if (nameinput.equalsIgnoreCase("quit")) {
                break;
            }
            NAME name = new NAME(nameinput);

            // Get date input
            System.out.print("Enter date (DD/MM/YYYY): ");
            String dateinput = input.nextLine();

            String[] parts = dateinput.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            DATE date = new DATE(day, month, year);

            // calling addbirthday method
            BirthdayBook.addBirthday(name, date);
        }
        
        // Get name input for search
        System.out.print("Enter name to search for: ");
        String searchNameInput = input.nextLine();
        NAME searchName = new NAME(searchNameInput);

        // Call FindBirthday method
        DATE birthday = FindBirthday(searchName, names, dates, hwm);
        if (birthday != null) {
            System.out.println(searchName.getName() + "'s birthday is on " + birthday);
        } else {
            System.out.println(searchName.getName() + "'s birthday not found.");
        }
         
        
        // Test the Remind method
        System.out.print("Enter date to remind (DD/MM/YYYY): ");
        String dateinput = input.nextLine();

        String[] parts = dateinput.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        DATE remindDate = new DATE(day, month, year);

        NAME[] cardList = BirthdayBook.Remind(remindDate);
        System.out.println("Entered date represent Birth date for " + remindDate + ":");
        for (NAME name : cardList) {
            if (name != null) {
                System.out.println(name.toString());
            }
        }
    }

    // implementing method A
    public static boolean addBirthday(NAME n, DATE d) {
        if (hwm == names.length && hwm == dates.length)
            return false;
        else
            names[hwm] = n;
        dates[hwm] = d;
        hwm++;
        return true;
    }

    // implementing method B
    public static DATE FindBirthday(NAME name, NAME[] names, DATE[] dates, int hwm) {
        for (int i = 0; i < hwm; i++) {
            if (name.equals(names[i])) {
                return dates[i];
            }
        }
        return null;
    }

    // implementing method C
    public static NAME[] Remind(DATE date) {
        NAME[] cardList = new NAME[names.length];
        int nCards = 0;
        for (int i = 0; i < hwm; i++) {
            if (dates[i].equals(date)) {
                cardList[nCards] = names[i];
                nCards++;
            }
        }
        System.out.println("Number of Names which has this date as their birth date : " + nCards);
        return cardList;
    }
}

