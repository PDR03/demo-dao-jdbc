

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.EstadoDAO;
import Model.Estado;

public class EstadoDAOImpl implements EstadoDAO {

        private Connection con;

    public EstadoDAOImpl(Connection connection) {
        this.con = connection;
    }

    @Override
    public List<Estado> findAll() {
        List<Estado> estados = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Estados";

        try (PreparedStatement stm = con.prepareStatement(sqlQuery)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
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
    public void addEstados(Estado estado) {
        String sqlQuery = "INSERT INTO Estados (nome_estado) VALUES ?";

        try(PreparedStatement stm = con.prepareStatement(sqlQuery)){
                stm.setString(1, estado.getNome_estado());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estado findById(int id) {
    Estado estado = null;
    String sqlQuery = "SELECT Estados WHERE Id = ?";

     try (PreparedStatement stm = con.prepareStatement(sqlQuery)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome_estado(rs.getString("nome_estado"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

    @Override
    public Estado UpdateById(int id) {
        Estado estado = findById(id);
        String sqlQuery = "UPDATE Estados SET nome_estado = ? WHERE Estados_Id = ?";

         try (PreparedStatement stm = con.prepareStatement(sqlQuery)) {
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

    @Override
    public Estado DeleteById(int id) {
    Estado estado = findById(id);
    String sqlQuery = "DELETE FROM Estados WHERE Estados_Id = ?";
            try (PreparedStatement stm = con.prepareStatement(sqlQuery)) {
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }
    

}