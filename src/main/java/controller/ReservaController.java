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
        // Março é aniversário do hotel então tem promoção
        else if (mesCheckin == 3) {
            estrategiaPreco = new EstrategiaPrecoPromo();
        }
        
        else {
            estrategiaPreco = null;
        }

        calendar.setTime(checkin);
        int diaCheckin = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(checkout);
        int diaCheckout = calendar.get(Calendar.DAY_OF_MONTH);
        
        int numeroDeNoites = diaCheckout - diaCheckin;

        double precoTotal;

        // Se nenhuma estratégia for usada será o preço integral da diária
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
