package com.resimanager.backoffice.persistance.repository;

import com.resimanager.backoffice.persistance.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

