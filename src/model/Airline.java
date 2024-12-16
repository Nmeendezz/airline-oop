package model;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }
    //Mostrar todos los vuelos
    public void showFlights() {
        for (Flight flight : flights) {
            System.out.println("Numero de vuelo: " + flight.getFlightNumber());
            System.out.println("Origen: " + flight.getOrigin());
            System.out.println("Destino: " + flight.getDestination());
            System.out.println("Puerta de embarque: " + flight.getGateNumber());
            System.out.println("Pasajeros: ");
            flight.passengersInfo();
            System.out.println();
        }
    }
    //Buscar y mostrar vuelos dado el origen
    public Flight findFlightOrigin(String origin) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin)) {
                return flight;
            }
        }
        return null;
    }

    public void showFlightOrigin(String origin) {
        Flight flight = findFlightOrigin(origin);
        if (flight != null) {
            flight.showInfoFlight();
        } else {
            System.out.println("Error, no existen vuelos con el origen introducido");
        }
    }

    //Buscar y mostrar vuelos dado el numero de vuelo
    public Flight findFlightNumber(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void showFlightNumber(int flightNumber) {
        Flight flight = findFlightNumber(flightNumber);
        if (flight != null) {
            flight.showInfoFlight();
        } else {
            System.out.println("Error, no existe el vuelo");
        }
    }

    //Buscar y mostrar vuelos dado el NIF del pasajero
    public void showFlightNif(String nif){
        for (Flight flight: flights){
            flight.showPassengerNif(nif);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Objects.deepEquals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(flights));
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
