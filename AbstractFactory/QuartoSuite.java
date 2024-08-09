package AbstractFactory;
import java.util.List;
import java.util.ArrayList;








public class QuartoSuite implements Quartos {
    public double precoBase(){
        return 370.00;
    }

    public String tipoDeQuarto(){
        return "Quarto Suíte";
    }
    public List<String> quantidadeDeMoveis(){
        List<String> moveis = new ArrayList();
        moveis.add("Cama King");
        moveis.add("3 sofás");
        moveis.add("2 banheiros");

        return moveis;


    }

}
