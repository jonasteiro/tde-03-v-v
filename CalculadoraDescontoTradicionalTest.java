package calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescontoTradicionalTest {

    CalculadoraDescontoTradicional calc = new CalculadoraDescontoTradicional();

    @Test
    public void testeValorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularValorFinal(0, false);
        });
    }

    @Test
    public void testeValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularValorFinal(-20, false);
        });
    }

    @Test
    public void testeCompraAbaixoDe100ComFrete() {
        double resultado = calc.calcularValorFinal(80, false);
        assertEquals(95.0, resultado, 0.01);
    }

    @Test
    public void testeCompraSemDescontoESemFrete() {
        double resultado = calc.calcularValorFinal(200, false);
        assertEquals(200.0, resultado, 0.01);
    }

    @Test
    public void testeCompraExatamente500() {
        double resultado = calc.calcularValorFinal(500, false);
        assertEquals(500.0, resultado, 0.01);
    }

    @Test
    public void testeDesconto10Porcento() {
        double resultado = calc.calcularValorFinal(600, false);
        assertEquals(540.0, resultado, 0.01);
    }

    @Test
    public void testeCompraExatamente1000() {
        double resultado = calc.calcularValorFinal(1000, false);
        assertEquals(900.0, resultado, 0.01);
    }

    @Test
    public void testeDesconto20Porcento() {
        double resultado = calc.calcularValorFinal(1500, false);
        assertEquals(1200.0, resultado, 0.01);
    }

    @Test
    public void testeClienteVipSemDescontoDeFaixa() {
        double resultado = calc.calcularValorFinal(200, true);
        assertEquals(190.0, resultado, 0.01);
    }

    @Test
    public void testeClienteVipComDesconto10Porcento() {
        double resultado = calc.calcularValorFinal(600, true);
        assertEquals(513.0, resultado, 0.01);
    }

    @Test
    public void testeClienteVipComDesconto20Porcento() {
        double resultado = calc.calcularValorFinal(2000, true);
        assertEquals(1520.0, resultado, 0.01);
    }

    @Test
    public void testeClienteVipQueCaiAbaixoDe100EPagaFrete() {
        double resultado = calc.calcularValorFinal(105, true);
        assertEquals(114.75, resultado, 0.01);
    }
}