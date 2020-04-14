package com.example.crnkdemosampleproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@Entity
@Table(name = "AccomodationType")
@JsonApiResource(type = "accomodationType")
@JsonIgnoreProperties("eventEntity")
public class AccomodationType {

	public Long getId() {
		return id;
	}

	@JsonApiId
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue
	private Long id;
	@JsonProperty
	private String name;

	@ManyToOne
	@JoinColumn
	private EventEntity eventEntity;

	public AccomodationType() {

	}

	public AccomodationType(String name) {
		this.name = name;
	}

	public AccomodationType(String name, EventEntity eventEntity) {
		this.name = name;
		this.eventEntity = eventEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventEntity getEventEntity() {
		return eventEntity;
	}

	public void setEventEntity(EventEntity eventEntity) {
		this.eventEntity = eventEntity;
	}

}
