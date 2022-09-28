import java.util.*;

public class alg_vigener {
    static String []valores={" ","!","'","#","%","&","(",")","*","+",",","-",".","/","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","{","}","á","é","í","ó","ú"};
    //static String []valores={"A","B","C","D","E"};
    //static String []valores={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static void main(String args[]){

        System.out.println("Alg vigener");
        Scanner scanner = new Scanner(System.in);
        int op=0;
        do {
            System.out.print("Ingrese opcion: \n1.Encriptar\n2.Desencriptar\nCualquier numero para salir\n");
            op = Integer.parseInt(scanner.nextLine());
            switch(op){
                case 1:
                System.out.print("Ingrese texto plano a encriptar : ");
                String texto = scanner.nextLine();
                System.out.print("Ingrese key (texto): ");
                String key = (scanner.nextLine());
                String encVigener=encriptar(texto,key);
                System.out.println("Texto encriptado con alg vigener:"+encVigener);
                break;
                case 2:
                System.out.print("Ingrese texto plano a desencriptar : ");
                String textod = scanner.nextLine();
                System.out.print("Ingrese key (texto): ");
                String keyd = (scanner.nextLine());
                String d=desencriptar(textod,keyd);
                System.out.println("Texto desencriptado con alg vigener:"+d);
                break;
                default:
            }
        } while (op>=1&&op<=2);
    }

    private static String desencriptar(String texto,String key) {
        if(texto.length()<key.length()){
            key=key.substring(0, texto.length());
            // System.out.println(key+"------"+texto);
        }
        if(texto.length()>key.length()){
            String aux=key;
            while(texto.length()>key.length()){
                key+=aux;
            }
            key=key.substring(0, texto.length());
            // System.out.println(key+"------"+texto);
        }
        // String[][] matrizValores= new String[valores.length][valores.length];
        
        // for(int f=0;f<valores.length;f++){
        //     for(int c=0;c<valores.length;c++){
        //         matrizValores[f][c]=valores[(f+c)%valores.length];
        //     }
        // }
        // for(int f=0;f<valores.length;f++){
        //     for(int c=0;c<valores.length;c++){
        //         System.out.print( matrizValores[f][c]+" ");
        //     }
        //     System.out.println();
        // }
        String d="";
        for(int el=0;el<key.length();el++){
            int idxT=buscarIndex(texto.charAt(el)+"");
            int idxK=buscarIndex(key.charAt(el)+"");
            int i=0;
            if(idxT-idxK<0){
                i=valores.length+(idxT-idxK);
            }
            else{
                i=(idxT-idxK)%valores.length;
            }
            d+=valores[i];
        }
        return d;
    }

    private static String encriptar(String texto, String key) {
        if(texto.length()<key.length()){
            key=key.substring(0, texto.length());
            // System.out.println(key+"------"+texto);
        }
        if(texto.length()>key.length()){
            String aux=key;
            while(texto.length()>key.length()){
                key+=aux;
            }
            key=key.substring(0, texto.length());
            // System.out.println(key+"------"+texto);
        }
        // String[][] matrizValores= new String[valores.length][valores.length];
        
        // for(int f=0;f<valores.length;f++){
        //     for(int c=0;c<valores.length;c++){
        //         matrizValores[f][c]=valores[(f+c)%valores.length];
        //     }
        // }
        // for(int f=0;f<valores.length;f++){
        //     for(int c=0;c<valores.length;c++){
        //         System.out.print( matrizValores[f][c]+" ");
        //     }
        //     System.out.println();
        // }
        String cifrado="";
        for(int el=0;el<key.length();el++){
            int idxT=buscarIndex(texto.charAt(el)+"");
            int idxK=buscarIndex(key.charAt(el)+"");
            cifrado+=valores[(idxT+idxK)%valores.length];
        }
        return cifrado;
    }

    private static int buscarIndex(String el) {
        for(int i=0;i<valores.length;i++){
            if(el.equals(valores[i])){
                return i;
            }
        }
        return 0;
    }
}
