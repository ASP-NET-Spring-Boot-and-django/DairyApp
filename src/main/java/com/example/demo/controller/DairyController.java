package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dairy;
import com.example.demo.repository.DairyRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/dairy")
public class DairyController {	
		
	 @Autowired
	    private DairyRepository dairyRepository;

	    // GET all dairy entries
	    @GetMapping("/all")
	    public List<Dairy> getAllDairyEntries() {
	        return dairyRepository.findAll();
	    }

	    // GET a specific dairy entry by ID
	    @GetMapping("/{id}")
	    public Dairy getDairyById(@PathVariable Long id) {
	        Optional<Dairy> dairy = dairyRepository.findById(id);
	        return dairy.orElse(null);  // return the dairy entry if present, otherwise return null
	    }

	    // POST a new dairy entry
	    @PostMapping("/create")
	    public Dairy createDairyEntry(@RequestBody Dairy dairy) {
	        return dairyRepository.save(dairy);
	    }

	    // DELETE a dairy entry by ID
	    @DeleteMapping("/delete/{id}")
	    public String deleteDairyById(@PathVariable Long id) {
	        if (dairyRepository.existsById(id)) {
	            dairyRepository.deleteById(id);
	            return "Dairy entry deleted with ID: " + id;
	        } else {
	            return "Dairy entry not found with ID: " + id;
	      }
	    }
	
}

