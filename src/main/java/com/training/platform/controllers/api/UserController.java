package com.training.platform.controllers.api;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api-user")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public List<User> findById(@PathVariable String id) {
        return userService.findAll();
    }

    @GetMapping(value = "/findAllByLimit")
    public Page<User> findAllByLimit(@RequestParam String start, @RequestParam String limit, @RequestParam String field) {
        return userService.findAllByLimit(Integer.parseInt(start), Integer.parseInt(limit), field);
    }

    @GetMapping(value = "findByCityAndActiveAndAge")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, @RequestParam String active, @RequestParam String age) {
        return userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
    }

    @GetMapping(value = "/findByAgeIn")
    List<User> findByAgeIn(@RequestParam List<Integer> ages) {
        return userService.findByAgeIn(ages);
    }

    @GetMapping(value = "/findAllByQuery")
    List<User> findAllByQuery() {
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/findAllByParamsQuery")
    List<User> findAllByParamsQuery(@RequestParam String active, @RequestParam String city) {
        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
    }

    @GetMapping(value = "/findAllByJpqlQuery")
    List<User> findAllByJpqlQuery() {
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/findAllByJpqlParamsQuery")
    List<User> findAllByJpqlParamsQuery(@RequestParam String active, @RequestParam String city) {
        return userService.findAllByJpqlParamsQuery(Integer.parseInt(active), city);
    }

    //new UserController 6 methods
    @GetMapping(value = "/findByCity")
    List<User> findByCity(@RequestParam String city) {
        return userService.findByCity(city);
    }

    @GetMapping(value = "/findByActive")
    List<User> findByActive(@RequestParam String active) {
        return userService.findByActive(Integer.parseInt(active));
    }

    @GetMapping(value = "/findByAge")
    List<User> findByAge(@RequestParam String age) {
        return userService.findByAge(Integer.parseInt(age));
    }

    @GetMapping(value = "/findByAgeAndActive")
    List<User> findByAgeAndActive(@RequestParam String age, @RequestParam String active) {
        return userService.findByAgeAndActive(Integer.parseInt(age), Integer.parseInt(active));
    }

    @GetMapping(value = "/findByAgeAndCity")
    List<User> findByAgeAndCity(@RequestParam String age, @RequestParam String city){
        return userService.findByAgeAndCity(Integer.parseInt(age),city);
    }

    @GetMapping(value = "/findByActiveAndCity")
    List<User> findByActiveAndCity(@RequestParam String active, @RequestParam String city){
        return userService.findByActiveAndCity(Integer.parseInt(active),city);
    }
}
