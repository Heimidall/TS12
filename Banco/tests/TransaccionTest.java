import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {
    private final Transaccion transaccion = new Transaccion();

    @Test
    void revisarSaldoinicial() {
        assertEquals(1000000, transaccion.getSaldoPesos());
        assertEquals(1000, transaccion.getSaldoDolar());
    }

    @Test
    void testRetirarSaldo() throws Exception {
        transaccion.retirarSaldo("USD 100");
        assertEquals(900, transaccion.getSaldoDolar());
        transaccion.retirarSaldo("CLP 200000");
        assertEquals(800000, transaccion.getSaldoPesos());
        assertThrows(Exception.class, () -> transaccion.retirarSaldo("CLP -200000"), "Error con la operación intente nuevamente");
        assertThrows(Exception.class, () -> transaccion.retirarSaldo("CASH 1000000"), "Error con la operación intente nuevamente");
        assertThrows(Exception.class, () -> transaccion.retirarSaldo("CLP 1000000"), "Error con la operación intente nuevamente");
        assertThrows(Exception.class, () -> transaccion.retirarSaldo("USD 10000"), "Error con la operación intente nuevamente");
    }

    @Test
    void testDepositoSaldo() throws Exception{
        transaccion.depositarSaldo("USD 150");
        assertEquals(1150, transaccion.getSaldoDolar());
        transaccion.depositarSaldo("CLP 200000");
        assertEquals(1200000, transaccion.getSaldoPesos());
        assertThrows(Exception.class, () -> transaccion.depositarSaldo("CLP -1000000"), "Error con la operación intente nuevamente");
        assertThrows(Exception.class, () -> transaccion.depositarSaldo("CASH 1000000"), "Error con la operación intente nuevamente");
    }

    @Test
    void testCantidadOperaciones() throws Exception {
        //verificar la resta en la cantidad de operaciones
        // ASegurarse no tener una cantidad menor que cero
        // en caso de ser cero tirar error siempre
        assertEquals(4, transaccion.getOperaciones());
        transaccion.usoSesion();
        assertEquals(3, transaccion.getOperaciones());
        transaccion.depositarSaldo("USD 150");
        assertEquals(2, transaccion.getOperaciones());
        transaccion.retirarSaldo("USD 100");
        assertEquals(1, transaccion.getOperaciones());
        transaccion.depositarSaldo("USD 150");
        assertEquals(0, transaccion.getOperaciones());
        assertThrows(Exception.class, () -> transaccion.usoSesion(), "La sesión ha expirado");


    }

    @Test
    void testHistorial() throws Exception {
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("");
        expectedOutput.add("");
        expectedOutput.add("1000000, CLP, 1000, USD");
        transaccion.retirarSaldo("USD 100");
        expectedOutput.add("1000000, CLP, 900, USD");
        assertLinesMatch(expectedOutput.subList(expectedOutput.size()-3,expectedOutput.size()),transaccion.getHistorial());

    }
}
