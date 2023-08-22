/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author leola
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByNome", query = "SELECT u FROM User u WHERE u.nome = :nome"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByTelefone", query = "SELECT u FROM User u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "User.findByCep", query = "SELECT u FROM User u WHERE u.cep = :cep"),
    @NamedQuery(name = "User.findByFileUrl", query = "SELECT u FROM User u WHERE u.fileUrl = :fileUrl")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "file_url")
    private String fileUrl;
    @JoinColumn(name = "cep_user", referencedColumnName = "cep")
    @ManyToOne(optional = false)
    private Address cepUser;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

//    public User(String nome, String email, String telefone, String endereço, String fileUrl) {
//        this.nome = nome;
//        this.email = email;
//        this.telefone = telefone;
//        this.endereço = endereço;
//        this.fileUrl = fileUrl;
//    }

    public User(String nome, String email, String telefone, String cep, String fileUrl, Address a) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.fileUrl = fileUrl;
        this.cepUser = a; //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Address getCepUser() {
        return cepUser;
    }

    public void setCepUser(Address cepUser) {
        this.cepUser = cepUser;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (email != null ? email.hashCode() : 0);
//        return hash;
//    }

////    @Override
////    public boolean equals(Object object) {
////        // TODO: Warning - this method won't work in the case the id fields are not set
////        if (!(object instanceof User)) {
////            return false;
////        }
////        User other = (User) object;
////        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
////            return false;
////        }
////        return true;
////    }
////
////    @Override
////    public String toString() {
////        return "br.edu.infnet.cep.models.User[ email=" + email + " ]";
////    }
    


    @Override
    public String toString() {
        return "User{" + "nome=" + nome + ", email=" + email + ", telefone=" + telefone + '}';
    }

    
    
}