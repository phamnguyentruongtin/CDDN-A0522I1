package com.example.book_borrow.service;

import com.example.book_borrow.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IClientService {
    Page<Client> getAllBookOfclient(Integer idClient,PageRequest pageRequest);
    void saveClient(Client client);
    void removeClient(Client client);
    Client findByIdClient(Integer idClient);
    Page<Client> clinentWithPage(PageRequest pageRequest);
    List<Client> getAllClient();
}
