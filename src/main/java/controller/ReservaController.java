package controller;

import java.util.ArrayList;

import dao.ReservaDAO;
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
}
