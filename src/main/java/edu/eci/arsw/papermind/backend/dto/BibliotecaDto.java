package edu.eci.arsw.papermind.backend.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BibliotecaDto {


    private Long id;

    private String nombre;

    private Date fecha_dateCreated;

    private Date fecha_modification;

    private String description;

}
