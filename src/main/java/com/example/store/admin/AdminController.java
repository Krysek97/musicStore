package com.example.store.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public Admin add(Admin admin){
        return adminService.add(admin);
    }

    @GetMapping("/list")
    public List<Admin> all(){
        return adminService.all();
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        adminService.deleteById(id);
    }



}
