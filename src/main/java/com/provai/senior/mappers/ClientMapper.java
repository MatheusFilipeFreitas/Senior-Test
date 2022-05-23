package com.provai.senior.mappers;

import com.provai.senior.dto.ClientDto;
import com.provai.senior.models.Client;

public class ClientMapper {

    public static Client mapClient(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        return client;
    }
}
