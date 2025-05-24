package algoritmotraspocision;

import java.util.List;
import java.util.Scanner;

import algoritmotraspocision.bussinesslogic.AlgoritmoTransposicion;

public class Main {
    private static final AlgoritmoTransposicion ALGORITMO_TRANSPOSICION = new AlgoritmoTransposicion();
    private static final List<String> OPCIONES_MENU = List.of("1", "2");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    getFuncionEncriptarTexto(scanner);
                    break;
                case "2":
                    getFuncionDesencriptarTexto(scanner);
                    break;
                default: System.out.println("Saliendo...");
            }
        } while (OPCIONES_MENU.indexOf(opcion) >= 0);

        scanner.close();
    }

    private static void getFuncionDesencriptarTexto(Scanner scanner) {
        System.out.print("Ingrese texto a desencriptar: ");
        String textoEncriptado = scanner.nextLine();
        String textoDesencriptado = ALGORITMO_TRANSPOSICION.desencriptar(textoEncriptado);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }

    private static void getFuncionEncriptarTexto(Scanner scanner) {
        System.out.print("Ingrese texto plano a encriptar: ");
        String textoPlano = scanner.nextLine();
        String textoEncriptado = ALGORITMO_TRANSPOSICION.encriptar(textoPlano);
        System.out.println("Texto encriptado: " + textoEncriptado);
    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Encriptar texto");
        System.out.println("2. Desencriptar texto");
        System.out.println("Otra opcion para salir");
        System.out.print("Opción: ");
    }
}
