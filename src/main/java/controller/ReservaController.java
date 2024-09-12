package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import dao.QuartoDAO;
import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import models.reserva.ReservaBuilder;
import models.strategy.*;
import utils.mapper.Mapper;

public class ReservaController {

    public static double reservarQuarto(QuartoDTO quarto, String cpf, Date checkin, Date checkout) {
        ClienteDTO cliente = Mapper.parseObject(UsuarioController.resgatarCliente(cpf), ClienteDTO.class);

       
        int quantReservas = consultarReservasAnteriores(cpf);

        
        IEstrategiaDePrecos estrategiaPreco;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkin);

        int mesCheckin = calendar.get(Calendar.MONTH) + 1;  

       
        if (quantReservas > 10) {
            estrategiaPreco = new EstrategiaPrecoClienteFiel();
        } 
        //Se for julho ou dezembro, promoção
        else if (mesCheckin == 7 || mesCheckin == 12) {
            estrategiaPreco = new EstrategiaPrecoSazonal();
        } 
        // Aqui eu confesso que fiquei sem ideias, então botei Março para ser promoção, já que a demanda é menor
        else if (mesCheckin == 3) {
            estrategiaPreco = new EstrategiaPrecoPromo();
        }
        
        else {
            estrategiaPreco = null;
        }

       
        int numeroDeNoites = checkout.getDate() - checkin.getDate();
        double precoTotal;

        // Se nenhuma estratégia pegar, use o preço normal mermo
        if (estrategiaPreco != null) {
            precoTotal = estrategiaPreco.calcularPreco(quarto.getPrecoDiaria(), numeroDeNoites, quantReservas);
        } else {
            precoTotal = quarto.getPrecoDiaria() * numeroDeNoites;
        }

        
        ReservaBuilder builder = new ReservaBuilder()
            .setId(new Random().nextInt(10000))
            .setCliente(cliente)
            .setQuarto(quarto)
            .setDataCheckin(checkin)
            .setDataCheckout(checkout)
            .setPrecoTotal(precoTotal);

        new ReservaDAO().cadastrarReserva(Mapper.parseObject(builder.builder(), ReservaDTO.class));

        
        return precoTotal;
    }

    public static int consultarReservasAnteriores(String cpf) {
        ArrayList<ReservaDTO> reservas = new ReservaDAO().listarReservas();
        int quantidade = 0;
        
        for (ReservaDTO reserva : reservas) {
            if (reserva.getCliente().getCPF().equals(cpf)) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public static boolean consultarDisponibilidade(QuartoDTO quarto, Date dataCheckin, Date dataCheckout) {
        ReservaDAO reservaDAO = new ReservaDAO();

        int idQuarto = new QuartoDAO().buscarIdQuarto(quarto.getNumero(), quarto.getTipo(), quarto.getAndar());
        List<ReservaDTO> reservas = reservaDAO.listarReservasPorQuarto(idQuarto);

        for (ReservaDTO reserva : reservas) {
            Date checkinExistente = new Date(reserva.getDataCheckin().getTime());
            Date checkoutExistente = new Date(reserva.getDataCheckout().getTime());

            if ((dataCheckin.before(checkoutExistente) && dataCheckout.after(checkinExistente)) ||
                (dataCheckin.equals(checkinExistente) || dataCheckout.equals(checkoutExistente))) {
                return false; 
            }
        }

        return true; 
    }
}
