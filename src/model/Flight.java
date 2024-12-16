package model;

import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private int gateNumber;
    private Passenger[] passengers;

    public Flight(int flightNumber, String origin, String destination, int gateNumber, Passenger[] passengers) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.gateNumber = gateNumber;
        this.passengers = passengers;
    }

    public void passengersInfo(){
        for (Passenger passenger: passengers){
            passenger.showInfoPassenger();
        }
    }
    public Passenger findPassenger(String nif){
        for (Passenger passenger: passengers){
            if (passenger.getNif().equals(nif)){
                return passenger;
            }
        }
        return null;
    }
    public void showPassengerNif(String nif){
        Passenger passenger = findPassenger(nif);
        if (passenger != null){
            showInfoFlight();
        } else {
            System.out.println("Error, no existen vuelos con el NIF introducido");
        }
    }
    public void showInfoFlight(){
        System.out.println("Numero de vuelo: " + getFlightNumber());
        System.out.println("Origen: " + getOrigin());
        System.out.println("Destino: " + getDestination());
        System.out.println("Puerta de embarque: " + getGateNumber());
        System.out.println("Pasajeros:  ");
        passengersInfo();
        System.out.println();
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && gateNumber == flight.gateNumber && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.deepEquals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, origin, destination, gateNumber, Arrays.hashCode(passengers));
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", gateNumber=" + gateNumber +
                ", passengers=" + Arrays.toString(passengers) +
                '}';
    }
}