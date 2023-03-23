package com.example.book_borrow.service;

import com.example.book_borrow.model.Client;
import com.example.book_borrow.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{
    @Autowired
    private IClientRepository iClientRepository;
    @Override
    public Page<Client> getAllBookOfclient(Integer idClient, PageRequest pageRequest) {
        Page<Client> pageClient = iClientRepository.getAllBookOfclient(idClient,pageRequest);
        return pageClient;
    }

    @Override
    public void saveClient(Client client) {
        iClientRepository.save(client);
    }

    @Override
    public void removeClient(Client client) {
        iClientRepository.delete(client);
    }

    @Override
    public Client findByIdClient(Integer idClient) {
        Client client = iClientRepository.findById(idClient).get();
        return client;
    }

    @Override
    public Page<Client> clinentWithPage(PageRequest pageRequest) {
        Page<Client> page = iClientRepository.findAll(pageRequest);
        return page;
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = iClientRepository.findAll();
        return clients;
    }
}
