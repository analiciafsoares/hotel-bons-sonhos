package AbstractFactory;
import java.util.List;
import java.util.ArrayList;




public class QuartoDeLuxo implements Quartos {

    public double precoBase(){
        return 700.00;
    }
    public String tipoDeQuarto(){
        return "Quarto de Luxo";

    }
    public List<String> quantidadeDeMoveis(){
        List<String> moveis = new ArrayList();
        moveis.add("Cama Queen");
        moveis.add("7 sofás");
        moveis.add("3 banheiros");

        return moveis;



    }

}
