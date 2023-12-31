package cl.awakelab.apirest.models.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="nombre", nullable=false, length=50)
  private String nombre;
  @Column(name="apellido", nullable=false, length=50)
  private String apellido;
  @Column(name="email", nullable=false, length=50, unique = true)
  private String email;
  
  @Column(name="create_at")
  @Temporal(TemporalType.DATE)
  private Date createAt;
  
  @PrePersist // antes de persistir la info en la bd se crea la fecha 
  public void prePersist() {
    createAt = new Date();
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  private static final long serialVersionUID = 1L;

}
