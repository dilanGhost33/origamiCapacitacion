package org.capacitacion.services;

import org.capacitacion.dto.ClienteDto;
import org.capacitacion.entidad.Cliente;
import org.capacitacion.mappers.ClienteMapper;
import org.capacitacion.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepository;
    @Autowired
    private ClienteMapper ClienteMapper;

    public ClienteService(ClienteRepository ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }
    public List<ClienteDto> getProducts() {
        List<ClienteDto> result= ClienteMapper.toDto(ClienteRepository.findAll());
        return result;
    }

    public ClienteDto guardar(ClienteDto ClienteDto){
        Cliente Cliente = ClienteMapper.toEntity(ClienteDto);
        ClienteRepository.save(Cliente);
        return ClienteMapper.toDto(Cliente);
    }
    public String delete(Long id){
        ClienteRepository.deleteById(id);
        return "El Cliente se eliminó";
    }
}
