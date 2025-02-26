package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"autor", "editorial", "librerias"})
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "editorial")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Autor autor;

    @ManyToMany(mappedBy = "coleccionLibros")
    private List<Libreria> librerias;
}
