package com.luisdev.serviceorder.controller;

import com.luisdev.serviceorder.entity.Client;
import com.luisdev.serviceorder.service.ClientService;
import org.springframework.web.bind.annotation.*;
import com.luisdev.serviceorder.dto.ClientRequestDTO;
import com.luisdev.serviceorder.dto.ClientResponseDTO;
import com.luisdev.serviceorder.mapper.ClientMapper;
import jakarta.validation.Valid;
import jakarta.validation.Valid;

import java.util.List;


// @RestController = Indica que a classe responde requisições HTTP
// @RequestMapping("/clients") = Define o endpoint base da API
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // @PostMapping = Cria um cliente
    @PostMapping
    public ClientResponseDTO createClient(@RequestBody @Valid ClientRequestDTO dto){
        var client = ClientMapper.toEntity(dto);
        var saved = clientService.createClient(client);
        return ClientMapper.toResponse(saved);
    }

    // @GetMapping = Lista Clientes
    @GetMapping
    public List<ClientResponseDTO> getAllClients(){
        return clientService.getAllClient()
                .stream()
                .map(ClientMapper::toResponse)
                .toList();
    }

    // @GetMapping("/{id}") = Busca cliente por ID
    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id){
        return ClientMapper.toResponse(clientService.getClientById(id));
    }

    // @DeleteMapping = Remove Cliente
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(
            @PathVariable Long id,
            @RequestBody @Valid ClientRequestDTO dto
    ){
        var client = ClientMapper.toEntity(dto);
        var updated = clientService.updateClient(id, client);
        return ClientMapper.toResponse(updated);
    }

}
