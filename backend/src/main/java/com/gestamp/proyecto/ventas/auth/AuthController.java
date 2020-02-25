package com.gestamp.proyecto.ventas.auth;

import com.gestamp.proyecto.ventas.user.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestAttribute("claims") final Claims claims) throws NotFoundException {
        return userService.getUserByEmail(claims.getSubject());
    }
}
