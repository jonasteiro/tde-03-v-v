package calculadora;

public class CalculadoraDescontoTradicional {

    public double calcularValorFinal(double valor, boolean vip) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        double valorFinal = valor;

        if (valor > 1000) {
            valorFinal = valor - (valor * 0.20);
        } else if (valor > 500) {
            valorFinal = valor - (valor * 0.10);
        }

        if (vip) {
            valorFinal = valorFinal - (valorFinal * 0.05);
        }

        if (valorFinal < 100) {
            valorFinal = valorFinal + 15.0;
        }

        return valorFinal;
    }
}