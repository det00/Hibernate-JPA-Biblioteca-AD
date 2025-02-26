package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "coleccionLibros")
@Entity
@Table(name = "librerias")
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(name = "nombre_propietario")
    private String nombrePropietario;
    private String direccion;
    @ManyToMany
    @JoinTable(
            name = "libro_libreria",
            joinColumns = @JoinColumn(name = "id_libreria"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> coleccionLibros;
}
