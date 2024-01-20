import java.util.Scanner;

public class Sopadelletres {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        (Fer Funcio main) -Alex
        >demanar lletres (min max 100) -Iker (demanarLletres)
        >convertir-les a matriu 10x10 -Marc (lletresAMatriu)
        >imprimir matriu -Adrian (ImprimirMatriu)
        >solicitar paraules while (!true)
        -->descartar si la paraula introduida < 3 caracters i > 10 caracters
        -->detectar si la paraula introduida es troba (horitzontal)
        -->detectar si la paraula introduida es troba (vertical)
        -->pintar paraules de vermell quan son trobades
        -->identificar si les 5 paraules s'han trobat
        >while (!true) s'acaba*/


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
                int posicion = Buscarpalabra(matriu, palabra);
                if (posicion != null) {
                    palabrasEncontradas++;
                    ImprimMatriuEnSopa(matriu, palabra, posicion);
                    mostrarMatriz(matriu);
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

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
        static void Buscarpalabra ( char[][] matriu, String palabra){

            for (int i = 0; i < matriu.length; i++) {
                String fila = new String(matriu[i]);
                if (fila.contains(palabra)) {
                    System.out.println("La palabra " + (ANSI_RED + palabra + ANSI_RESET) + " " + "esta en la fila " + i);
                    return;
                }
                for (int j = 0; j < matriu[0].length; j++) {
                    String columna = "";
                    for (int k = 0; k < matriu.length; k++) {
                        columna += matriu[k][j];
                    }
                    if (columna.contains(palabra)) {
                        System.out.println("La palabra " + (ANSI_RED + palabra + ANSI_RESET) + " " + "esta en la columa " + j);
                        return ;
                    }
                }
            }
            System.out.println("La palabra " + palabra + " no esta en la sopa de letras. ");
        }

        static void ImprimMatriuEnSopa ( char [][] matriu , String palabra, int [] posicion ) {
            int fila = posicion[0];
            int columna = posicion[1];

            for (int i = 0; i < palabra.length(); i++) {
                matriu[fila][columna] = Character.toUpperCase(palabra.charAt(i));
                if (fila < matriu.length - 1 && columna < matriu[0].length - 1) {
                    fila++;
                    columna++;
                    System.out.println(matriu[fila][columna]);
                }
                System.out.println(); {

                }
            }
        }
        static void mostrarMatriz ( char[][] matriu){

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(matriu[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
