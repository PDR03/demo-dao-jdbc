package dao;

import java.util.List;

import model.Estados;

public interface EstadoDAO {
 
    List<Estados> ListEstados();

    void addEstados(Estados estados);

    Estados findById(int id);

    Estados DeleteById(int id);
}
