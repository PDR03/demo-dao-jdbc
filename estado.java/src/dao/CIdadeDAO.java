package dao;

import java.util.List;

import model.Cidades;

public interface CIdadeDAO {

    List<Cidades> ListCidades();

    void addCidades(Cidades cidade);

    Cidades findById(int id);

    Cidades DeleteById(int id);

    public void deleteByEstadoId(int estadoId);
}
