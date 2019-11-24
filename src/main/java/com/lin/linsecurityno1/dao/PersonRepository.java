package com.lin.linsecurityno1.dao;

import com.lin.linsecurityno1.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    //通过用户名查找用户
    Person findByUsername(String name);
}
