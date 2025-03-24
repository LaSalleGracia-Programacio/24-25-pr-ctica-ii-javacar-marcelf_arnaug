package org.JavaCar;

public class Roda {
    private String marca;
    private double diametre;

    public Roda(String marca, double diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }


    // ===== GETTERS I SETTERS ======
    public String getMarca() {
        return marca;
    }

    public double getDiametre() {
        return diametre;
    }
    @Override
    public String toString() {
        return "Roda: (" +
                "marca: " + marca +
                ", diàmetre: " + diametre +
                ')';
    }
}
