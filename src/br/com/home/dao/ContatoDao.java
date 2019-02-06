package br.com.home.dao;

import br.com.home.domain.Contato;
import br.com.home.infra.ConnectionDatabaseFactory;
import br.com.home.util.ApplicationUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

    private Connection connection;

    public ContatoDao() {
        this.connection = ConnectionDatabaseFactory.getPostgreSQLConnection();
    }

    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void adicione(Contato contato) {
        String sql = "INSERT INTO contatos(id, nome, endereco, email, dataNascimento) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contato.getId());
            preparedStatement.setString(2, contato.getNome());
            preparedStatement.setString(3, contato.getEndereco());
            preparedStatement.setString(4, contato.getEmail());
            preparedStatement.setDate(5, ApplicationUtil.toSqlDate(contato.getDataNascimento()));
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> obtenhaContatos() {
        String sql = "SELECT * FROM CONTATOS";
        List<Contato> contatos = new ArrayList<>();
        busqueContatos(sql, contatos);
        return contatos;
    }

    public List<Contato> getLista() {
        String sql = "SELECT * FROM CONTATOS";
        List<Contato> contatos = new ArrayList<>();
        busqueContatos(sql, contatos);
        return contatos;
    }

    private void busqueContatos(String sql, List<Contato> contatos) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contatos.add(new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        ApplicationUtil.toCalendar(resultSet.getDate("datanascimento"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remova(Integer contatoid){
        String sql = "DELETE FROM CONTATOS WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contatoid);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
