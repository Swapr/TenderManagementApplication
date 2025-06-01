package com.example.TenderManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TenderManagementApplication.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer>{

}
