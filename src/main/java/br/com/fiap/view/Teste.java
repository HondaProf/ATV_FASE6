package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        // A conexão é fechada automaticamente ao sair do bloco, com ou sem erro
        try (UsuarioDAO dao = new UsuarioDAO()) {

            // ---------- TESTE DE CADASTRO (5 registros) ----------
            dao.insert(new Usuario("Marina Alves Pereira", "marina.alves@email.com", "hash_fake_001",
                    "12345678909", "11987654321", LocalDate.of(1999, 4, 18), 4800.00,
                    "Montar reserva de emergência", LocalDate.now(), "A"));

            dao.insert(new Usuario("Bruno Lima Santos", "bruno.lima@email.com", "hash_fake_002",
                    "23456789010", "11976543210", LocalDate.of(1998, 3, 22), 5200.00,
                    "Comprar um carro", LocalDate.now(), "A"));

            dao.insert(new Usuario("Carla Dias Ferreira", "carla.dias@email.com", "hash_fake_003",
                    "34567890121", "11965432109", LocalDate.of(1995, 11, 2), 7000.00,
                    "Investir mais", LocalDate.now(), "A"));

            dao.insert(new Usuario("Diego Rocha Martins", "diego.rocha@email.com", "hash_fake_004",
                    "45678901232", "11954321098", LocalDate.of(2001, 8, 15), 3000.00,
                    "Sair das dívidas", LocalDate.now(), "A"));

            dao.insert(new Usuario("Elisa Prado Costa", "elisa.prado@email.com", "hash_fake_005",
                    "56789012343", "11943210987", LocalDate.of(1992, 1, 30), 8500.00,
                    "Viajar pelo mundo", LocalDate.now(), "A"));

            System.out.println("5 usuários cadastrados com sucesso!\n");

            // ---------- TESTE DE CONSULTA (getAll) ----------
            List<Usuario> usuarios = dao.getAll();

            System.out.println("=== USUÁRIOS NO BANCO (" + usuarios.size() + ") ===");
            for (Usuario u : usuarios) {
                System.out.println("Código: " + u.getCodUsuario());
                System.out.println("Nome: " + u.getNomeCompleto());
                System.out.println("E-mail: " + u.getEmail());
                System.out.println("CPF: " + u.getCpf());
                System.out.println("Telefone: " + u.getTelefone());
                System.out.println("Nascimento: " + u.getDataNascimento());
                System.out.println("Renda mensal: R$ " + u.getRendaMensal());
                System.out.println("Objetivo: " + u.getObjetivo());
                System.out.println("Cadastro: " + u.getDataCadastro());
                System.out.println("Status: " + u.getStatus());
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            tratarErro(e);
        }
    }

    // Traduz os erros do nosso banco para mensagens mais claras
    private static void tratarErro(SQLException e) {
        switch (e.getErrorCode()) {
            case 17002:
                System.err.println("Banco indisponível ou sem conexão. Verifique rede/VPN e o endereço do servidor.");
                break;
            case 1017:
                System.err.println("Usuário ou senha do banco inválidos.");
                break;
            case 942:
                System.err.println("Tabela não encontrada. Verifique se tb_usuario existe no schema.");
                break;
            case 1:
                System.err.println("Registro duplicado (e-mail ou CPF já cadastrado).");
                break;
            default:
                System.err.println("Erro ao acessar o banco: " + e.getMessage());
        }
        System.err.println("Detalhe técnico (código " + e.getErrorCode() + "): " + e.getMessage());
    }
}