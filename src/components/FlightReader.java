package components;

import model.Flight;
import model.Passenger;

import java.util.Scanner;

public class FlightReader {
    private final Scanner scanner;
    private final PassengerReader passengerReader;

    public FlightReader(Scanner scanner, PassengerReader passengerReader) {
        this.scanner = scanner;
        this.passengerReader = passengerReader;
    }

    public Flight read(){
        System.out.println("Introduce los datos del vuelo:");
        System.out.println("Numero de vuelo:");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Origen:");
        String origin = scanner.nextLine();

        System.out.println("Destino");
        String destination = scanner.nextLine();

        System.out.println("Puerta de embarque");
        int gateNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cuantos pasajeros vas a introducir?");
        int cantPassengers = scanner.nextInt();
        scanner.nextLine();
        Passenger[] passengers = new Passenger[cantPassengers];
        for (int i = 0; i < passengers.length; i++) {
            passengers[i] = passengerReader.read();
        }
        return new Flight(
                flightNumber,
                origin,
                destination,
                gateNumber,
                passengers
        );
    }
}
