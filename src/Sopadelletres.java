import java.util.Scanner;

public class Sopadelletres {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matriu = {
                {'N', 'A', 'S', 'Q', 'Y', 'C', 'C', 'S', 'O', 'Z'},
                {'M', 'R', 'W', 'O', 'I', 'H', 'Z', 'N', 'F', 'R'},
                {'Z', 'U', 'I', 'F', 'E', 'U', 'W', 'B', 'Y', 'T'},
                {'P', 'B', 'F', 'P', 'C', 'S', 'F', 'Q', 'Q', 'I'},
                {'P', 'Y', 'T', 'H', 'O', 'N', 'B', 'G', 'V', 'I'},
                {'J', 'P', 'D', 'D', 'B', 'T', 'N', 'E', 'V', 'W'},
                {'G', 'G', 'E', 'S', 'O', 'Y', 'P', 'Y', 'T', 'U'},
                {'F', 'Y', 'U', 'I', 'L', 'E', 'C', 'H', 'A', 'V'},
                {'V', 'B', 'Z', 'S', 'H', 'X', 'T', 'A', 'J', 'T'},
                {'D', 'Z', 'X', 'L', 'Y', 'J', 'A', 'V', 'A', 'Q'}
        };

        mostrarMatriz(matriu);

        int palabrasEncontradas = 0;

        while (palabrasEncontradas < 5) {
            System.out.println("Escriu una paraula :");
            String palabra = sc.nextLine().toUpperCase();

            if (palabra.length() > 3 && palabra.length() <= 10) {
                if (buscarPalabra(matriu, palabra)) {
                    palabrasEncontradas++;
                    System.out.println("Paraules trobades: " + palabrasEncontradas);
                    pintarEnRojo(matriu);
                } else {
                    System.out.println("La paraula " + palabra + " no està a la sopa de lletres.");
                }
            } else {
                System.out.println("La longitud de la paraula ha de ser entre 3 i 10 lletras.");
            }
        }

        System.out.println("Totes les paraules s'han trobat");
        sc.close();
    }

    /**
     * This function searches if the words written are found in the matrix.
     * @param matriu definex the matrix.
     * @param palabra defines the word the funciont tries to search.
     * @return it returns true is the word is found within the matrix.
     */
    static boolean buscarPalabra(char[][] matriu, String palabra) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                if (buscarPalabraEnDireccion(matriu, palabra, i, j, 0, 1) ||
                        buscarPalabraEnDireccion(matriu, palabra, i, j, 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This function defines the lenght of the word,and the starting row and colum the words are at plus the direction in which they are,also searches if the words are within the confines of the matrix,
     * if they are it proceeds to check character by character to check if the word is in the matrix in the right position.
     * @param matriu defines the matrix in which you look for the words.
     * @param palabra is the word to search.
     * @param fila defines the starting row of the word.
     * @param columna defines the starting column of the word.
     * @param dirFila indicates the direction in which you want to look for in the row.
     * @param dirColumna indicates the direction in which you want to look for in the column.
     * @return it returns false if the word is not found in the right position, and true if the word is found, and marks the found chars of the word in lower case.
     */
    static boolean buscarPalabraEnDireccion(char[][] matriu, String palabra, int fila, int columna, int dirFila, int dirColumna) {
        int longitud = palabra.length();
        int nuevaFila = fila + (longitud - 1) * dirFila;
        int nuevaColumna = columna + (longitud - 1) * dirColumna;

        if (nuevaFila >= 0 && nuevaFila < matriu.length && nuevaColumna >= 0 && nuevaColumna < matriu[0].length) {
            for (int k = 0; k < longitud; k++) {
                char letra = matriu[fila + k * dirFila][columna + k * dirColumna];
                if (Character.isUpperCase(letra) && letra != palabra.charAt(k)) {
                    for (int l = 0; l <= k; l++) {
                        matriu[fila + l * dirFila][columna + l * dirColumna] = Character.toUpperCase(matriu[fila + l * dirFila][columna + l * dirColumna]);
                    }
                    return false;
                }
            }

            for (int k = 0; k < longitud; k++) {
                matriu[fila + k * dirFila][columna + k * dirColumna] = Character.toLowerCase(matriu[fila + k * dirFila][columna + k * dirColumna]);
            }
            return true;
        }

        return false;
    }



    /**
     * This funtion prints the matrix on the console.
     * @param matriu defines the matrix.
     */
    static void mostrarMatriz(char[][] matriu) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This function pritns the matrix with the found character printed in red.
     * @param matriu determines the matrix.
     */
    static void pintarEnRojo(char[][] matriu) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = matriu[i][j];
                if (Character.isLowerCase(c)) {
                    System.out.print(ANSI_RED + Character.toUpperCase(c) + ANSI_RESET + " ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println();
        }
    }
}
