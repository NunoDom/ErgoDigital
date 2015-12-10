package dei.estg.ipleiria.pt.ergodigital.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Pessoa {

    private String name;
    private Date dataNascimento;
    private String genero;

    private int altura;
    private int peso;

    private FuncaoEmpresa funcoesEmpresa; //lista


    private String morada;
    private List<Consulta> consultas;



}
