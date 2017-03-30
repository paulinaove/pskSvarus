package mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Darbuotojas {

    private String id;

    private String vardas;


    private String pavarde;


    private String pareigos;


    private String viesbutis;

    private Viesbutis viesbutis1;

    private List<Suniukas> suniukai;




}