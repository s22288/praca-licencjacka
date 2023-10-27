package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.BodypartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyPartRepository extends JpaRepository<BodypartEntity,Long> {



}
