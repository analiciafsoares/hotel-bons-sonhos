package models.reserva;

import models.Cliente;
import models.quarto.Quarto;

import java.sql.Date;

public class ReservaBuilder {

    private Reserva instancia;

    public ReservaBuilder(){
        this.instancia = new Reserva();
    }

    public ReservaBuilder setId(int id){
        instancia.setId(id);
        return this;
    }

    public ReservaBuilder setCliente(String nome, String email, String telefone, String CPF){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCPF(CPF);

        instancia.setCliente(cliente);
        return this;
    }

    public ReservaBuilder setQuarto(int codigoQuarto, int numero, int andar, double precoDiaria, String tipo){
        Quarto quarto = new Quarto();
        quarto.setCodigoQuarto(codigoQuarto);
        quarto.setNumero(numero);
        quarto.setAndar(andar);
        quarto.setPrecoDiaria(precoDiaria);
        quarto.setTipo(tipo);

        instancia.setQuarto(quarto);
        return this;
    }

    public ReservaBuilder setDataCheckin(int dia, int mes, int ano){
        Date data = new Date(ano-1900, mes-1, dia);
        instancia.setDataCheckin(data);
        return this;
    }

    public ReservaBuilder setDataCheckout(int dia, int mes, int ano) {
        Date data = new Date(ano-1900, mes-1, dia);
        instancia.setDataCheckout(data);
        return this;
    }

    public Reserva builder(){
        return instancia;
    }
}
