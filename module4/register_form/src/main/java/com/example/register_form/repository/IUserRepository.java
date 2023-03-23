package com.example.register_form.repository;

import com.example.register_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
//    @Query(value = "select * from user_register",nativeQuery = true)
//    Page<User> getAllWithPage(PageRequest pageRequest);
}
