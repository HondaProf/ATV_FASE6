package br.com.fiap.VIEW;


import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.Model.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroUsuarioView {

    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();

            dao.cadastrar(new Usuario("Marina Alves Pereira", "marina.alves@email.com", "hash_fake_001",
                    "12345678909", "11987654321", LocalDate.of(1999, 4, 18), 4800.00,
                    "Montar reserva de emergência", LocalDate.now(), "A"));

            dao.cadastrar(new Usuario("Bruno Lima Santos", "bruno.lima@email.com", "hash_fake_002",
                    "23456789010", "11976543210", LocalDate.of(1998, 3, 22), 5200.00,
                    "Comprar um carro", LocalDate.now(), "A"));

            dao.cadastrar(new Usuario("Carla Dias Ferreira", "carla.dias@email.com", "hash_fake_003",
                    "34567890121", "11965432109", LocalDate.of(1995, 11, 2), 7000.00,
                    "Investir mais", LocalDate.now(), "A"));

            dao.cadastrar(new Usuario("Diego Rocha Martins", "diego.rocha@email.com", "hash_fake_004",
                    "45678901232", "11954321098", LocalDate.of(2001, 8, 15), 3000.00,
                    "Sair das dívidas", LocalDate.now(), "A"));

            dao.cadastrar(new Usuario("Elisa Prado Costa", "elisa.prado@email.com", "hash_fake_005",
                    "56789012343", "11943210987", LocalDate.of(1992, 1, 30), 8500.00,
                    "Viajar pelo mundo", LocalDate.now(), "A"));



            dao.fecharConexao();
            System.out.println("Usuário cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}