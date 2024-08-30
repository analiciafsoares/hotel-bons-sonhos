package abstract_factory;
import java.util.List;

import models.Quarto;

public abstract class Quartos extends Quarto{

    public Quartos(int numero, int andar, double precoDiaria, String tipo) {
        this.setNumero(numero);
        this.setAndar(andar);
        this.setPrecoDiaria(precoDiaria);
        this.setTipo(tipo);
    }

    public abstract String getDescricaoBasica();

    public abstract List<String> getMoveis();

}
