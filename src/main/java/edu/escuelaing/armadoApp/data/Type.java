package edu.escuelaing.armadoApp.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Categorias")
public class Type {

    @Id
    private String id;

    private String TipoCategoria;

    private String Descripcion;


    public Type() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoCategoria() {
        return TipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        TipoCategoria = tipoCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
