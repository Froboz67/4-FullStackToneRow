package com.techelevator.controller;

import com.techelevator.dao.ToneRowDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ToneRow;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
         return this.toneRowDao.getToneRowById(id);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tonerow")
    public List<ToneRow> getToneRows(Principal principal) {
         return this.toneRowDao.getToneRows();
    }

    @PostMapping("/tonerow")
    public ToneRow saveToneRow(@RequestBody ToneRow toneRow) {
         return toneRowDao.saveToneRow(toneRow);
    }


}
