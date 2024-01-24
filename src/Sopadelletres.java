import java.util.Scanner;

public class Sopadelletres {
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

            if (palabra.length() >= 3 && palabra.length() <= 10) {
                if (buscarPalabra(matriu, palabra)) {
                    palabrasEncontradas++;
                    System.out.println("Paraules trobades: " + palabrasEncontradas);
                } else {
                    System.out.println("La paraula " + palabra + " no està a la sopa de lletres.");
                }
            } else {
                System.out.println("La longitud de la paraula ha de ser entre 3 i 10 lletras.");
            }
        }

        pintarEnRojo(matriu);
        System.out.println("Totes les paraules s'han trobat");
        sc.close();
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    static boolean buscarPalabra(char[][] matriu, String palabra) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length - palabra.length() + 1; j++) {
                boolean encontrada = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (matriu[i][j + k] != palabra.charAt(k)) {
                        encontrada = false;
                        break;
                    }
                }
                if (encontrada) {
                    marcarPalabraEncontradaHorizontal(matriu, i, j, palabra.length());
                    return true;
                }
            }
        }

        for (int j = 0; j < matriu[0].length; j++) {
            for (int i = 0; i < matriu.length - palabra.length() + 1; i++) {
                boolean encontrada = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (matriu[i + k][j] != palabra.charAt(k)) {
                        encontrada = false;
                        break;
                    }
                }
                if (encontrada) {
                    marcarPalabraEncontradaVertical(matriu, i, j, palabra.length());
                    return true;
                }
            }
        }

        // Corregir lógica para la dirección diagonal
        for (int i = 0; i < matriu.length - palabra.length() + 1; i++) {
            for (int j = 0; j < matriu[0].length - palabra.length() + 1; j++) {
                boolean encontrada = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (matriu[i + k][j + k] != palabra.charAt(k)) {
                        encontrada = false;
                        break;
                    }
                }
                if (encontrada) {
                    marcarPalabraEncontradaDiagonal(matriu, i, j, palabra.length());
                    return true;
                }
            }
        }

        return false;
    }

    static void marcarPalabraEncontradaHorizontal(char[][] matriu, int fila, int columna, int longitud) {
        for (int k = 0; k < longitud; k++) {
            matriu[fila][columna + k] = Character.toLowerCase(matriu[fila][columna + k]);
        }
    }

    static void marcarPalabraEncontradaVertical(char[][] matriu, int fila, int columna, int longitud) {
        for (int k = 0; k < longitud; k++) {
            matriu[fila + k][columna] = Character.toLowerCase(matriu[fila + k][columna]);
        }
    }

    static void marcarPalabraEncontradaDiagonal(char[][] matriu, int fila, int columna, int longitud) {
        for (int k = 0; k < longitud; k++) {
            matriu[fila + k][columna + k] = Character.toUpperCase(matriu[fila + k][columna + k]);
        }
    }

    static void mostrarMatriz(char[][] matriu) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void pintarEnRojo(char[][] matriu) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Character.isLowerCase(matriu[i][j])) {
                    System.out.print(ANSI_RED + matriu[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(matriu[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}








