package company;

import company.classes.Passenger;
import company.classes.Passengers;

import java.util.Scanner;

import static company.classes.FunUtils.*;

/**
 * Class Main
 */
public class Main {
    /**
     * Main function
     */
    public static void main(final String[] args) {
        final Scanner str = new Scanner(System.in);
        int menu, length;
        boolean exit = false;
        System.out.print("Enter quantity of passengers: ");
        length = isPositive(str);
        final Passengers passengers = new Passengers(length);
        System.out.println("Enter the information of all the passengers: ");
        createPassenger(passengers, str, length);
        System.out.println("\n");
        System.out.println(passengers.massOver30());
        while (!exit) {
            System.out.println("1) Add passenger\n2) Show all passengers\n3) Show all passengers` sum mass of baggage\n" +
                    "4) Location of baggage\n5) Remove passenger by last name\n6) Exit");
            menu = isPositive(str);
            switch (menu) {
                case 1:
                    System.out.print("Enter quantity of add passengers: ");
                    length = isPositive(str);
                    System.out.println("Enter the information of all the add passengers: ");
                    createPassenger(passengers, str, length);
                    System.out.println(passengers.massOver30());
                    break;
                case 2:
                    System.out.println(passengers.toString());
                    break;
                case 3:
                    System.out.println(passengers.allMassOfBaggage());
                    break;
                case 4:
                    System.out.print("Enter number baggage: ");
                    System.out.println(passengers.locationOfBaggage(str.next()));
                    break;
                case 5:
                    System.out.print("Enter last name: ");
                    System.out.println("\n" + passengers.removeByLastName(str.next()) + "\n");
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Error!!!");
                    break;
            }
        }
    }

    private static void createPassenger(final Passengers passengers, final Scanner str, final int length) {
        String name, lastName, patronymic, numberFlight, numberBaggage;
        int quantityPlace, sumMassOfBaggage = 0, numberLevel, numberLevelBaggage;
        LevelOfPlace levelOfPlace;
        LevelOfBaggage levelOfBaggage;
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + ") Passenger: ");
            System.out.print("Name: ");
            name = str.next();
            System.out.print("Last name: ");
            lastName = str.next();
            System.out.print("Patronymic: ");
            patronymic = str.next();
            System.out.print("Number flight: ");
            numberFlight = isNumberFlight(str);
            System.out.println("Level of place:\n1) First class\n2) Business class\n3)Eco class");
            numberLevel = isPositive(str);
            switch (numberLevel) {
                case 1:
                    levelOfPlace = LevelOfPlace.FIRST;
                    break;
                case 2:
                    levelOfPlace = LevelOfPlace.BUSINESS;
                    break;
                case 3:
                    levelOfPlace = LevelOfPlace.ECONOMY;
                    break;
                default:
                    System.out.println("Error!!! Your class is eco class");
                    levelOfPlace = LevelOfPlace.ECONOMY;
                    break;
            }
            System.out.println(levelOfPlace.toString());
            System.out.print("Number baggage: ");
            numberBaggage = isNumberBaggage(str);
            System.out.println("Level of baggage:\n1) Hand luggage\n2) In luggage");
            numberLevelBaggage = isPositive(str);
            switch (numberLevelBaggage) {
                case 1:
                    levelOfBaggage = LevelOfBaggage.HANDLUGGAGE;
                    break;
                case 2:
                    levelOfBaggage = LevelOfBaggage.INLUGGAGE;
                    break;
                default:
                    System.out.println("Error!!! Your level of baggage is In luggage");
                    levelOfBaggage = LevelOfBaggage.INLUGGAGE;
                    break;
            }
            System.out.print("Quantity place: ");
            quantityPlace = isPositive(str);
            for (int j = 0; j < quantityPlace; j++) {
                System.out.print((j + 1) + ") Mass of baggage: ");
                sumMassOfBaggage += isPositive(str);
            }
            passengers.pushBack(new Passenger(name, lastName, patronymic, numberFlight, levelOfPlace.toString(), numberBaggage, levelOfBaggage.toString(), quantityPlace, sumMassOfBaggage));
        }
    }

    /**
     * Enum Level of place
     */
    enum LevelOfPlace {
        FIRST,
        BUSINESS,
        ECONOMY
    }

    /**
     * Enum Level of baggage
     */
    enum LevelOfBaggage {
        HANDLUGGAGE,
        INLUGGAGE
    }
}
