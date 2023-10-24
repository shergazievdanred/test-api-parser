package com.testapiparse.controller;

import com.testapiparse.dto.ClientDTO;
import com.testapiparse.entity.Client;
import com.testapiparse.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto) {
        return mappingResponseClient(clientService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        return mappingResponseListProduct(clientService.readAll());
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client){
        return mappingResponseClient(clientService.update(client));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        clientService.delete(id);
        return HttpStatus.OK;
    }


    private ResponseEntity<Client> mappingResponseClient(Client client) {
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    private ResponseEntity<List<Client>> mappingResponseListProduct(List<Client> client) {
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
