package AbstractFactory;
import java.util.List;
import java.util.ArrayList;





public class QuartoSimples implements Quartos {
    public double precoBase(){
        return 200.0;
    }
    public String tipoDeQuarto(){
        return "Quarto Simples";
    }
    public List<String> quantidadeDeMoveis(){
        List<String> moveis = new ArrayList();
        moveis.add("Cama normal");
        moveis.add("2 sofás");
        moveis.add("1 banheiro");

        return moveis;



    }

}
