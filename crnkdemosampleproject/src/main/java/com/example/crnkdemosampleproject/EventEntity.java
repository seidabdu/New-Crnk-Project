package com.example.crnkdemosampleproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;

@Entity
@Table(name = "Event")
@JsonApiResource(type = "events")
public class EventEntity {
	@JsonApiId
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@JsonProperty
	private String name;

	@Column
	@JsonProperty
	private String address;

	public EventEntity() {

	}

	public EventEntity(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
