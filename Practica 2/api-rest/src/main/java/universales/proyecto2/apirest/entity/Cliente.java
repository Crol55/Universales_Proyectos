package universales.proyecto2.apirest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{

    private static final long serialVersionUID = -4136731007764547123L;

    @Id
    @GeneratedValue(generator = "CLIENTE_DNICL")
    @Column(name = "DNI_CL")
    private Integer dniCl;

    @Column(name = "NOMBRE_CL")
    private String nombreCl;

    @Column(name = "APELLIDO_1")
    private String apellido1;

    @Column(name = "APELLIDO_2")
    private String apellido2;

    @Column(name = "CLASE_VIA")
    private String claseVia;

    @Column(name = "NOMBRE_VIA")
    private String nombreVia;
    
    @Column(name = "NUMERO_VIA")
    private String numeroVia;

    @Column(name = "COD_POSTAL")
    private String codPostal;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @OneToMany(mappedBy = "clienteDniCl")
    private List<Seguros> segurosList;


    @Override
    public String toString() {
        return "Cliente [dniCl=" + dniCl  + ", apellido2=" + apellido2 + ", ciudad=" + ciudad + ", claseVia="
                + claseVia + ", codPostal=" + codPostal + ", apellido1=" + apellido1 + ", nombreCl=" + nombreCl + ", nombreVia="
                + nombreVia + ", numeroVia=" + numeroVia + ", observaciones=" + observaciones + ", segurosList="
                + segurosList + ", telefono=" + telefono + "]";
    }

    

}
