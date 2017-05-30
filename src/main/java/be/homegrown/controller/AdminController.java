package be.homegrown.controller;

import be.homegrown.entities.Boardgame;
import be.homegrown.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping(value = "/storeBggGameInDb/{bggId}", produces = {"application/json", "application/hal+json"})
    public List<Boardgame> queryOnBgg(@PathVariable("bggId") String bggId){
        return adminService.storeBggGameInDb(bggId);
    }

}
