package org.JavaCar;
import java.util.ArrayList;

public class Client extends Usuari {
    private ArrayList<Vehicle> vehiclesAlquitlats = new ArrayList<>();

    public Client(String nom, String cognom, String telefon, String email) {
        super(nom, cognom, telefon, email);
    }

    public Client() {}

    @Override
    public void imprimirMenu() {
        System.out.println("""
                Has escollit Client.
                1 - Alquilar un vehicle.
                2 - Filtrar vehicles per preu.
                3 - Enrere.
                """);
    }

}
