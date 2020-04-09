package com.example.crnkdemosampleproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventEntityRepository extends JpaRepository<EventEntity, Long> {
	public EventEntity findByName(String eventname);

	@Modifying
	@Query("update EventEntity e set e.name = ?1, e.address = ?2 where e.id = ?3")
	public void setEventById(String name, String address, Long eventId);
}
