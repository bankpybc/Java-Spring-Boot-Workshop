package com.training.platform.services;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAllByLimit(Integer start, Integer limit, String field) {
        PageRequest page = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
        return userRepository.findAll(page);
    }

    @Override
    public List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age) {
        return userRepository.findByCityAndActiveAndAge(city, active, age);
    }

    @Override
    public List<User> findByAgeIn(List<Integer> ages) {
        return userRepository.findByAgeIn(ages);
    }

    @Override
    public List<User> findAllByQuery() {
        return userRepository.findAllByQuery();
    }

    @Override
    public List<User> findAllByParamsQuery(Integer active, String city) {
        return userRepository.findAllByParamsQuery(active, city);
    }

    @Override
    public List<User> findAllByJpqlQuery() {
        return userRepository.findAllByJpqlQuery();
    }

    @Override
    public List<User> findAllByJpqlParamsQuery(Integer active, String city) {
        return userRepository.findAllByJpqlParamsQuery(active, city);
    }
    //new UserServiceImpl 6 methods
    @Override
    public List<User> findByCity(String city){
        return userRepository.findByCity(city);
    }

    @Override
    public List<User> findByActive(Integer active){
        return userRepository.findByActive(active);
    }

    @Override
    public List<User> findByAge(Integer age){
        return userRepository.findByAge(age);
    }

    @Override
    public List<User> findByAgeAndActive(Integer age, Integer active){
        return userRepository.findByAgeAndActive(age,active);
    }

    @Override
    public List<User> findByAgeAndCity(Integer age, String city){
        return userRepository.findByAgeAndCity(age,city);
    }

    @Override
    public List<User> findByActiveAndCity(Integer active, String city){
        return userRepository.findByActiveAndCity(active,city);
    }

}

