package org.JavaCar;

public class Motor {
    String tipus;
    int potencia;

    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    public String getTipus() {
        return tipus;
    }

    public int getPotencia() {
        return potencia;
    }
}
