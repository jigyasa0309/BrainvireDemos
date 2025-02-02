package com.adminSystem.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.ExceptionMapperStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminSystem.entity.OTSEntity;
import com.adminSystem.repository.OTSRepository;

@Service
public class OTSService {
	@Autowired
	private OTSRepository otsRepository;

	public List<OTSEntity> getAllEntries() {
		return otsRepository.findAll();
	}

	public OTSEntity addOTSRecord(OTSEntity otsEntity) {
		System.out.println("hello");
		System.out.println(otsEntity);
		return otsRepository.save(otsEntity);
	}

	public OTSEntity updateOTSRecord(Long id, OTSEntity updatedEntity) {

		Optional<OTSEntity> optionalRecord = otsRepository.findById(id);
		if (optionalRecord.isPresent()) {
			OTSEntity existingRecord = optionalRecord.get();

			existingRecord.setAccounts(updatedEntity.getAccounts());
			existingRecord.setCustomerName(updatedEntity.getCustomerName());
			existingRecord.setOtsAmount(updatedEntity.getOtsAmount());
			existingRecord.setSanctionDate(updatedEntity.getSanctionDate());
			existingRecord.setExpiryDate(updatedEntity.getExpiryDate());

			existingRecord.setUpdatedBy(updatedEntity.getUpdatedBy());
			existingRecord.setCreationTime(updatedEntity.getCreationTime());
			
			return otsRepository.save(existingRecord);
		} else {
			// Handle the case where the record with the given id is not found
			throw new RuntimeException("Record not found with id: " + id);
		}
	}

	public void deleteOTSRecord(Long id) {
				if (otsRepository.existsById(id)) {
			
			otsRepository.deleteById(id);
		} else {
			// Handle the case where the record with the given id is not found
			throw new RuntimeException("Record not found with id: " + id);
		}
	}

	public OTSEntity getEntryById(Long id) {
		OTSEntity ots = otsRepository.getById(id);
		

		return ots;
	}

}
