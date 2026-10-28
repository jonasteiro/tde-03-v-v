package calculadora;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valor, boolean vip) {
        validarValor(valor);

        double valorFinal = aplicarDescontoPorFaixa(valor);

        if (vip) {
            valorFinal = aplicarDescontoVip(valorFinal);
        }

        valorFinal = aplicarFrete(valorFinal);

        return valorFinal;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
    }

    private double aplicarDescontoPorFaixa(double valor) {
        if (valor > 1000) {
            return valor - (valor * 0.20);
        } else if (valor > 500) {
            return valor - (valor * 0.10);
        }
        return valor;
    }

    private double aplicarDescontoVip(double valor) {
        return valor - (valor * 0.05);
    }

    private double aplicarFrete(double valor) {
        if (valor < 100) {
            return valor + 15.0;
        }
        return valor;
    }
}