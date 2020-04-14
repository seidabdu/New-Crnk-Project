package com.example.crnkdemosampleproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
//		final EventEntity eventOne = new EventEntity("WellsFargo");
//		List<AccomodationType> accomodationList = new ArrayList<>();
//		accomodationList.add(new AccomodationType("seid", eventOne));
//		accomodationList.add(new AccomodationType("mussie", eventOne));
//		eventOne.setAccomodationTypeList(accomodationList);
//		
//		eventEntityRepository.save(eventOne);
		 LocalDate localDate = LocalDate.now();
		 System.out.println("-------------------------   "+localDate.toString()+"--------------------------");
		 LocalDateTime localDateTime = LocalDateTime.now();
		 System.out.println("-------------------------   "+localDateTime.toString()+"--------------------------");
		 
		 
		 
		//Create formatter
		 DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		          
		 //Local date instance
		 LocalDate localDateNEw = LocalDate.now();
		  
		 //Get formatted String
		 String dateString = FOMATTER.format(localDateNEw);
		  
		 System.out.println(dateString);     //07/15/2018
		 
		 
	}

}
