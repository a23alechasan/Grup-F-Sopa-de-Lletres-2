import java.util.Scanner;

public class SopaDeLLetres {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Sisplau, introdueix les lletres de la sopa de lletres");
        char[][] matriu = demanarLletres();
        mostrarMatriu(matriu);
        int palabrasEncontradas = 0;
        while (palabrasEncontradas < 5){
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
    }

    /**
     * Request a String to check if there are 100 letters.
     * @return letters to the function convertirLletresMatriu
     */

    private static char[][] demanarLletres() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dona 100 lletres seguides per començar el joc:");
        String lletres = input.nextLine();
        for (int i = 0; i < 100; i++) {
            if (lletres.length() != 100) {
                System.out.println("No hi han 100 lletres, torna a provar");
                lletres = input.nextLine();
            }
        }
        return convertirLletresMatriu(lletres);
    }

    /**
     * Convert and separate the 100 letters in a 10*10 matrix
     * @param lletres String where the 100 letters are saved
     * @return matriu Final result of the converted matriu
     */

    public static char[][] convertirLletresMatriu(String lletres) {
        char[][] matriu = new char[10][10];
        int index = 0;

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                matriu[f][c] = lletres.charAt(index++);
            }
        }
        return matriu;
    }

    /**
     * Show the matrix in the sceen
     * @param matriu char to show
     */
    public static void mostrarMatriu(char[][] matriu) {
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(matriu[f][c] + " ");
            }
            System.out.println();
        }
    }

    static boolean buscarPalabra(char[][] matriu, String palabra) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                if (buscarPalabraEnDireccion(matriu, palabra, i, j, 0, 1) ||
                        buscarPalabraEnDireccion(matriu, palabra, i, j, 1, 0) ||
                        buscarPalabraEnDireccion(matriu, palabra, i, j, 1, 1) ||
                        buscarPalabraEnDireccion(matriu, palabra, i, j, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean buscarPalabraEnDireccion(char[][] matriu, String palabra, int fila, int columna, int dirFila, int dirColumna) {
        int longitud = palabra.length();
        int nuevaFila = fila + (longitud - 1) * dirFila;
        int nuevaColumna = columna + (longitud - 1) * dirColumna;

        if (nuevaFila >= 0 && nuevaFila < matriu.length && nuevaColumna >= 0 && nuevaColumna < matriu[0].length) {
            for (int k = 0; k < longitud; k++) {
                char letra = matriu[fila + k * dirFila][columna + k * dirColumna];
                if (Character.isUpperCase(letra) && letra != palabra.charAt(k)) {
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
    static void pintarEnRojo(char[][] matriu) {
        System.out.println("Matriz amb les paraules marcades en vermell:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = matriu[i][j];
                if (Character.isLowerCase(c)) {
                    System.out.print("\u001B[31m" + Character.toUpperCase(c) + "\u001B[0m" + " ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}




