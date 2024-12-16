package components;

import model.Airline;

import java.util.Scanner;

public class AirlineApp1 {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run() {
        Airline airline = airlineReader.read();
        System.out.println("Introduce los datos de la aerolinea:");
        System.out.println("Introduce el numero de vuelo");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        var flight = airline.findFlightNumber(flightNumber);
        if (flight != null) {
            System.out.println("Introduce el NIF del pasajero");
            String nif = scanner.nextLine();
            var passenger = flight.findPassenger(nif);
            if (passenger != null) {
                passenger.showInfoPassenger();
                System.out.println("Introduce un numero de asiento");
                Integer seatNumber = scanner.nextInt();
                scanner.nextLine();
                seatNumber = passenger.getSeatNumber();
            } else {
                System.out.println("Error, no existe el pasajero");
            }
        } else {
            System.out.println("Error, no existe el vuelo");
        }
    }
}
