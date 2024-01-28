import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testBuscarPalabraEnDireccion {

    @org.junit.jupiter.api.Test
    void buscarPalabraEnDireccion() {
        char[][] matriu = {
                {'H', 'E', 'L', 'L'},
                {'O', 'A', 'A', 'A'},
                {'W', 'O', 'R', 'D'},
                {'X', 'Y', 'Z', 'Z'}
        };

        assertTrue(buscarPalabraEnDireccion(matriu, "HELLO", 0, 0, 0, 1));
        assertEquals("hello", convertirMatriuAMinuscules(matriu));

        assertTrue(buscarPalabraEnDireccion(matriu, "OXYZ", 0, 0, 1, 0));
        assertEquals("o\nx\ny\nz", convertirMatriuAMinuscules(matriu));

        assertTrue(buscarPalabraEnDireccion(matriu, "AWXZ", 0, 0, 1, 1));
        assertEquals("a\nw\nx\nz", convertirMatriuAMinuscules(matriu));

        assertTrue(buscarPalabraEnDireccion(matriu, "OA", 2, 0, -1, 1));
        assertEquals("o\na", convertirMatriuAMinuscules(matriu));

        assertFalse(buscarPalabraEnDireccion(matriu, "WORLD", 2, 3, 1, 1));
        assertFalse(buscarPalabraEnDireccion(matriu, "AWOL", 2, 0, 1, 1));
    }
    private String convertirMatriuAMinuscules(char[][] matriu) {
        StringBuilder result = new StringBuilder();
        for (char[] fila : matriu) {
            for (char c : fila) {
                result.append(Character.toLowerCase(c)).append(" ");
            }
            result.append("\n");
        }
        return result.toString().trim();
    }
}