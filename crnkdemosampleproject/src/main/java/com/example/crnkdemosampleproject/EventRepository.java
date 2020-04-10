package com.example.crnkdemosampleproject;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class EventRepository extends ResourceRepositoryBase<EventEntity, Long> {

	@Autowired
	private EventEntityService eventEntityService;
	private static final AtomicLong ID_GENERATOR = new AtomicLong(3);

	public EventRepository() {
		super(EventEntity.class);

	}

	@Override
	public synchronized void delete(Long id) {
		eventEntityService.deleteById(id);
	}

	@Override
	public synchronized <S extends EventEntity> S save(S event) {
		if (event.getId() == null) {
			event.setId(ID_GENERATOR.getAndIncrement());
		}

		System.out.println("++++++++ this is inside Event repo save method +++++++++++++");

		EventEntity eventEntity = new EventEntity();
		eventEntity.setName(event.getName());
		eventEntity.setAddress(event.getAddress());
		if (eventEntityService.getById(event.getId()) != null) {
			System.out.println("++++++++ this is inside update  method +++++++++++++");

			eventEntityService.updateEvent(event);
		} else {
			eventEntityService.createEvent(eventEntity);
		}

		return event;
	}

	@Override
	public synchronized ResourceList<EventEntity> findAll(QuerySpec querySpec) {
		List<EventEntity> listEvents = eventEntityService.getAllEvents();

		return querySpec.apply(listEvents);
	}
}