package com.luisdev.serviceorder.mapper;

import com.luisdev.serviceorder.dto.ClientRequestDTO;
import com.luisdev.serviceorder.dto.ClientResponseDTO;
import com.luisdev.serviceorder.entity.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequestDTO dto){
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());
        return client;
    }

    public static ClientResponseDTO toResponse(Client client){
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setCreatedAt(client.getCreatedAt());
        return dto;
    }
}
