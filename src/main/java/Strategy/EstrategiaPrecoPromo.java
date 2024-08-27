package Strategy;

public class EstrategiaPrecoPromo {
    public double calcularPreco(double precoBase, int numeroDeNoites) {
        double descontoPromocional = 0.8; 
        return precoBase * descontoPromocional * numeroDeNoites;
    }

}
