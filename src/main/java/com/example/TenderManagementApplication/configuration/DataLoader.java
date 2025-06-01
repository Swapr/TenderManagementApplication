package com.example.TenderManagementApplication.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.TenderManagementApplication.model.RoleModel;
import com.example.TenderManagementApplication.model.UserModel;
import com.example.TenderManagementApplication.repository.RoleRepository;
import com.example.TenderManagementApplication.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws InterruptedException {
        roleRepository.save(new RoleModel("BIDDER"));
        roleRepository.save(new RoleModel("APPROVER"));

        userRepository.save(new UserModel( "bidder1", "companyOne", "bidder123$", "bidderemail@gmail.com", new RoleModel(1)));
        userRepository.save(new UserModel( "bidder2", "companyTwo", "bidder789$", "bidderemail2@gmail.com", new RoleModel(1)));
        userRepository.save(new UserModel( "approver", "defaultCompany", "approver123$", "approveremail@gmail.com", new RoleModel(2)));
    }
}

