
package com.jianding.storweb.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/security")
public class SecurityController {
    @RequestMapping(value = "/user", method = GET)
    @ResponseBody
    public String getUser(Principal principal) throws Exception {
        // ignore anonymous user
        if (principal == null || principal.getName().equals("anonymous")) {
            return null;
        }
        
        return principal.getName();
    }
}
