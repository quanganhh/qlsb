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
@Table(name = "extra_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExtraBooking.findAll", query = "SELECT e FROM ExtraBooking e"),
    @NamedQuery(name = "ExtraBooking.findById", query = "SELECT e FROM ExtraBooking e WHERE e.id = :id"),
    @NamedQuery(name = "ExtraBooking.findByDetailBookingId", query = "SELECT e FROM ExtraBooking e WHERE e.detailBookingId = :detailBookingId")})
public class ExtraBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "detail_booking_id")
    private int detailBookingId;

    public ExtraBooking() {
    }

    public ExtraBooking(Integer id) {
        this.id = id;
    }

    public ExtraBooking(Integer id, int detailBookingId) {
        this.id = id;
        this.detailBookingId = detailBookingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDetailBookingId() {
        return detailBookingId;
    }

    public void setDetailBookingId(int detailBookingId) {
        this.detailBookingId = detailBookingId;
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
        if (!(object instanceof ExtraBooking)) {
            return false;
        }
        ExtraBooking other = (ExtraBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apt.project4.model.ExtraBooking[ id=" + id + " ]";
    }
    
}
