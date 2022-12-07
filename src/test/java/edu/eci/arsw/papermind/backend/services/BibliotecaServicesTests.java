package edu.eci.arsw.papermind.backend.services;

import edu.eci.arsw.papermind.backend.dto.BibliotecaDto;
import edu.eci.arsw.papermind.backend.model.Biblioteca;
import edu.eci.arsw.papermind.backend.repository.BibliotecaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class BibliotecaServicesTests {

    @Mock
    private static BibliotecaRepository bibliotecaRepository;

    @Mock
    private static BibliotecaRepository bibliotecaRepository2;

    @InjectMocks
    private BibliotecaServices bibliotecaServices;

    private Biblioteca biblioteca,biblioteca2;

    private BibliotecaDto bibliotecaDto;

    private List<Biblioteca> bibliotecas;

    @BeforeEach
    public void init(){
        biblioteca = new Biblioteca();
        biblioteca.setNombre("Prueba");
        biblioteca.setFecha_dateCreated(new Date(2022-11-22));
        biblioteca.setFecha_modification(new Date(2022-11-22));
        biblioteca.setDescription("Hola");

        biblioteca2 = new Biblioteca();
        biblioteca2.setNombre("Test");
        biblioteca2.setFecha_dateCreated(new Date(2022-11-22));
        biblioteca2.setFecha_modification(new Date(2022-11-22));
        biblioteca2.setDescription("Hola Mundo");

        bibliotecas = new ArrayList<>();
        bibliotecas.add(biblioteca);
        bibliotecas.add(biblioteca2);
    }

    @DisplayName("Test Guardando una biblioteca.")
    @Test
    void testSaveBiblioteca(){
        //given
        given(bibliotecaRepository.save(biblioteca)).willReturn(biblioteca);
        //when
        ResponseEntity<?> bibliotecaGuardada = bibliotecaServices.saveBiblioteca(biblioteca);
        //then
        assertEquals(bibliotecaGuardada.getBody(),biblioteca);
    }

    @DisplayName("Test Obteniendo Todas las Bibliotecas.")
    @Test
    void testGetAllBibliotecas(){
        //given
        given(bibliotecaRepository.findAll()).willReturn(bibliotecas);
        //when
        List<Biblioteca> listaBiblitoecas = bibliotecaServices.getBibliotecas();
        //then
        assertEquals(listaBiblitoecas,bibliotecas);
    }



    @DisplayName("Test Obteniendo una Biblioteca por Nombre.")
    @Test
    void testGetBiblioteca(){
        //given
        given(bibliotecaRepository.findByNombre(biblioteca2.getNombre())).willReturn(biblioteca2);
        //when
        Biblioteca bibliotecaRespuesta = bibliotecaServices.getBibliotecaByName("Test");
        //then
        System.out.println(bibliotecaRespuesta.getNombre());
        assertEquals(bibliotecaRespuesta.getNombre(),biblioteca2.getNombre());
    }

    @DisplayName("Test Eliminando una Biblioteca por Nombre.")
    @Test
    void testDeleteBiblioteca(){
        //given
        long bibliotecaId = 2L;
        String mensaje = "Se borro correctamente la biblioteca";
        given(bibliotecaRepository.findByNombre(biblioteca2.getNombre())).willReturn(biblioteca2);
        lenient().when(bibliotecaRepository.findById(bibliotecaId)).thenReturn(null);  //Omitir los stubs estrictos. Esto también se conoce como stubbing indulgente.
        //when
        ResponseEntity<?> bibliotecaRespuesta = bibliotecaServices.deleteBiblioteca("Test");
        //then
        System.out.println(bibliotecaRespuesta.getStatusCodeValue());
        String respuesta = (String) bibliotecaRespuesta.getBody();
        assertEquals(respuesta, mensaje);
    }
}
