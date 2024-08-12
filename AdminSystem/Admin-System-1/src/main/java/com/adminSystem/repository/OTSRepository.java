package com.adminSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminSystem.entity.OTSEntity;

@Repository
public interface OTSRepository extends JpaRepository<OTSEntity, Long> {

}
