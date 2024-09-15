package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Dairy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
	private Long id;
	private String dairyText;
	private LocalDate writtenDate;
	public Dairy() {
		
	}
	public Dairy(String dairyText,LocalDate writtenDate) 
	{
		this.setDairyText(dairyText);
		this.setWrittenDate(writtenDate);
	}
    public Long getId() {
        return id;
    }

	public LocalDate getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(LocalDate writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getDairyText() {
		return dairyText;
	}
	public void setDairyText(String dairyText) {
		this.dairyText = dairyText;
	}
}
