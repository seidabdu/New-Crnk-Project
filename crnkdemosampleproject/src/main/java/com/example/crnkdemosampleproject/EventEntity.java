package com.example.crnkdemosampleproject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@Entity
@Table(name = "Event")
@JsonApiResource(type = "events")
@JsonIgnoreProperties("accomodationTypeList")
public class EventEntity {
	public Long getId() {
		return id;
	}

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

	@JsonProperty
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "eventEntity", cascade = CascadeType.ALL)
	private List<AccomodationType> accomodationTypeList;

	public EventEntity() {

	}

	public EventEntity(String name) {

		this.name = name;

	}

	public String getName() {
		return name;
	}

	public List<AccomodationType> getAccomodationTypeList() {
		return accomodationTypeList;
	}

	public void setAccomodationTypeList(List<AccomodationType> accomodationTypeList) {
		this.accomodationTypeList = accomodationTypeList;
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
