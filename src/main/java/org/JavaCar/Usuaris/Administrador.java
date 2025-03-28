package org.JavaCar.Usuaris;

import org.JavaCar.*;
import org.JavaCar.Vehicle;

import static org.JavaCar.GestorLloguers.llistaVehicles;

public abstract class Administrador extends Usuari {

    /**
     * Permet a l'administrador modificar les propietats d'un vehicle existent.
     * Mostra la llista de vehicles disponibles i permet seleccionar un vehicle per modificar-lo.
     */
    public static void modificarVehicle() {
        int i = 0;
        Vehicle vehicleModificar;

        for (Vehicle vehicle : llistaVehicles) {
            i++;
            System.out.println(i + " - " + vehicle);
        }
        System.out.print("Selecciona el vehicle que vols modificar: ");

        try {
            vehicleModificar = llistaVehicles.get(Main.comprovarInput(0,llistaVehicles.size()) - 1);
            Menu.menuModificar(vehicleModificar);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Va jefe, para de liar-la.\n");
        }
    }

    /**
     * Permet a l'administrador afegir un nou vehicle a la flota.
     * Demana a l'administrador les propietats del vehicle i el crea.
     */
    public static void afegirVehicle() {
        Vehicle vehicle = tipusVehicle();

        System.out.print("Si us plau, entra el nom de la Matrícula: ");
        String matricula = Main.input.nextLine();
        vehicle.setMatricula(matricula);

        System.out.print("Entra el nom de la marca: ");
        vehicle.setMarca(Main.input.nextLine());

        System.out.print("Entra el nom del model: ");
        vehicle.setModel(Main.input.nextLine());

        System.out.print("Si us plau, entra el preu base del vehicle: ");
        vehicle.setPreuBase(Main.input.nextInt());
        Main.input.nextLine();

        System.out.print("Entra el tipus de motor: ");
        String tipusMotor = Main.input.nextLine();
        System.out.print("Entra la potència: ");
        int potencia = Main.input.nextInt();
        Main.input.nextLine();

        Motor motor = new Motor(tipusMotor, potencia);
        vehicle.setMotor(motor);

        System.out.print("Si us plau, entra el tipus de rodes: ");
        String tipusRodes = Main.input.nextLine();

        System.out.print("Entra el diàmetre: ");
        double diametreRodes = Main.input.nextDouble();

        Roda roda = new Roda(tipusRodes, diametreRodes);
        Roda[] rodes;

        if (vehicle instanceof Moto) {
            rodes = new Roda[]{roda, roda};
            System.out.print("Si us plau, entra la cilindrada de la moto: ");
            ((Moto) vehicle).setCilindrada(Main.input.nextInt());
        } else if (vehicle instanceof Furgoneta) {
            rodes = new Roda[]{roda, roda, roda, roda};
            System.out.print("Si us plau, entra la capacitat de càrrega de la furgoneta: ");
            ((Furgoneta) vehicle).setCapacitatCarga(Main.input.nextDouble());
        } else
            rodes = new Roda[]{roda, roda, roda, roda};

        vehicle.setRodes(rodes);

        System.out.print("Si us plau, entra l'any de fabricació: ");
        vehicle.setAnyFabricacio(Main.input.nextInt());

        vehicle.setEtiquetaAmbiental();
        llistaVehicles.add(vehicle);
    }

    /**
     * Demana a l'administrador quin tipus de vehicle vol afegir (Moto, Cotxe, Furgoneta).
     * @return El vehicle creat segons el tipus seleccionat.
     */
    private static Vehicle tipusVehicle() {
        Moto moto;
        Cotxe cotxe;
        Furgoneta furgoneta;

        System.out.print("""       
                1 - Moto
                2 - Cotxe
                3 - Furgoneta
                """);
        System.out.print("Quin tipus de vehicle vols afegir? ");
        int eleccio = Main.comprovarInput(1,3);

        return switch (eleccio) {
            case 1 -> {
                System.out.println("Has escollit introduir una moto.");
                yield moto = new Moto();
            }
            case 2 -> {
                System.out.println("Has escollit introduir un cotxe.");
                yield cotxe = new Cotxe();
            }
            default -> {
                System.out.println("Has escollit introduir una furgoneta.");
                yield furgoneta = new Furgoneta();
            }
        };
    }

    /**
     * Permet a l'administrador eliminar un vehicle de la flota.
     * Elimina un vehicle de la llista si no està llogat.
     */
    public static void eliminarVehicle() {
        GestorLloguers.mostraVehicles();
        System.out.print("Selecciona quin vehicle vols descatalogar: ");

        int descatalogarVehicle = Main.comprovarInput(0,llistaVehicles.size()) - 1;

        if (llistaVehicles.get(descatalogarVehicle).isLlogat())
            System.out.println("No es pot descatalogar, està llogat!!");
        else {
            System.out.println("Has descatalogat " + llistaVehicles.get(descatalogarVehicle));
            llistaVehicles.remove(descatalogarVehicle);
        }
    }

    public static void imprimirMenu() {
        System.out.println("""
                Has escollit Administrador.
                1 - Calcular Ingressos Totals.
                2 - Administrar vehicles.
                3 - Enrere.""");
    }
}
