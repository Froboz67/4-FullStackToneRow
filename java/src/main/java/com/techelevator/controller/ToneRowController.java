package com.techelevator.controller;

import com.techelevator.dao.ToneRowDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ToneRow;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class ToneRowController {

    private final ToneRowDao toneRowDao;
    private final UserDao userDao;

     public ToneRowController(ToneRowDao toneRowDao, UserDao userDao) {
        this.toneRowDao = toneRowDao;
        this.userDao = userDao;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tonerow/{id}")
    public ToneRow getToneRowById(@PathVariable int id, Principal principal) {
         return this.toneRowDao.getTonerowById(id);
    }
}
