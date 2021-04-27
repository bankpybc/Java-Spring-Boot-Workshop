package com.training.platform.repositories;

import com.training.platform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> { // convert repo to jpa

    public List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age);

    public List<User> findByAgeIn(List<Integer> ages);

    @Query(value = "SELECT * FROM users u WHERE u.active = 1 and u.city = 'Bangkok' ", nativeQuery = true)
    public List<User> findAllByQuery();

    @Query(value = "SELECT * FROM users u WHERE u.active = ?1 and u.city = ?2", nativeQuery = true)
    public List<User> findAllByParamsQuery(Integer active, String city);

    @Query("SELECT u FROM User u WHERE u.active = 1 and u.city = 'Bangkok' ")
    public List<User> findAllByJpqlQuery();

    @Query("SELECT u FROM User u WHERE u.active = ?1 and u.city = ?2 ")
    public List<User> findAllByJpqlParamsQuery(Integer active, String city);

    // new repository 6 methods
    public List<User> findByCity(String city);

    public List<User> findByActive(Integer active);

    public List<User> findByAge(Integer age);

    public List<User> findByAgeAndActive(Integer age, Integer active);

    public List<User> findByAgeAndCity(Integer age, String city);

    public List<User> findByActiveAndCity(Integer active, String city);
    // new
    User findByEmail(String email);

}
