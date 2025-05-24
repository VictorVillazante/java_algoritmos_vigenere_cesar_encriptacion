package algoritmocesar.services;

public class AlgoritmoEncriptacionCesar{
    private final static String []CARACTERES_ACEPTADOS={" ","!","'","#","%","&","(",")","*","+",",","-",".","/","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","{","}","á","é","í","ó","ú"};

    public String desencriptar(String textoEncriptado,int key) {
        int numeroCaracteresAceptados=CARACTERES_ACEPTADOS.length;
        StringBuilder textoDesencriptado = new StringBuilder();
        for(int i=0;i<textoEncriptado.length();i++){
            String caracter=textoEncriptado.charAt(i)+"";
            int valorn=obtenerPosicionCaracter(caracter)-(key%numeroCaracteresAceptados);
            if(valorn<0){
                valorn=numeroCaracteresAceptados+valorn;
            }
            int posicionCaracterDesencriptado=(valorn)%numeroCaracteresAceptados;
            textoDesencriptado.append(CARACTERES_ACEPTADOS[posicionCaracterDesencriptado]);
        }
        return textoDesencriptado.toString();    
    }

    public String encriptar(String texto,int key) {
        int numeroCaracteresAceptados=CARACTERES_ACEPTADOS.length;
        StringBuilder textoEncriptado = new StringBuilder();
        for(int i=0;i<texto.length();i++){
            String caracter=texto.charAt(i)+"";
            int posicionCaracterEncriptado=(obtenerPosicionCaracter(caracter)+(key%numeroCaracteresAceptados))%numeroCaracteresAceptados;
            textoEncriptado.append(CARACTERES_ACEPTADOS[posicionCaracterEncriptado]);
        }
        return textoEncriptado.toString();
    }

    private int obtenerPosicionCaracter(String caracter) {
        for(int i=0;i<CARACTERES_ACEPTADOS.length;i++){
            if(CARACTERES_ACEPTADOS[i].equals(caracter)){
                return i;
            }
        }
        throw new IllegalArgumentException("Caracter no permitido: " + caracter);
    }
}