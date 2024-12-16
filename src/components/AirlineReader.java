package components;

import model.Airline;
import model.Flight;

import java.util.Scanner;

public class AirlineReader {
    private final Scanner scanner;
    private final FlightReader flightReader;

    public AirlineReader(Scanner scanner, FlightReader flightReader) {
        this.scanner = scanner;
        this.flightReader = flightReader;
    }
    public Airline read(){
        System.out.println("Introduce los datos de la aerolinea");
        System.out.println("Nombre: ");
        String name = scanner.nextLine();

        System.out.println("Cuantos vuelos son?");
        int cantFlights = scanner.nextInt();
        scanner.nextLine();
        Flight[] flights = new Flight[cantFlights];
        for (int i = 0; i < flights.length; i++) {
            flights[i] = flightReader.read();
        }

        return new Airline(
                name,
                flights
        );
    }
}
