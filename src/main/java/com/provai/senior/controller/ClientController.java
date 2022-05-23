package com.provai.senior.controller;

import com.provai.senior.dto.ClientDto;
import com.provai.senior.models.Client;
import com.provai.senior.services.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }

    /**
     *
     * @return a List of clients.
     */
    @GetMapping("/all")
    public List<Client> findAll(){
        return service.findAll();
    }

    /**
     *
     * @param clientDto DTO from client.
     * @return Client registered.
     */
    @PostMapping("/add")
    public Client insert(@RequestBody @Valid ClientDto clientDto){
        return service.insert(clientDto);
    }

    /**
     *
     * @param id id from client.
     * @param clientDto client is going to be updated.
     * @return Client updated.
     */
    @PutMapping("/update/{id}")
    public Client update(@PathVariable UUID id, @RequestBody @Valid ClientDto clientDto){
        return service.update(id, clientDto);
    }

    /**
     *
     * @param id id from client.
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
