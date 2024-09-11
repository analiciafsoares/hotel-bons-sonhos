package models.strategy;

public class EstrategiaPrecoClienteFiel {
    public double calcularPreco(double precoBase, int numeroDeNoites, int quantReservas) {
        double descontoFiel = quantReservas / 10; 
        return precoBase * descontoFiel * numeroDeNoites;
    }

}
