package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring 2.2 sonra @Repository yazmak zorunda değiliz ama biz yazalım
// bu classın bir repository olduğunu anlamak ve okumak için
@Repository
public interface IRegisterRepository extends JpaRepository<RegisterEntity,Long> {

    // delivered Query
    RegisterEntity findByEmail(String email);
}
