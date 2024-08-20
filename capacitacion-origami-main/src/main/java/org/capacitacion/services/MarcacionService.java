package org.capacitacion.services;

import org.capacitacion.dto.MarcacionDto;
import org.capacitacion.entidad.Marcacion;
import org.capacitacion.mappers.MarcacionMapper;
import org.capacitacion.respository.MarcacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MarcacionService {

    @Autowired
    private MarcacionRepository marcacionRepository;
    @Autowired
    private MarcacionMapper mapper;

    public MarcacionDto registrarMarcacion(MarcacionDto marcacionDto) {
        Marcacion m = mapper.toEntity(marcacionDto);
        m.setUsuarioRegistro("admin");
        if (m.getFechaRegistro() != null) {
            m.setFechaRegistro(new Date());
        }
        marcacionRepository.save(m);
        return mapper.toDto(m);
    }



}
