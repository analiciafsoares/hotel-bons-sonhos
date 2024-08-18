package models;

public class Quarto {
    private int codigoQuarto;
    private int numero;
    private int andar;
    private double precoDiaria;
    private String tipo;

    public int getCodigoQuarto() {
        return codigoQuarto;
    }

    public void setCodigoQuarto(int id) {
        this.codigoQuarto = id;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
