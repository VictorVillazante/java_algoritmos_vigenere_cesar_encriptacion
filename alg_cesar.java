import java.util.*;

class AlgCesar{
    static String []valores={" ","!","'","#","%","&","(",")","*","+",",","-",".","/","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","{","}","á","é","í","ó","ú"};
    //static String []valores={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static void main(String args[]){
        System.out.println("Alg cesar");
        Scanner scanner = new Scanner(System.in);
        int op=0;
        do {
            System.out.print("Ingrese opcion: \n1.Encriptar\n2.Desencriptar\nCualquier numero para salir\n");
            op = Integer.parseInt(scanner.nextLine());
            switch(op){
                case 1:
                System.out.print("Ingrese texto plano a encriptar : ");
                String texto = scanner.nextLine();
                System.out.print("Ingrese key (numero enteros): ");
		        int key = Integer.parseInt(scanner.nextLine());
                String encCesar=encriptar(texto,key);
                System.out.println("Texto encriptado con alg cesar:"+encCesar);
                break;
                case 2:
                System.out.print("Ingrese texto plano a desencriptar : ");
                String textod = scanner.nextLine();
                System.out.print("Ingrese key: ");
		        int keyd = Integer.parseInt(scanner.nextLine());
                String d=desencriptar(textod,keyd);
                System.out.println("Texto desencriptado con alg cesar:"+d);
                break;
                default:
            }
        } while (op>=1&&op<=2);
    }

    private static String desencriptar(String texto,int key) {
        System.out.println("Tamaño valores:"+valores.length);
        int t=valores.length;
        System.out.println(texto);
        String encriptado="";
        for(int i=0;i<texto.length();i++){
            String c=texto.charAt(i)+"";
            //System.out.println(obtenerNumero(c));
            int valorn=obtenerNumero(c)-(key%valores.length);
            if(valorn<0){
                valorn=t+valorn;
            }
            int ni=(valorn)%t;
            System.out.println(ni);
            encriptado+=valores[ni];
        }
        return encriptado;    
    }

    private static String encriptar(String texto,int key) {
        System.out.println("Tamaño valores:"+valores.length);
        int t=valores.length;
        System.out.println(texto);
        String encriptado="";
        for(int i=0;i<texto.length();i++){
            String c=texto.charAt(i)+"";
            //System.out.println(obtenerNumero(c));
            int ni=(obtenerNumero(c)+(key%valores.length))%t;
            System.out.println(ni);
            encriptado+=valores[ni];
        }
        return encriptado;
    }

    private static int obtenerNumero(String c) {
        for(int i=0;i<valores.length;i++){
            if(valores[i].equals(c)){
                return i;
            }
        }
        return -1;
    }

    // private static String buscar(char charAt,int key) {
    //     switch (charAt){
    //         case "A": return ""
    //     }
    //     return null;
    // }
}