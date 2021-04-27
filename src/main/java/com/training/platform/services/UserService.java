package com.training.platform.services;

import com.training.platform.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    Page<User> findAllByLimit(Integer start, Integer limit, String field);

    List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age);

    List<User> findByAgeIn(List<Integer> ages);

    List<User> findAllByQuery();

    List<User> findAllByParamsQuery(Integer active, String city);

    List<User> findAllByJpqlQuery();

    List<User> findAllByJpqlParamsQuery(Integer active, String city);

    //new UserService 6 methods
    List<User> findByCity(String city);

    List<User> findByActive(Integer active);

    List<User> findByAge(Integer age);

    List<User> findByAgeAndActive(Integer age, Integer active);

    List<User> findByAgeAndCity(Integer age, String city);

    List<User> findByActiveAndCity(Integer active, String city);

    // new

    Page<User> findAll(PageRequest pageRequest);

    Map<String,String> getCities();

    User save(Map<String,String> inputs) throws Exception;

    boolean isEmailAlreadyInUse(String email);

    User update(Optional<User> user, Map<String,String> inputs) throws Exception;

    void deleteById(Integer id) throws Exception;
}