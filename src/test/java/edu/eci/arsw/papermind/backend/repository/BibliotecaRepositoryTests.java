package edu.eci.arsw.papermind.backend.repository;

import edu.eci.arsw.papermind.backend.model.Biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //proporciona una forma conveniente de configurar un entorno con una base de datos integrada para probar nuestras consultas de base de datos.
public class BibliotecaRepositoryTests {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    private static Biblioteca biblioteca, biblioteca2;

    private static List<Biblioteca> bibliotecas;

    @BeforeEach
    public void inicializarVariables(){
        biblioteca = new Biblioteca();
        biblioteca.setNombre("Biblioteca 01");
        biblioteca.setFecha_dateCreated(new Date(2022 - 11 - 22));
        biblioteca.setFecha_modification(new Date(2022 - 11 - 22));
        biblioteca.setDescription("Hola");

        biblioteca2 = new Biblioteca();
        biblioteca2.setNombre("Biblioteca 02");
        biblioteca2.setFecha_dateCreated(new Date(2022 - 11 - 22));
        biblioteca2.setFecha_modification(new Date(2022 - 11 - 22));
        biblioteca2.setDescription("Hola");

        bibliotecas = new ArrayList<>();
        bibliotecas.add(biblioteca);
        bibliotecas.add(biblioteca2);
    }

    @DisplayName("Test Guardar Biblioteca.")
    @Test
    void testSaveBiblioteca() {
        Biblioteca bibliotecaGuardada = bibliotecaRepository.save(biblioteca);
        assertNotNull(bibliotecaGuardada);
    }

    @DisplayName("Test Buscar una Biblioteca por nombre.")
    @Test
    void testFindBibliotecaName() {
        bibliotecaRepository.save(biblioteca2);
        assertEquals(biblioteca2,bibliotecaRepository.findByNombre("Biblioteca 02"));
    }

    @DisplayName("Test Buscar todas las bibliotecas.")
    @Test
    void testFindAllBibliotecas() {
        bibliotecaRepository.save(biblioteca);
        bibliotecaRepository.save(biblioteca2);
        List<Biblioteca> bibliotecasEncontradas = bibliotecaRepository.findAll();
        assertEquals(bibliotecas,bibliotecasEncontradas);
    }

    @DisplayName("Test Actualziar Biblioteca.")
    @Test
    void testUpdateBiblioteca() {
        biblioteca.setNombre("Biblioteca Nueva");
        biblioteca.setDescription("Hola Nuevo");
        Biblioteca bibliotecaActualziada = bibliotecaRepository.save(biblioteca);
        assertEquals(bibliotecaActualziada.getNombre(),biblioteca.getNombre());
        assertEquals(bibliotecaActualziada.getDescription(),biblioteca.getDescription());
    }

    @DisplayName("Test Eliminar Biblioteca.")
    @Test
    void testDeleteBiblioteca() {
        bibliotecaRepository.save(biblioteca);
        bibliotecaRepository.deleteById(1L);
        Optional<Biblioteca> bibliotecaRespuesta = bibliotecaRepository.findById(biblioteca.getId_biblioteca());
        System.out.println("Biblioteca: " + bibliotecaRespuesta);
        assertFalse(bibliotecaRespuesta.isPresent());
    }

}
