package com.example.crnkdemosampleproject;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrnkdemosampleprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrnkdemosampleprojectApplication.class, args);
	}

	@Autowired
	private EventEntityRepository eventEntityRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		final EventEntity eventOne = new EventEntity("WellsFargo");
		List<AccomodationType> accomodationList = new ArrayList<>();
		accomodationList.add(new AccomodationType("seid", eventOne));
		accomodationList.add(new AccomodationType("mussie", eventOne));
		eventOne.setAccomodationTypeList(accomodationList);
		
		eventEntityRepository.save(eventOne);
	}

}
