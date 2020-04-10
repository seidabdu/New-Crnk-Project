package com.example.crnkdemosampleproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class EventRepository extends ResourceRepositoryBase<EventEntity, Long> {

	@Autowired
	private EventEntityService eventEntityService;

	public EventRepository() {
		super(EventEntity.class);

	}

	@Override
	public synchronized void delete(Long id) {
		eventEntityService.deleteById(id);
	}

	@Override
	public synchronized <S extends EventEntity> S save(S event) {

		List<AccomodationType> accomodationList = event.getAccomodationTypeList();

		for (AccomodationType accomodationType : accomodationList) {
			accomodationType.setEventEntity(event);
		}
		event.setAccomodationTypeList(accomodationList);
		if (eventEntityService.existsById(event.getId())) {
			eventEntityService.createEvent(event);
		} else {
			eventEntityService.updateEvent(event);
		}

		return event;
	}

	@Override
	public synchronized ResourceList<EventEntity> findAll(QuerySpec querySpec) {
		List<EventEntity> listEvents = eventEntityService.getAllEvents();

		return querySpec.apply(listEvents);
	}
}