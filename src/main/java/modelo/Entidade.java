package modelo;

public class Entidade {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entidade [id=" + id + "]";
    }
    
}
