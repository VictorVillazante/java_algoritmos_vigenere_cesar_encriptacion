import java.util.*;

class algTransposicion{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int op=0;
        do {
            System.out.print("Ingrese opcion: \n1.Encriptar\n2.Desencriptar\nCualquier numero para salir\n");
            op = Integer.parseInt(scanner.nextLine());
            switch(op){
                case 1:
                System.out.print("Ingrese texto plano a encriptar : ");
                String texto = scanner.nextLine();
                String transposicionEncrp=encriptar(texto);
                System.out.println("Texto encriptado algoritmo transposicion:"+transposicionEncrp);
                break;
                case 2:
                System.out.print("Ingrese texto plano a desencriptar : ");
                String textod = scanner.nextLine();
                String d=desencriptar(textod);
                System.out.println("Texto desencriptado:"+d);
                break;
                default:
            }
        } while (op>=1&&op<=2);

       
        
    }

    private static String desencriptar(String texto) {
        String textoSinEspacios=texto;
        // System.out.println(textoSinEspacios);
        int s=textoSinEspacios.length();
        if(textoSinEspacios.length()%3!=0){
            for(int c=0;c<3-(s%3);c++){
                textoSinEspacios=textoSinEspacios+"0";
            }
        }
        // System.out.println(textoSinEspacios);
        int nfil=(int) Math.ceil((double)textoSinEspacios.length()/3);
        // System.out.println(nfil);
        String matriz[][]=new String[nfil][3];
        for(int j=0;j<3;j++){
            for(int i=0;i<nfil;i++){   
                matriz[i][j]=textoSinEspacios.charAt(0)+"";
                textoSinEspacios=textoSinEspacios.substring(1);
            }
        }
        String transposicionEncrp="";
        for(int i=0;i<nfil;i++){
            for(int j=0;j<3;j++){    
                transposicionEncrp+=(matriz[i][j]);
            }
        }
        transposicionEncrp=transposicionEncrp.replace("0","");
        transposicionEncrp=transposicionEncrp.trim();
        return transposicionEncrp;   
    }

    private static String encriptar(String texto) {
        String textoSinEspacios=texto.trim();
        System.out.println(textoSinEspacios);
        int s=textoSinEspacios.length();
        if(textoSinEspacios.length()%3!=0){
            for(int c=0;c<3-(s%3);c++){
                textoSinEspacios=textoSinEspacios+"0";
            }
        }
        System.out.println(textoSinEspacios);
        int nfil=(int) Math.ceil((double)textoSinEspacios.length()/3);
        System.out.println(nfil);
        String matriz[][]=new String[nfil][3];
        for(int i=0;i<nfil;i++){
            for(int j=0;j<3;j++){
                matriz[i][j]=textoSinEspacios.charAt(0)+"";
                textoSinEspacios=textoSinEspacios.substring(1);
            }
        }
        String transposicionEncrp="";
        for(int j=0;j<3;j++){
            for(int i=0;i<nfil;i++){
                transposicionEncrp+=(matriz[i][j]);
            }
        }
        return transposicionEncrp;
    }
}