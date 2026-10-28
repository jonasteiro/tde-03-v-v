package calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescontoTDDTeste {

    CalculadoraDescontoTDD calc = new CalculadoraDescontoTDD();

    // Ciclo 1: Desconto de 10% para compras acima de R$ 500,00
    @Test
    public void deveDar10PorcentoAcimaDe500() {
        double resultado = calc.calcularValorFinal(600, false);
        assertEquals(540.0, resultado, 0.01);
    }

    @Test
    public void naoDeveDarDescontoAte500() {
        double resultado = calc.calcularValorFinal(500, false);
        assertEquals(500.0, resultado, 0.01);
    }

    // Ciclo 2: Desconto de 20% para compras acima de R$ 1.000,00
    @Test
    public void deveDar20PorcentoAcimaDe1000() {
        double resultado = calc.calcularValorFinal(1500, false);
        assertEquals(1200.0, resultado, 0.01);
    }

    @Test
    public void deveDarApenas10PorcentoQuandoForExatamente1000() {
        double resultado = calc.calcularValorFinal(1000, false);
        assertEquals(900.0, resultado, 0.01);
    }

    // Ciclo 3: Cliente VIP ganha 5% adicional sobre o valor com desconto
    @Test
    public void deveAplicar5PorcentoAdicionalParaVip() {
        double resultado = calc.calcularValorFinal(600, true);
        assertEquals(513.0, resultado, 0.01);
    }

    @Test
    public void deveAplicarVipAcimaDe1000() {
        double resultado = calc.calcularValorFinal(2000, true);
        assertEquals(1520.0, resultado, 0.01);
    }

    // Ciclo 4: Frete fixo de R$ 15,00 se valor final ficar abaixo de R$ 100,00
    @Test
    public void deveCobrarFreteAbaixoDe100() {
        double resultado = calc.calcularValorFinal(80, false);
        assertEquals(95.0, resultado, 0.01);
    }

    @Test
    public void naoDeveCobrarFreteQuandoValorFinalFor100() {
        double resultado = calc.calcularValorFinal(100, false);
        assertEquals(100.0, resultado, 0.01);
    }

    @Test
    public void deveCobrarFreteQuandoDescontoVipReduzAbaixoDe100() {
        double resultado = calc.calcularValorFinal(105, true);
        assertEquals(114.75, resultado, 0.01);
    }

    // Ciclo 5: Excecao para valor zerado ou negativo
    @Test
    public void deveLancarExcecaoParaValorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularValorFinal(0, false);
        });
    }

    @Test
    public void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularValorFinal(-50, true);
        });
    }
}