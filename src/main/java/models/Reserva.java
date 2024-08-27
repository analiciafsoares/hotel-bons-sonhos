package models;

import java.sql.Date;

public class Reserva {

    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private Date dataCheckin;
    private Date dataCheckout;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", quarto=" + quarto +
                ", dataCheckin=" + dataCheckin +
                ", dataCheckout=" + dataCheckout +
                '}';
    }
    public String validarDisponibilidade(Date dataInicio, Date dataFim) {
        if (this.dataCheckout.before(dataInicio) || this.dataCheckin.after(dataFim)) {
            return "Quarto disponível";
        } else {
            return "Quarto indisponível para o período selecionado";
        }
    }
}
