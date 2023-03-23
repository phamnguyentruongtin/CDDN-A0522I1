package com.example.book_borrow.repository;

import com.example.book_borrow.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface IClientRepository extends JpaRepository<Client,Integer> {
    @Query(value = "select * from book where client_client_id = ?",nativeQuery = true)
    Page<Client> getAllBookOfclient(Integer idClient, PageRequest pageRequest);
}
