package algoritmotraspocision.bussinesslogic;

public class AlgoritmoTransposicion {
    private static final int COLUMNAS = 3;
    private static final char RELLENO = '0';

    public String encriptar(String texto) {
        String textoProcesado = prepararTexto(texto);
        int filas = textoProcesado.length() / COLUMNAS;
        char[][] matriz = new char[filas][COLUMNAS];

        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = textoProcesado.charAt(indice++);
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = 0; i < filas; i++) {
                resultado.append(matriz[i][j]);
            }
        }

        return resultado.toString();
    }

    public String desencriptar(String texto) {
        String textoProcesado = prepararTexto(texto);
        int filas = textoProcesado.length() / COLUMNAS;
        char[][] matriz = new char[filas][COLUMNAS];

        int indice = 0;
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = 0; i < filas; i++) {
                matriz[i][j] = textoProcesado.charAt(indice++);
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                resultado.append(matriz[i][j]);
            }
        }

        return resultado.toString().replace(String.valueOf(RELLENO), "").trim();
    }

    private static String prepararTexto(String texto) {
        String textoSinEspacios = texto.trim();
        int longitudModificada = textoSinEspacios.length();

        int caracteresFaltantes = COLUMNAS - (longitudModificada % COLUMNAS);
        if (caracteresFaltantes != COLUMNAS) {
            textoSinEspacios += String.valueOf(RELLENO).repeat(caracteresFaltantes);
        }

        return textoSinEspacios;
    }
}
