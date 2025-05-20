package Model;

public class Estado {
    private int id;
    private String nome_estado;

    public Estado() {
        
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome_estado() {
        return nome_estado;
    }


    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    @Override
    public String toString() {
        return "Estado [id=" + id + ", nome_estado=" + nome_estado + "]";
    }
}
