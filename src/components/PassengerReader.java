package components;

import model.Passenger;

import java.util.Scanner;

public class PassengerReader {
    private final Scanner scanner;

    public PassengerReader(Scanner scanner) {
        this.scanner = scanner;
    }
    public Passenger read(){
        System.out.println("Introduce los datos del pasajero");
        System.out.println("NIF del pasajero: ");
        String nif = scanner.nextLine();

        System.out.println("Nombre: ");
        String name = scanner.nextLine();

        System.out.println("Apellido: ");
        String surname = scanner.nextLine();

        System.out.println("Numero de asiento: ");
        Integer seatNumber = scanner.nextInt();
        scanner.nextLine();

        return new Passenger(
                nif,
                name,
                surname,
                seatNumber
        );
    }
}
