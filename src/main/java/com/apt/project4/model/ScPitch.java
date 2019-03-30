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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toanngo92
 */
@Entity
@Table(name = "sc_pitch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScPitch.findAll", query = "SELECT s FROM ScPitch s"),
    @NamedQuery(name = "ScPitch.findById", query = "SELECT s FROM ScPitch s WHERE s.id = :id"),
    @NamedQuery(name = "ScPitch.findByAddress", query = "SELECT s FROM ScPitch s WHERE s.address = :address"),
    @NamedQuery(name = "ScPitch.findByDescription", query = "SELECT s FROM ScPitch s WHERE s.description = :description"),
    @NamedQuery(name = "ScPitch.findByName", query = "SELECT s FROM ScPitch s WHERE s.name = :name"),
    @NamedQuery(name = "ScPitch.findByPrice", query = "SELECT s FROM ScPitch s WHERE s.price = :price"),
    @NamedQuery(name = "ScPitch.findByStatus", query = "SELECT s FROM ScPitch s WHERE s.status = :status")})
public class ScPitch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;

    public ScPitch() {
    }

    public ScPitch(Integer id) {
        this.id = id;
    }

    public ScPitch(Integer id, String address, String description, String name, float price, short status) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        if (!(object instanceof ScPitch)) {
            return false;
        }
        ScPitch other = (ScPitch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apt.project4.model.ScPitch[ id=" + id + " ]";
    }
    
}
