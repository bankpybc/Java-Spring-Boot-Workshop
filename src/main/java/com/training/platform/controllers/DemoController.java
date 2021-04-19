package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserRepository userRepository;

    // @GetMapping(value = "")
    // public String index() {
    // return "Method GET, Function : index => SHOW data list on page";
    // }
    /*
    @GetMapping(value = "")
    public String showWithParam(@RequestParam String id) { // query string
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with query string";
    }
    @PostMapping(value = "")
    public String create(@RequestBody Map<String,Object> inputs) {
        System.out.println("########### POST Param ###########");
        System.out.println(inputs);
        return "Method POST, Function : create => INSERT data to DB";
    }
    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }
    @PatchMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String, Object> inputs) {
        System.out.println("########### PATCH Param ###########");
        System.out.println(inputs);
        return "Method PATCH, Function : update => ID : " + id + "UPDATE data to DB";
    }
    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id) {
        return "Method DELETE, Function : delete, ID : " + id + " => DELETE data to DB";
    }
     */
    //404 not found
    /*@RequestMapping(value = "/healthcheck")
    public String healthCheck(@RequestParam String code, HttpServletResponse response) {
        if("200".equals(code)){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return "Hello World!";
    }*/
    /*
    @RequestMapping(value = "/healthcheck")
    public String healthCheck(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "404 Not Found !";
    }
    */
    // ------------------------------------------------------------------------------------
   /* @GetMapping(value = "")
    public List<User> index() {
        List<User> users = userRepository.findAll(); // same as select * in sql
        System.out.println("############### Find All User (In Console) ###############");
                System.out.println(users);
        return users;
    }*/
    /*
    @GetMapping(value = "")
    public List<User> index() {
        List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
        return users;
    }*
    /* with param
    @GetMapping(value = "")
    public List<User> index(@RequestParam String city, @RequestParam String active ,@RequestParam String age) {
        List<User> users = userRepository.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
        return users;
    }*/

    // find by Id
    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console) ###############");
        System.out.println(user);
        return "Method Get, Function : show, ID : " + id + " => SHOW data by id on page with path";
    }
    /*
    @GetMapping(value = "")
    public String showWithParam(@RequestParam String id) {
        Optional<User> user = userService.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console)(showWithParam)###############");
        System.out.println(user);
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with param";
    }*/
    /*
    @GetMapping(value = "")
    public List<User> index() {
        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 22));
        List<User> users = userRepository.findByAgeIn(ages);
        return users;
    }*/


    // Example for findAllByQuery
    @GetMapping(value = "/test1")
    public List<User> test1() {
        return userRepository.findAllByQuery();
    }

    // Example for findAllByParamsQuery
    @GetMapping(value = "/test2")
    public List<User> test2() {
        return userRepository.findAllByParamsQuery(0, "nakornpathom");
    }

    // Example for findAllByJpqlQuery
    @GetMapping(value = "/test3")
    public List<User> test3() {
        return userRepository.findAllByJpqlQuery();
    }

    // Example for findAllByJpqlParamsQuery
    @GetMapping(value = "/test4")
    public List<User> test4() {
        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
    }
}