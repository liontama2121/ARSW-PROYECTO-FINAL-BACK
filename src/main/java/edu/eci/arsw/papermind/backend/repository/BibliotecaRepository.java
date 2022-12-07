package edu.eci.arsw.papermind.backend.repository;


import edu.eci.arsw.papermind.backend.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //componente encargado de resolver el acceso a los datos de nuestro micro-servicio.
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

    @Query(value = "select * from bibliotecas b where lower(b.nombre) = :nombre", nativeQuery = true)
    Biblioteca findByName(@Param("nombre") String nombre);

    Biblioteca findByNombre(String name);
}