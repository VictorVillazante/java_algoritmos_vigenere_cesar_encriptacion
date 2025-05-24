package algoritmocesar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import algoritmocesar.services.AlgoritmoEncriptacionCesar;

public class Main {
    private static final AlgoritmoEncriptacionCesar ALGORITMO_ENCRIPTACION_CESAR = new AlgoritmoEncriptacionCesar();
    private static final List<String>  OPCIONES_MENU=Arrays.asList("1","2");
    public static void main(String args[]){
        System.out.println("Algoritmo cesar");  
        Scanner scanner = new Scanner(System.in);
        String opcionSeleccionada="";
        do {
            System.out.print("Ingrese opcion: \n1.Encriptar\n2.Desencriptar\nCualquier otro caracter para salir\n");
            opcionSeleccionada = scanner.nextLine();
            switch(opcionSeleccionada){
                case "1":
                    ejecutarEncriptadoAlgoritmoCesar(scanner);
                break;
                case "2":
                    ejecutarDesencriptadoAlgoritmoCesar(scanner);
                break;
                default:
            }
        } while (OPCIONES_MENU.indexOf(opcionSeleccionada)>=0);
    }

    private static void ejecutarDesencriptadoAlgoritmoCesar(Scanner scanner) {
        try {
            System.out.print("Ingrese texto plano a desencriptar : ");
            String textoEncriptado = scanner.nextLine();
            System.out.print("Ingrese key: ");
            int key = obtenerKey(scanner);
            String textoDesencriptado=ALGORITMO_ENCRIPTACION_CESAR.desencriptar(textoEncriptado,key);
            System.out.println("Texto desencriptado con alg cesar:"+textoDesencriptado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Ingrese un valor entero");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ejecutarEncriptadoAlgoritmoCesar(Scanner scanner) {
        try {
            System.out.print("Ingrese texto plano a encriptar : ");
            String texto = scanner.nextLine();
            System.out.print("Ingrese key (numero enteros): ");
            int key = obtenerKey(scanner);
            String textoEncriptado=ALGORITMO_ENCRIPTACION_CESAR.encriptar(texto,key);
            System.out.println("Texto encriptado con alg cesar:"+textoEncriptado);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int obtenerKey(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingrese un valor entero en el key");
        }
    }

}
