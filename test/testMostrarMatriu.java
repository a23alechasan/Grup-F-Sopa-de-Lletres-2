import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testMostrarMatriu {

    @Test
    void testMostrarMatriz() {
        char[][] matrizVacia = new char[10][10];
        mostrarMatriz(matrizVacia);

        char[][] matrizAleatoria = {
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
                {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'9', '0', '!', '@', '#', '$', '%', '^', '&', '*'},
                {'(', ')', '-', '_', '+', '=', '{', '}', '[', ']'},
                {';', ':', '<', '>', '?', '/', '|', '\\', ',', '.'},
                {' ', '\t', '\n', '\r', '\f', '\b', '\'', '\"', '`', '~'}
        };
        mostrarMatriz(matrizAleatoria);

        char[][] matrizEspeciales = {
                {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'},
                {'-', '_', '+', '=', '{', '}', '[', ']', ';', ':'},
                {'<', '>', '?', '/', '|', '\\', ',', '.', ' ', '\t'},
                {'\n', '\r', '\f', '\b', '\'', '\"', '`', '~', 'a', 'b'}
        };
        mostrarMatriz(matrizEspeciales);

        char[][] matrizUnaFila = {
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}
        };
        mostrarMatriz(matrizUnaFila);

        char[][] matrizUnaColumna = {
                {'a'},
                {'b'},
                {'c'},
                {'d'},
                {'e'},
                {'f'},
                {'g'},
                {'h'},
                {'i'},
                {'j'}
        };
        mostrarMatriz(matrizUnaColumna);
    }

    static void mostrarMatriz(char[][] matriu) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }
}