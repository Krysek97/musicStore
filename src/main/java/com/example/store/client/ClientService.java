package com.example.store.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add(Client client){
        return clientRepository.save(client);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    public Optional<Client> getById(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> all(){
        return clientRepository.findAll();
    }

    public Client edit (Long id, Client client){
        Optional<Client> oldProfile = clientRepository.findById(id);
        if (oldProfile.isPresent()){
            Client newClient = oldProfile.get();
            newClient.setUsername(client.getUsername());
            newClient.setAddress(client.getAddress());
            newClient.setPhoneNumber(client.getPhoneNumber());
            newClient.setPassword(client.getPassword());
            return clientRepository.save(newClient);
        }
        return client;
    }

}
