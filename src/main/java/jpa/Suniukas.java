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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Suniukas")
@NamedQueries({
    @NamedQuery(name = "Suniukas.findAll", query = "SELECT s FROM Suniukas s")
    , @NamedQuery(name = "Suniukas.findByGyvunoID", query = "SELECT s FROM Suniukas s WHERE s.gyvunoID = :gyvunoID")
    , @NamedQuery(name = "Suniukas.findByVardas", query = "SELECT s FROM Suniukas s WHERE s.vardas = :vardas")
    , @NamedQuery(name = "Suniukas.findByVeisle", query = "SELECT s FROM Suniukas s WHERE s.veisle = :veisle")})
@Getter
@Setter
@EqualsAndHashCode(of = "gyvunoID")
@ToString(of = "gyvunoID")
public class Suniukas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GyvunoID")
    private String gyvunoID;
    @Column(name = "Vardas")
    private String vardas;
    @Column(name = "Veisle")
    private String veisle;
    @ManyToMany(mappedBy = "suniukasList")
    private List<Darbuotojas> darbuotojasList = new ArrayList<Darbuotojas>();
    @JoinColumn(name = "Viesbutis", referencedColumnName = "Kodas")
    @ManyToOne
    private Viesbutis viesbutis;

}
