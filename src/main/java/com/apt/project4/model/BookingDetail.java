/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy Hoang
 */
@Entity
@Table(name = "booking_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b")
    , @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id")
    , @NamedQuery(name = "BookingDetail.findBySfDurationId", query = "SELECT b FROM BookingDetail b WHERE b.sfDurationId = :sfDurationId")
    , @NamedQuery(name = "BookingDetail.findByBookingDate", query = "SELECT b FROM BookingDetail b WHERE b.bookingDate = :bookingDate")
    , @NamedQuery(name = "BookingDetail.findByBookingId", query = "SELECT b FROM BookingDetail b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "BookingDetail.findBySpId", query = "SELECT b FROM BookingDetail b WHERE b.spId = :spId")
    , @NamedQuery(name = "BookingDetail.findByStatus", query = "SELECT b FROM BookingDetail b WHERE b.status = :status")})
public class BookingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sf_duration_id")
    private int sfDurationId;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Basic(optional = false)
    @Column(name = "booking_id")
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "sp_id")
    private int spId;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    public BookingDetail() {
    }

    public BookingDetail(Integer id) {
        this.id = id;
    }

    public BookingDetail(Integer id, int sfDurationId, Date bookingDate, int bookingId, int spId, int status) {
        this.id = id;
        this.sfDurationId = sfDurationId;
        this.bookingDate = bookingDate;
        this.bookingId = bookingId;
        this.spId = spId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSfDurationId() {
        return sfDurationId;
    }

    public void setSfDurationId(int sfDurationId) {
        this.sfDurationId = sfDurationId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
        if (!(object instanceof BookingDetail)) {
            return false;
        }
        BookingDetail other = (BookingDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BookingDetail[ id=" + id + " ]";
    }
    
}
