package com.jhon.springboot.jhon.repository;

import com.jhon.springboot.jhon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {//Entidad y tipo de dato del ID

}
