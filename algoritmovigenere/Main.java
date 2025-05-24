package algoritmovigenere;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import algoritmovigenere.bussinesslogic.AlgoritmoEncriptacionVigener;

public class Main {
    private static final AlgoritmoEncriptacionVigener ALGORITMO_ENCRIPTACION_VIGENER = new AlgoritmoEncriptacionVigener();
    private static final List<String>  OPCIONES_MENU=Arrays.asList("1","2");
    public static void main(String[] args) {
        System.out.println("Algoritmo de Encriptación Vigenère");
        String opcionSeleccionada = "";
        Scanner scanner = new Scanner(System.in);
        do {
            mostrarMenu();
            opcionSeleccionada = scanner.nextLine();
            switch (opcionSeleccionada) {
                case "1": encriptarTexto(scanner); break;
                case "2": desencriptarTexto(scanner); break;
                default: System.out.println("Opción no válida. Saliendo...");
            }

        } while (OPCIONES_MENU.indexOf(opcionSeleccionada) >= 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Encriptar texto");
        System.out.println("2. Desencriptar texto");
        System.out.println("Otra opcion para salir");
        System.out.print("Opción: ");
    }

    private static void encriptarTexto(Scanner scanner) {
        System.out.print("Ingrese texto plano a encriptar: ");
        String textoPlano = scanner.nextLine();

        System.out.print("Ingrese clave (key): ");
        String clave = scanner.nextLine();

        String textoEncriptado = ALGORITMO_ENCRIPTACION_VIGENER.encriptar(textoPlano, clave);
        System.out.println("Texto encriptado: " + textoEncriptado);
    }

    private static void desencriptarTexto(Scanner scanner) {
        System.out.print("Ingrese texto cifrado a desencriptar: ");
        String textoCifrado = scanner.nextLine();

        System.out.print("Ingrese clave (key): ");
        String clave = scanner.nextLine();

        String textoDesencriptado = ALGORITMO_ENCRIPTACION_VIGENER.desencriptar(textoCifrado, clave);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }
}
