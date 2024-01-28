import org.junit.jupiter.api.Test;

class SopadelletresTest {

    @Test
    void testPintarEnRojo() {

        char[][] matrizVacia = new char[10][10];
        pintarEnRojo(matrizVacia);

        char[][] matrizMinusculas = {
                {'a', 'B', 'c', 'D', 'e', 'F', 'g', 'H', 'i', 'J'},
                {'K', 'l', 'M', 'n', 'O', 'p', 'Q', 'r', 'S', 't'},
                {'U', 'v', 'W', 'x', 'Y', 'z', 'A', 'B', 'C', 'D'},
                {'e', 'F', 'g', 'H', 'i', 'J', 'K', 'l', 'M', 'n'},
                {'O', 'p', 'Q', 'r', 'S', 't', 'U', 'v', 'W', 'x'},
                {'Y', 'z', 'A', 'B', 'C', 'D', 'e', 'F', 'g', 'H'},
                {'i', 'J', 'K', 'l', 'M', 'n', 'O', 'p', 'Q', 'r'},
                {'S', 't', 'U', 'v', 'W', 'x', 'Y', 'z', 'A', 'B'},
                {'C', 'D', 'e', 'F', 'g', 'H', 'i', 'J', 'K', 'l'},
                {'M', 'n', 'O', 'p', 'Q', 'r', 'S', 't', 'U', 'v'}
        };
        pintarEnRojo(matrizMinusculas);

        char[][] matrizMayusculas = {
                {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
                {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'},
                {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
                {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'},
                {'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'}
        };
        pintarEnRojo(matrizMayusculas);
    }

    static void pintarEnRojo(char[][] matriu) {
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
    }
}
