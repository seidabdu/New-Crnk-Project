package com.example.crnkdemosampleproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventEntityService {

	@Autowired
	private EventEntityRepository eventEntityRepository;

	public EventEntityService() {

	}

	public EventEntity createEvent(EventEntity event) {
		EventEntity eventEntity = eventEntityRepository.save(event);
		return eventEntity;
	}

	public EventEntity updateEvent(EventEntity event) {

		eventEntityRepository.setEventById(event.getName(), event.getAddress(), event.getId());

		return event;
	}

	public List<EventEntity> getAllEvents() {
		List<EventEntity> entityList = (List<EventEntity>) eventEntityRepository.findAll();
		return entityList;
	}

	public EventEntity getEventByName(String eventName) {
		EventEntity eventEntity = eventEntityRepository.findByName(eventName);
		return eventEntity;
	}

	public Optional<EventEntity> getById(Long id) {
		Optional<EventEntity> eventEntity = eventEntityRepository.findById(id);
		return eventEntity.isPresent() ? eventEntity : null;
	}

	public void deleteById(Long id) {
		eventEntityRepository.deleteById(id);

	}
}
