package org.JavaCar;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehicle> llistaVehicles = new ArrayList<>();
        Roda[] rodesCotxe = {new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17)};
        Roda[] rodesMoto = {new Roda("Michelin", 17), new Roda("Michelin", 17)};

        Motor motorCotxe = new Motor("Gasolina", 120);
        Motor motorMoto = new Motor("Diesel", 80);


        Moto moto1 = new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe);
        Cotxe cotxe1 = new Cotxe("5678DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto);

        llistaVehicles.add(moto1);
        llistaVehicles.add(cotxe1);

        for (int i = 0; i < llistaVehicles.size(); i++) {
            System.out.println(llistaVehicles.get(i));
        }



    }
}