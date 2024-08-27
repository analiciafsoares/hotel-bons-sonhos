package Strategy;

public class EstrategiaPrecoCompeticaoDeHotel {
    public double calcularPreco(double precoBase, int numeroDeNoites) {
        double descontoCompetitivo = 0.9; 
        return precoBase * descontoCompetitivo * numeroDeNoites;
    }

}
