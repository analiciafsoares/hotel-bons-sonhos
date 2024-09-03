# Sistema de Reservas de Hotel

Este projeto é um sistema para gerenciar reservas de quartos de hotel, desenvolvido como parte da disciplina de **Padrões de Projeto** do Instituto Federal da Paraíba. O sistema permite que os usuários busquem por disponibilidade, reservem quartos, cancelem reservas e visualizem detalhes de suas reservas. Os administradores podem gerenciar quartos e clientes, atualizando perfis, removendo clientes, e visualizando detalhes das reservas.

## Funcionalidades

### Usuários
- **Buscar Disponibilidade**: Consulte a disponibilidade de quartos no período desejado.
- **Reservar Quartos**: Efetue reservas em quartos disponíveis.
- **Cancelar Reservas**: Cancele uma reserva existente.
- **Visualizar Detalhes**: Veja detalhes de uma reserva existente.

### Administradores
- **Adicionar/Remover Quartos**: Gerencie a lista de quartos disponíveis no hotel.
- **Atualizar Perfil de Cliente**: Atualize informações de clientes cadastrados.
- **Remover Cliente**: Exclua um cliente do sistema.
- **Ver Detalhes de um Cliente**: Acesse as informações detalhadas de um cliente.

## Arquitetura e Padrões de Projeto

Este sistema foi projetado utilizando vários padrões de projeto para garantir uma solução escalável, flexível e de fácil manutenção:

- **Singleton**: Gerencia a instância única do gerenciador de reservas, garantindo que todos os componentes do sistema utilizem a mesma instância.
- **Abstract Factory**: Facilita a criação de diferentes tipos de quartos (simples, luxo, suítes), permitindo a expansão futura do sistema para outros tipos de acomodação.
- **Builder**: Utilizado para construir objetos de reserva complexos que podem incluir várias opções, como data de entrada, saída, e serviços adicionais.
- **Chain of Responsibility**: Implementa a validação das reservas em diferentes etapas, como verificação de disponibilidade, pagamento e confirmação.
- **Observer**: Permite a notificação de usuários sobre atualizações de suas reservas, como confirmações e cancelamentos.
- **Strategy**: Implementa diferentes estratégias de cálculo de preço, como tarifas sazonais e descontos para membros, permitindo uma fácil alteração e adição de novas estratégias.

## Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada no desenvolvimento do sistema.
- **MySQL**: Banco de dados relacional para armazenamento das informações de reservas, quartos e usuários.
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- **JDBC**: API para conexão com o banco de dados MySQL.
- **ModelMapper**: Utilizada para automatizar o processo de mapeamento de objetos.

## Estrutura de Pastas

- `src/main/java`: Código-fonte principal do projeto.

## 👥 Contribuidores
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/estertrvs" title="GitHub">
        <img src="https://avatars.githubusercontent.com/u/141650957?v=4" width="100px;" alt="Foto de Ester"/><br>
        <sub>
          <b>Ester Trevisan</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/analiciafsoares" title="GitHub">
        <img src="https://avatars.githubusercontent.com/u/144076062?v=4" width="100px;" alt="Foto de Ana"/><br>
        <sub>
          <b>Ana Licia Soares</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Joaopaulomedeirosdesouza" title="GitHub">
        <img src="https://avatars.githubusercontent.com/u/148402008?v=4" width="100px;" alt="Foto de João Paulo"/><br>
        <sub>
          <b>João Paulo Medeiros</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/TATA255" title="GitHub">
        <img src="https://avatars.githubusercontent.com/u/119708989?v=4" width="100px;" alt="Foto de Otávio"/><br>
        <sub>
          <b>Otávio Estendio</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/mateuszzinn" title="GitHub">
        <img src="https://avatars.githubusercontent.com/u/103861262?v=4" width="100px;" alt="Foto de Mateus"/><br>
        <sub>
          <b>Mateus Lima</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

---

**Instituto Federal da Paraíba** - Curso de **Padrões de Projeto**.
