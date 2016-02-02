package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;

/**
 * Created by Nuno on 02/02/2016.
 */
public class Resultado implements Serializable{


    private String titulo;
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Resultado(String titulo, String valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return  "\n"+titulo + " " + valor;
    }
}
