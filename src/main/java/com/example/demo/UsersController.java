package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    private Map<Integer, UserEntity> users = new HashMap<>();
    private Integer licznik = 1;

    @GetMapping("/users")
    @ResponseBody
    public Object getUsers() {
        List<UserEntity> lista = new ArrayList<>();
        for (UserEntity val : users.values()) {
            lista.add(val);
        }
        return lista;
    }

    @GetMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Integer id) {
        for (Integer key : users.keySet()) {
            if (users.containsKey(id))
                return users.get(id);
        }
        return "Nie znaleziono użytkownika";
    }

    @GetMapping("/user/add")
    @ResponseBody
    public boolean addUser(
            @RequestParam String imie,
            @RequestParam String nazwisko,
            @RequestParam Integer wiek) {

        if (imie != null && nazwisko != null && wiek != 0) {
            UserEntity uzytkownik = new UserEntity(imie, nazwisko, wiek);
            users.put(licznik++, uzytkownik);
            return true;
        }
        return false;
    }

    @GetMapping("/users/{id}/remove")
    @ResponseBody
    public boolean removeUser(@PathVariable Integer id) {
        for (Integer key : users.keySet()) {
            if (users.containsKey(id)) {
                users.remove(id);
                return true;
            }
        }
        return false;
    }

}