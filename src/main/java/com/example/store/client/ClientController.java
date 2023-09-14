package com.example.store.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public Client add(Client client){
        return clientService.add(client);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        clientService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable Long id){
        return clientService.getById(id);
    }

    @GetMapping("/list")
    public List<Client> all(){
        return clientService.all();
    }

    @PostMapping("/edit/{id}")
    public Client edit(@PathVariable Long id, Client client){
        return clientService.edit(id, client);
    }

}
