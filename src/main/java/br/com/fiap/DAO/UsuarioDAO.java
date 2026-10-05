package br.com.fiap.DAO;

import br.com.fiap.Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        conexao = br.com.fiap.ConnectionFactory.ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usuario) throws SQLException {
        Statement stm = conexao.createStatement();
        stm.executeUpdate("INSERT INTO tb_usuario (nm_completo, ds_email, senha_hash, ds_cpf, nr_telefone, "
                + "dt_nascimento, vl_rendamensal, ds_objetivo, dt_cadastro, st_usuario) VALUES ('"
                + usuario.getNomeCompleto() + "', '"
                + usuario.getEmail() + "', '"
                + usuario.getSenhaHash() + "', '"
                + usuario.getCpf() + "', '"
                + usuario.getTelefone() + "', "
                + "TO_DATE('" + usuario.getDataNascimento() + "', 'YYYY-MM-DD'), "
                + usuario.getRendaMensal() + ", '"
                + usuario.getObjetivo() + "', "
                + "TO_DATE('" + usuario.getDataCadastro() + "', 'YYYY-MM-DD'), '"
                + usuario.getStatus() + "')");
        stm.close();

    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public Usuario pesquisar(long codigo){
        return null;
    }

    public List<Usuario> getAll() throws SQLException {
        List<Usuario> lista = new ArrayList<>();

        try (Statement stm = conexao.createStatement();
             ResultSet rs = stm.executeQuery(
                     "SELECT cod_usuario, nm_completo, ds_email, senha_hash, ds_cpf, nr_telefone, "
                             + "dt_nascimento, vl_rendamensal, ds_objetivo, dt_cadastro, st_usuario "
                             + "FROM tb_usuario ORDER BY cod_usuario")) {

            while (rs.next()) {
                Date nascimento = rs.getDate("dt_nascimento");
                double renda = rs.getDouble("vl_rendamensal");
                Double rendaMensal = rs.wasNull() ? null : renda;

                lista.add(new Usuario(
                        rs.getLong("cod_usuario"),
                        rs.getString("nm_completo"),
                        rs.getString("ds_email"),
                        rs.getString("senha_hash"),
                        rs.getString("ds_cpf"),
                        rs.getString("nr_telefone"),
                        nascimento == null ? null : nascimento.toLocalDate(),
                        rendaMensal,
                        rs.getString("ds_objetivo"),
                        rs.getDate("dt_cadastro").toLocalDate(),
                        rs.getString("st_usuario")));
            }
        }
        return lista;
    }

    public void atualizar(Usuario usuario){

    }

    public void remover(long codigo){

    }

}