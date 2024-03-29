package com.example.trainingapp.services.repositories;

import com.example.trainingapp.entities.NormaluserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<NormaluserEntity, Long> {
    @Query(value = "select TIMESTAMPDIFF(YEAR ,birth_date,CURDATE()) from normaluser where id= ?1",nativeQuery = true)
    int getUserAgeById(int idTofind);

    Optional<NormaluserEntity> findByEmail(String email);

}
