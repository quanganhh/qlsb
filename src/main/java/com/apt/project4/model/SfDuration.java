/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy Hoang
 */
@Entity
@Table(name = "sf_duration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfDuration.findAll", query = "SELECT s FROM SfDuration s")
    , @NamedQuery(name = "SfDuration.findById", query = "SELECT s FROM SfDuration s WHERE s.id = :id")
    , @NamedQuery(name = "SfDuration.findByName", query = "SELECT s FROM SfDuration s WHERE s.name = :name")
    , @NamedQuery(name = "SfDuration.findByPrice", query = "SELECT s FROM SfDuration s WHERE s.price = :price")})
public class SfDuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Lob
    @Column(name = "description")
    private String description;

    public SfDuration() {
    }

    public SfDuration(Integer id) {
        this.id = id;
    }

    public SfDuration(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfDuration)) {
            return false;
        }
        SfDuration other = (SfDuration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SfDuration[ id=" + id + " ]";
    }
    
}
