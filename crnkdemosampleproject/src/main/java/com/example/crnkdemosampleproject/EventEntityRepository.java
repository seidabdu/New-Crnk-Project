package com.example.crnkdemosampleproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventEntityRepository extends JpaRepository<EventEntity, Long> {
	public EventEntity findByName(String eventname);

	@Modifying
	@Query("update EventEntity e set e.name = :name, e.address = :address where e.id = :eventId")
	public void setEventById(String name, String address, Long eventId);
}
