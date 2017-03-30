/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Viesbutis")
@NamedQueries({
    @NamedQuery(name = "Viesbutis.findAll", query = "SELECT v FROM Viesbutis v")
    , @NamedQuery(name = "Viesbutis.findByKodas", query = "SELECT v FROM Viesbutis v WHERE v.kodas = :kodas")
    , @NamedQuery(name = "Viesbutis.findByPavadinimas", query = "SELECT v FROM Viesbutis v WHERE v.pavadinimas = :pavadinimas")
    , @NamedQuery(name = "Viesbutis.findByAdresas", query = "SELECT v FROM Viesbutis v WHERE v.adresas = :adresas")})
@Getter
@Setter
@EqualsAndHashCode(of = "kodas")
@ToString(of = "kodas")
public class Viesbutis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Kodas")
    private String kodas;
    @Basic(optional = false)
    @Column(name = "Pavadinimas")
    private String pavadinimas;
    @Basic(optional = false)
    @Column(name = "Adresas")
    private String adresas;
    @OneToMany(mappedBy = "viesbutis")
    private List<Darbuotojas> darbuotojasList;
    @OneToMany(mappedBy = "viesbutis")
    private List<Suniukas> suniukasList;

}
