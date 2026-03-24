package com.luisdev.serviceorder.service;

import com.luisdev.serviceorder.entity.Client;
import com.luisdev.serviceorder.exception.ClientNotFoundException;
import com.luisdev.serviceorder.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


// @Service = Indica que essa classe pertence à camada de negócio
@Service
public class ClientService {

    // Injeção de dependência, o Spring Framework injeta automaticamente o repository
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client){
         client.setCreatedAt(java.time.LocalDateTime.now());
        return clientRepository.save(client);
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id));
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client updatedClient){

        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhone(updatedClient.getPhone());

        return clientRepository.save(existingClient);
    }
}
