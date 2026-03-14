package com.luisdev.serviceorder.controller;

import com.luisdev.serviceorder.entity.Client;
import com.luisdev.serviceorder.service.ClientService;
import org.springframework.web.bind.annotation.*;

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
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    // @GetMapping = Lista Clientes
    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    // @GetMapping("/{id}") = Busca cliente por ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    // @DeleteMapping = Remove Cliente
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

}
