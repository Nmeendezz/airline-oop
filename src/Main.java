import components.*;
import model.Passenger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerReader passengerReader = new PassengerReader(scanner);
        FlightReader flightReader = new FlightReader(scanner, passengerReader);
        AirlineReader airlineReader = new AirlineReader(scanner, flightReader);
        AirlineAppMenu airlineAppMenu = new AirlineAppMenu(scanner, airlineReader);

        airlineAppMenu.run();
    }
}