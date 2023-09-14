package com.example.store.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin add(Admin admin){
        return adminRepository.save(admin);
    }

    public void deleteById(Long id){
        adminRepository.deleteById(id);
    }

    public List<Admin> all(){
        return adminRepository.findAll();
    }



}
