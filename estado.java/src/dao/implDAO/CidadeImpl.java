package dao.implDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CIdadeDAO;
import model.Cidades;

public class CidadeImpl implements CIdadeDAO {

    private Connection connection;

    public CidadeImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Cidades> ListCidades() {
        List<Cidades> cidades = new ArrayList<>();
        String sql = "SELECT * FROM cidades";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cidades cidade = new Cidades();
                cidade.setId(rs.getInt("id"));
                cidade.setNome_cidade(rs.getString("nome_cidade"));
                cidades.add(cidade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    @Override
    public void addCidades(Cidades cidade) {
        String sql = "INSERT INTO cidades (nome_cidade) VALUES (?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, cidade.getNome_cidade());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cidades findById(int id) {
        Cidades cidade = null;
        String sql = "SELECT * FROM cidades WHERE id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                cidade = new Cidades();
                cidade.setId(rs.getInt("id"));
                cidade.setNome_cidade(rs.getString("nome_cidade"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }

    @Override
    public Cidades DeleteById(int id) {
        Cidades cidade = findById(id); 
        String sql = "DELETE FROM cidades WHERE id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }
    
    @Override
    public void deleteByEstadoId(int estadoId) {
        String sql = "DELETE FROM cidades WHERE estado_id = ?";
    
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, estadoId);
            int affectedRows = stm.executeUpdate();
            System.out.println(affectedRows + " cidades deletadas do estado com ID " + estadoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
