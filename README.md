# algoritmos_encriptacion
Este repositorio tiene algoritmos de encriptacion cesar, transposicion, vigenere. Util para poder encriptar cualquier tipo de texto.
## Tecnologias usadas
- Java 17
## Que hace este repositorio?
Permite ejecutar encriptaciones de texto utilizando los siguientes algoritmos:
- César: Desplazamiento de caracteres en el alfabeto.
- Transposición: Reorganización de caracteres siguiendo una clave.
- Vigenère: Encriptación con clave utilizando múltiples alfabetos.
## Como ejecutar el proyecto?
### Prerequisitos
- Java 17 instalado
### Pasos
1. Clonar el repositorio
2. Desde la ruta principal correr los comandos de acuerdo al algoritmo que se quiera ejecutar
    - Para el algoritmo de transposicion
    ```bash
    javac -d out algoritmotraspocision/Main.java
    java -cp out algoritmotraspocision.Main
    ```
    - Para el algoritmo cesar
    ```bash
    javac -d out algoritmocesar/Main.java
    java -cp out algoritmocesar.Main
    ```
    - Para el algoritmo vigenere
    ```bash
    javac -d out algoritmocesar/Main.java
    java -cp out algoritmocesar.Main
    ```