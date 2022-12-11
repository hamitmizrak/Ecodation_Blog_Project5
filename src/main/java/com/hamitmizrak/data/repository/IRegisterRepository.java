package com.hamitmizrak.data.repository;


import com.hamitmizrak.data.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Spring 2.2 sonra @Repository yazmak zorunda değiliz ama biz yazalım
// bu classın bir repository olduğunu anlamak ve okumak için
@Repository
public interface IRegisterRepository extends CrudRepository<RegisterEntity,Long> {

    // delivered Query
    RegisterEntity findByEmail(String email);
}
