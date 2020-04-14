package com.example.crnkdemosampleproject;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue
	private Long id;

	@Column
	@JsonProperty
	private String name;

	@JsonProperty
	private LocalDate createdDate;
	
	@JsonProperty
	private LocalDateTime submittedTimeStamp;
	
	@JsonProperty
	private Timestamp effectifeDate;
	 

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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getSubmittedTimeStamp() {
		return submittedTimeStamp;
	}

	public void setSubmittedTimeStamp(LocalDateTime submittedTimeStamp) {
		this.submittedTimeStamp = submittedTimeStamp;
	}

	public Timestamp getEffectifeDate() {
		return effectifeDate;
	}

	public void setEffectifeDate(Timestamp effectifeDate) {
		this.effectifeDate = effectifeDate;
	}
	
	
	

}
