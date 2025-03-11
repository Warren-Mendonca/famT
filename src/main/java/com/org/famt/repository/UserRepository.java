package com.org.famt.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.org.famt.entity.Users;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsersRepository {

    @Autowired
    private DynamoDBMapper mapper;


    public Users addUser(Users user) {
        mapper.save(user);
        return user;
    }

    public Users getUser(String id) {
        return mapper.load(Users.class, id);
    }

    public String editPerson() {
        
    }
}
