package components;

import model.Airline;

import java.util.Scanner;

public class AirlineAppMenu {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineAppMenu(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public int chooseOption() {
        System.out.println("Elige una opcion");
        System.out.println("1. Muestra todos los vuelos");
        System.out.println("2. Mostrar vuelos origen");
        System.out.println("3. Muestra los vuelos de un pasajero");
        System.out.println("4. Muestra asiento de pasajero");
        System.out.println("5. Cambiar asiento de pasajero");
        System.out.println("6. Salir");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public void run() {
        int option;
        Airline airline = airlineReader.read();
        do {
            option = chooseOption();
            if (option == 1) {
                airline.showFlights();
            } else if (option == 2) {
                System.out.println("Introduce un origen");
                String origin = scanner.nextLine();
                airline.showFlightOrigin(origin);
            } else if (option == 3) {
                System.out.println("Introduce el NIF del pasajero");
                String nif = scanner.nextLine();
                airline.showFlightNif(nif);
            } else if (option == 4) {
                System.out.println("Introduce el numero de vuelo");
                int flightNumber = scanner.nextInt();
                scanner.nextLine();
                var flight = airline.findFlightNumber(flightNumber);
                if (flight != null) {
                    System.out.println("Introduce el NIF del pasajero");
                    String nif = scanner.nextLine();
                    var passenger = flight.findPassenger(nif);
                    if (passenger != null) {
                        System.out.println("El asiento asignado es " + passenger.getSeatNumber());
                    } else {
                        System.out.println("El pasajero no esta registrado en el vuelo");
                    }
                } else {
                    System.out.println("El vuelo no existe");
                }
            } else if (option == 5) {
                System.out.println("Introduce un numero de vuelo");
                int flightNumber = scanner.nextInt();
                scanner.nextLine();
                var flight = airline.findFlightNumber(flightNumber);
                if (flight != null) {
                    System.out.println("Introduce el NIF del pasajero");
                    String nif = scanner.nextLine();
                    var passenger = flight.findPassenger(nif);
                    if (passenger != null) {
                        System.out.println("Su asiento asignado es el " + passenger.getSeatNumber());
                        System.out.println("Introduce el nuevo numero de asiento");
                        Integer seatNumber = scanner.nextInt();
                        scanner.nextLine();
                        passenger.setSeatNumber(seatNumber);
                        System.out.println("El nuevo asiento asignado es el " + passenger.getSeatNumber());
                    } else {
                        System.out.println("El pasajero no esta registrado en el vuelo");
                    }
                } else {
                    System.out.println("El vuelo no existe");
                }
            } else if (option == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
            try {
                Thread.sleep(4000);
            } catch (Exception e) {

            }
        } while (option != 6);
    }
}
