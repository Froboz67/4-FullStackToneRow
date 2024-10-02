package com.techelevator.controller;

import com.techelevator.dao.ToneRowDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ToneRow;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ToneRow saveToneRow(@RequestBody ToneRow toneRow, Principal principal) {
         String username = principal.getName();
         User currentUser = userDao.getUserByUsername(username);

         authHelper(toneRow.getUser_id(), principal);

         toneRow.setUser_id(currentUser.getId());

         return toneRowDao.saveToneRow(toneRow);
    }
    private void authHelper(int id, Principal principal) {

        String username = principal.getName();
        User authenticatedUser = userDao.getUserByUsername(username);
        System.out.println(id);
        System.out.println(authenticatedUser);
        System.out.println(username);
        if (authenticatedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        if (id != authenticatedUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }


}
