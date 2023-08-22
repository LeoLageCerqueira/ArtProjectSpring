/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leola
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "artworks")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artworks.findAll", query = "SELECT a FROM Artworks a"),
    @NamedQuery(name = "Artworks.findById", query = "SELECT a FROM Artworks a WHERE a.id = :id"),
    @NamedQuery(name = "Artworks.findByName", query = "SELECT a FROM Artworks a WHERE a.name = :name"),
    @NamedQuery(name = "Artworks.findByPrice", query = "SELECT a FROM Artworks a WHERE a.price = :price"),
    @NamedQuery(name = "Artworks.findByPhoto", query = "SELECT a FROM Artworks a WHERE a.photo = :photo")})
public class Artworks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photo")
    private String photo;
    @JoinColumn(name = "artist", referencedColumnName = "nome")
    @ManyToOne(optional = false)
    private User artist;

    public Artworks() {
    }
    
    
    public Artworks(Integer id) {
        this.id = id;
    }

    public Artworks(String name, float price, String photo, User u) {
        
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.artist = u;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getArtist() {
        return artist;
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }
    

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Artworks)) {
//            return false;
//        }
//        Artworks other = (Artworks) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "br.edu.infnet.ArtProjectArtworkService.Model.Artworks[ id=" + id + " ]";
//    }
    
}
