package controller;

import models.quarto.QuartoFactory;
import models.quarto.Quartos;
import dao.QuartoDAO;
import dto.QuartoDTO;

public class QuartoController {

    public static void criarQuarto(int numero, String tipo, int andar, double precoDiaria) {
        
        QuartoFactory factory = new QuartoFactory();

        
        Quartos quarto;
        switch (tipo.toLowerCase()) {
            case "luxo":
                quarto = factory.criarQuartoDeLuxo(numero, andar, precoDiaria);
                break;
            case "simples":
                quarto = factory.criarQuartoSimples(numero, andar, precoDiaria);
                break;
            case "suite":
                quarto = factory.criarQuartoSuite(numero, andar, precoDiaria);
                break;
            default:
                throw new IllegalArgumentException("Tipo de quarto inválido");
        }

        // Criando um DTO  com o quarto
        QuartoDTO quartoDTO = new QuartoDTO();
        quartoDTO.setCodigoQuarto(quarto.getCodigoQuarto());
        quartoDTO.setNumero(quarto.getNumero());
        quartoDTO.setAndar(quarto.getAndar());
        quartoDTO.setPrecoDiaria(quarto.getPrecoDiaria());
        quartoDTO.setTipo(quarto.getTipo());
        quartoDTO.setCapacidadeMaxima(quarto.getCapacidadeMaxima());

        // Salvando o quarto no Banco de Dados
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.cadastrarQuarto(quartoDTO);
    }
}
