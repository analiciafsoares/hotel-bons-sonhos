package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.QuartoDAO;
import dao.ReservaDAO;
import dto.QuartoDTO;
import dto.ReservaDTO;

public class ReservaController {
    public static int consultarReservasAnteriores(String cpf) {
        ArrayList<ReservaDTO> reservas = new ReservaDAO().listarReservas();
        int quantidade = 0;
        
        for (ReservaDTO reserva: reservas) {
            if(reserva.getCliente().getCPF().equals(cpf)){
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
