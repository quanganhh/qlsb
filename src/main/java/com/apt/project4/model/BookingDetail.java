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
 * @author toanngo92
 */
@Entity
@Table(name = "booking_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b"),
    @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BookingDetail.findByDuration", query = "SELECT b FROM BookingDetail b WHERE b.duration = :duration"),
    @NamedQuery(name = "BookingDetail.findByExpiredTime", query = "SELECT b FROM BookingDetail b WHERE b.expiredTime = :expiredTime"),
    @NamedQuery(name = "BookingDetail.findByBookingId", query = "SELECT b FROM BookingDetail b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingDetail.findBySpId", query = "SELECT b FROM BookingDetail b WHERE b.spId = :spId")})
public class BookingDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "expired_time")
    @Temporal(TemporalType.DATE)
    private Date expiredTime;
    @Basic(optional = false)
    @Column(name = "booking_id")
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "sp_id")
    private int spId;

    public BookingDetail() {
    }

    public BookingDetail(Integer id) {
        this.id = id;
    }

    public BookingDetail(Integer id, int duration, Date expiredTime, int bookingId, int spId) {
        this.id = id;
        this.duration = duration;
        this.expiredTime = expiredTime;
        this.bookingId = bookingId;
        this.spId = spId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
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
        return "com.apt.project4.model.BookingDetail[ id=" + id + " ]";
    }
    
}
