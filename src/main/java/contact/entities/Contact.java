package contact.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "CONTACTS" )
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Long   id;
    private String nom;
    private String prenom;
    @Column( name = "DATE_NAISS" )
    @Temporal( TemporalType.DATE )
    private Date   dateNaissance;
    private String telephone;
    private String pathImage;

    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Contact( String nom, String prenom, Date dateNaissance, String telephone, String pathImage ) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.pathImage = pathImage;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance( Date dateNaissance ) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage( String pathImage ) {
        this.pathImage = pathImage;
    }

}
