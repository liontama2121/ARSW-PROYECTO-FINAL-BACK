package edu.eci.arsw.papermind.backend.converter;

import edu.eci.arsw.papermind.backend.dto.BibliotecaDto;
import edu.eci.arsw.papermind.backend.model.Biblioteca;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaConverter {

    public BibliotecaDto entityToDto(Biblioteca biblioteca) {
        ModelMapper mapper =new ModelMapper();
        BibliotecaDto map = mapper.map(biblioteca, BibliotecaDto.class);
        return map;

    }
    public List<BibliotecaDto> entityToDto(List<Biblioteca> student) {

        return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Biblioteca dtoToEntity(BibliotecaDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Biblioteca map = mapper.map(dto, Biblioteca.class);
        return map;
    }

    public List<Biblioteca> dtoToEntity(List<BibliotecaDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
