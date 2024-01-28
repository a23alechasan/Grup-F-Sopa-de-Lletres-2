import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class testBuscarPalabra {

    @org.junit.jupiter.api.Test
    void buscarPalabraParaulaExisteixoNo() {
        char[][] matriu = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
        assertTrue(buscarPalabra(matriu, "abc"));
        assertTrue(buscarPalabra(matriu, "aeim"));
        assertTrue(buscarPalabra(matriu, "afk"));
        assertFalse(buscarPalabra(matriu, "eeee"));
        assertFalse(buscarPalabra(matriu, "xyz"));
    }


}