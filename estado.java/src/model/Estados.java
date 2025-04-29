package model;

//Entity
public class Estados {
    private int id;
    private String nome_estado;

    public Estados() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public String getNome_estado() {
        return nome_estado;
    }
    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Estados| id=" + id + ", nome_estado=" + nome_estado;
    }

    
}
