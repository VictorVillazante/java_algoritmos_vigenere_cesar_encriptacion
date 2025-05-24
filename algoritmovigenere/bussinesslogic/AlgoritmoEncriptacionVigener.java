package algoritmovigenere.bussinesslogic;
import java.util.*;

public class AlgoritmoEncriptacionVigener {
    private static final List<String> CARACTERES_PERMITIDOS=Arrays.asList(" ","!","'","#","%","&","(",")","*","+",",","-",".","/","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","{","}","á","é","í","ó","ú");

    public String desencriptar(String textoEncriptado,String clave) {
        clave = ajustarClave(textoEncriptado.length(), clave);
        StringBuilder textoDesencriptado=new StringBuilder();
        for(int el=0;el<clave.length();el++){
            int posicionCaracterEncriptado=buscarPosicion(textoEncriptado.charAt(el));
            int posicionCaracterKey=buscarPosicion(clave.charAt(el));
            int posicionCaracterDesencriptado=0;
            posicionCaracterDesencriptado = (posicionCaracterEncriptado - posicionCaracterKey + CARACTERES_PERMITIDOS.size()) % CARACTERES_PERMITIDOS.size();
            textoDesencriptado.append(CARACTERES_PERMITIDOS.get(posicionCaracterDesencriptado));
        }
        return textoDesencriptado.toString();
    }

    private static String ajustarClave(int tamanioTexto, String clave) {
        if(tamanioTexto<clave.length()){
            clave=clave.substring(0, tamanioTexto);
        }
        if(tamanioTexto>clave.length()){
            String copiaClave=clave;
            while(tamanioTexto>clave.length()){
                clave+=copiaClave;
            }
            clave=clave.substring(0, tamanioTexto);
        }
        return clave;
    }

    public String encriptar(String texto, String clave) {
        clave = ajustarClave(texto.length(), clave);
        StringBuilder textoEncriptado=new StringBuilder();
        for(int el=0;el<clave.length();el++){
            int posicionCaracterTexto=buscarPosicion(texto.charAt(el));
            int posicionCaracterClave=buscarPosicion(clave.charAt(el));
            textoEncriptado.append(CARACTERES_PERMITIDOS.get((posicionCaracterTexto+posicionCaracterClave)%CARACTERES_PERMITIDOS.size()));
        }
        return textoEncriptado.toString();
    }

    private static int buscarPosicion(char caracter) {
        String caracterStr=String.valueOf(caracter);
        if (CARACTERES_PERMITIDOS.indexOf(caracterStr)<0) throw new IllegalArgumentException("Caracter no permitido: " + caracter);
        return CARACTERES_PERMITIDOS.indexOf(caracterStr);
    }
}
