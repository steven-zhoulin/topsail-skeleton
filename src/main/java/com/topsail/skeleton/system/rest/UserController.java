package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.common.exception.BadRequestException;
import com.topsail.skeleton.system.domain.User;
import com.topsail.skeleton.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven
 */
@RestController
@RequestMapping("api/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<User>> selectAll() {
        List<User> users = userService.selectAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> selectByPrimaryKey(@PathVariable Long id) {
        User user = userService.selectByPrimaryKey(id);
        if (null == user) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity insert(User user) {
        int status = userService.insert(user);
        if (1 == status) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            throw new BadRequestException("A new ... cannot already have an ID");
        }

    }

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return userService.deleteByPrimaryKey(id);
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(User user) {
        return userService.updateByPrimaryKey(user);
    }

}
