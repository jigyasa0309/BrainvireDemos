package com.adminSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adminSystem.entity.OTSEntity;
import com.adminSystem.service.OTSService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class DashboardController {
	@Autowired
	private OTSService otsService;

	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		log.info("moving in the dashboard");
		List<OTSEntity> entries = otsService.getAllEntries();
		model.addAttribute("entries", entries);
		return "dashboard";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		log.info("moving in the edit ");
		OTSEntity entry = otsService.getEntryById(id);
		model.addAttribute("entry", entry);
		return "edit-entry";
	}

	@PostMapping("/ots/update/{id}")
	public String updateEntry(@PathVariable("id") Long id, @ModelAttribute OTSEntity updatedEntity) {
		log.info("moving to update");
		otsService.updateOTSRecord(id, updatedEntity);
		return "redirect:/dashboard";
	}

	@GetMapping("/ots/add")
	public String showAddForm(Model model) {
		OTSEntity newEntry = new OTSEntity();
		model.addAttribute("entry", newEntry);
		return "add-entry";
	}

	@PostMapping("/ots/add")
	public String addOTSRecord(@ModelAttribute OTSEntity otsEntity) {
		otsService.addOTSRecord(otsEntity);
		return "redirect:/dashboard";
	}

	@PostMapping("ots/delete/{id}")
	public ResponseEntity<Void> deleteOTSRecord(@PathVariable Long id) {
		otsService.deleteOTSRecord(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
