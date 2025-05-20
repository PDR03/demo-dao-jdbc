package DAO;

import java.util.List;

import Model.Estado;

public interface EstadoDAO {

    List<Estado> findAll();

    void addEstados(Estado estado);
    
    Estado findById(int id);

    Estado UpdateById(int id);

    Estado DeleteById(int id);

}
