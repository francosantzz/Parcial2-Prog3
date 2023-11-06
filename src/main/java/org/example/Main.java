package org.example;

import java.util.Scanner;

public class Main {
    // Función para verificar si una línea contiene una secuencia de 4 caracteres iguales
    static boolean checkLinea(char[] linea) {
        for (int i = 0; i <= linea.length - 4; i++) {
            if (linea[i] == linea[i + 1] && linea[i] == linea[i + 2] && linea[i] == linea[i + 3]) {
                return true;
            }
        }
        return false;
    }
    // Función para verificar si una matriz representa a un mutante
    static boolean is_mutant(String[] filas){
        int cont = 0;
        // Verifica si la primera fila es nula (no inicializada)
        if (filas[0] == null) {
            return false;
        }

        // Convierte las secuencias de ADN en una matriz de caracteres
        char[][] matriz = new char[6][6];
        for (int i = 0; i < 6; i++) {
            matriz[i] = filas[i].toCharArray();
        }

        // Verifica secuencias mutantes en filas
        for (char[] fila : matriz) {
            if (checkLinea(fila)) {
                cont++;
            }
        }

        // Verifica secuencias mutantes en columnas
        for (int columna = 0; columna < 6; columna++) {
            char[] columnaArray = new char[6];
            for (int i = 0; i < 6; i++) {
                columnaArray[i] = matriz[i][columna];
            }
            if (checkLinea(columnaArray)) {
                cont++;
            }
        }

        // Verifica secuencias mutantes en diagonales derecha
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (matriz[i][j] == matriz[i + 1][j + 1] && matriz[i][j] == matriz[i + 2][j + 2] && matriz[i][j] == matriz[i + 3][j + 3]) {
                    cont++;
                }
            }
        }

        // Verifica secuencias mutantes en diagonales izquierda
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (matriz[i][j] == matriz[i + 1][j - 1] && matriz[i][j] == matriz[i + 2][j - 2] && matriz[i][j] == matriz[i + 3][j - 3]) {
                    cont++;
                }
            }
        }

        // Imprime la cantidad de secuencias encontradas
        System.out.println("Secuencias encontradas: " + cont);

        // Devuelve true si hay al menos 2 secuencias mutantes
        if (cont > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[] filas = new String[6];
        // Solicita al usuario ingresar 6 secuencias de ADN válidas
        for (int i = 0; i < 6; i++) {
            String fila="";
            boolean entradaValida = false;

            while (!entradaValida) {
                System.out.print("Ingrese la secuencia " + (i + 1) + " (6 caracteres entre A, T, C y G): ");
                fila = leer.next().toUpperCase();

                if (fila.length() == 6 && fila.matches("[ATCG]+")) {
                    entradaValida = true;
                    filas[i] = fila;
                } else {
                    System.out.println("La secuencia ingresada no es válida. Deben ser 6 caracteres entre A, T, C y G.");
                }
            }

        }
        // Imprime las filas ingresadas por el usuario
        System.out.println("Filas ingresadas:");
        for (String fila : filas) {
            System.out.println(fila);
        }
        // Verifica si la matriz representa un mutante y muestra el resultado
        boolean resultado = is_mutant(filas);
        if (resultado){
            System.out.println("\nEs mutante");
        }else {
            System.out.println("\nNo es mutante");
        }
    }
}