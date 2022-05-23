package com.provai.senior.services;

import com.provai.senior.dto.ClientDto;
import com.provai.senior.mappers.ClientMapper;
import com.provai.senior.models.Client;
import com.provai.senior.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client insert(ClientDto clientDto){
        Client client = ClientMapper.mapClient(clientDto);
        return repository.save(client);
    }

    public Client update(UUID id, ClientDto clientDto){
        Client overrideClient = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
        overrideClient.setName(clientDto.getName());
        return repository.save(overrideClient);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public Client findByID(UUID id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
    }

}
