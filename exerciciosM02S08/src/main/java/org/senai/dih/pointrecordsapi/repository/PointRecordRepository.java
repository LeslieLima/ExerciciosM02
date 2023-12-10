package org.senai.dih.pointrecordsapi.repository;

import org.senai.dih.pointrecordsapi.model.PointRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRecordRepository extends JpaRepository<PointRecord, Long> {
}
