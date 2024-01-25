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
            String palabra = sc.nextLine();

            if (palabra.length() >= 3 && palabra.length() <= 10) {
                if (buscarPalabra(matriu, palabra)) {
                    palabrasEncontradas++;
                    System.out.println("Paraules trobades: " + palabrasEncontradas);
                } else {
                    System.out.println("La paraula " + palabra + " no està a la sopa de lletres.");
                }
            } else {
                System.out.println("La longitud de la paraula ha de ser entre 3 i 10 caràcters.");
            }
        }

        System.out.println("Totes les paraules s'han trobat");
        sc.close();
    }

    static void mostrarMatriz(char[][] matriu) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean buscarPalabra(char[][] matriu, String palabra) {
        palabra = palabra.toUpperCase();

        // Busca la palabra horizontal en esta parte //
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10 - palabra.length(); j++) {
                boolean encontrada = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (matriu[i][j + k] != palabra.charAt(k) && matriu[i][j + k] != ' ') {
                        encontrada = false;
                        break;
                    }
                }
                if (encontrada) {
                    // Marcar la palabra en la matriz cambiando las letras a rojo //
                    for (int k = 0; k < palabra.length(); k++) {
                        if (matriu[i][j + k] != ' ') {
                            matriu[i][j + k] = palabra.charAt(k);
                        }
                    }
                    return true;
                }
            }
        }

        // Buscar la palabra vertial en la matriu //
        for (int i = 0; i <= 10 - palabra.length(); i++) {
            for (int j = 0; j < 10; j++) {
                boolean encontrada = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (matriu[i + k][j] != palabra.charAt(k) && matriu[i + k][j] != ' ') {
                        encontrada = false;
                        break;
                    }
                }
                if (encontrada) {
                    // Marcar la palabra en la matriz cambiando las letras a rojo //
                    for (int k = 0; k < palabra.length(); k++) {
                        if (matriu[i + k][j] != ' ') {
                            matriu[i + k][j] = palabra.charAt(k);
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
}

