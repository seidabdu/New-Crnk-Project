package com.example.crnkdemosampleproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType, Long> {

}
