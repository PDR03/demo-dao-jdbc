package dao.implDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EstadoDAO;
import model.Estados;

public class Estadoimpl implements EstadoDAO {

    private Connection connection;

    public Estadoimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Estados> ListEstados() {
        List<Estados> estados = new ArrayList<>();
        String sqlQuery = "SELECT * FROM estados";

        try (PreparedStatement stm = connection.prepareStatement(sqlQuery)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Estados estado = new Estados();
                estado.setId(rs.getInt("id"));
                estado.setNome_estado(rs.getString("nome_estado")); 
                estados.add(estado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estados;
    }

    @Override
    public void addEstados(Estados estado) {
        String sql = "INSERT INTO estados (nome_estado) VALUES (?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, estado.getNome_estado());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estados findById(int id) {
        Estados estado = null;
        String sql = "SELECT * FROM estados WHERE id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                estado = new Estados();
                estado.setId(rs.getInt("id"));
                estado.setNome_estado(rs.getString("nome_estado"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

    @Override
    public Estados DeleteById(int id) {
        Estados estado = findById(id); // Busca antes de excluir
        String sql = "DELETE FROM estados WHERE id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }
}
