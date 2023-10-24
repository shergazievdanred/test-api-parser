package com.testapiparse.service;

import com.testapiparse.dto.ClientDTO;
import com.testapiparse.entity.Client;
import com.testapiparse.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientDTO dto) {
        return clientRepository.save(Client.builder()
                .first_name(dto.getFirst_name())
                .last_name(dto.getLast_name())
                .build()
        );
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
