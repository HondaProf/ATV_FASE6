package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import br.com.fiap.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;

public class UsuarioDAO implements AutoCloseable {

    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tb_usuario (nm_completo, ds_email, senha_hash, ds_cpf, nr_telefone, "
                + "dt_nascimento, vl_rendamensal, ds_objetivo, dt_cadastro, st_usuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario.getNomeCompleto());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenhaHash());
            ps.setString(4, usuario.getCpf());
            ps.setString(5, usuario.getTelefone());

            if (usuario.getDataNascimento() != null) {
                ps.setDate(6, Date.valueOf(usuario.getDataNascimento()));
            } else {
                ps.setNull(6, Types.DATE);
            }

            if (usuario.getRendaMensal() != null) {
                ps.setDouble(7, usuario.getRendaMensal());
            } else {
                ps.setNull(7, Types.NUMERIC);
            }

            ps.setString(8, usuario.getObjetivo());
            ps.setDate(9, Date.valueOf(usuario.getDataCadastro()));
            ps.setString(10, usuario.getStatus());

            ps.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
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
                Date cadastro = rs.getDate("dt_cadastro");

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
                        cadastro == null ? null : cadastro.toLocalDate(),
                        rs.getString("st_usuario")));
            }
        }
        return lista;
    }

}