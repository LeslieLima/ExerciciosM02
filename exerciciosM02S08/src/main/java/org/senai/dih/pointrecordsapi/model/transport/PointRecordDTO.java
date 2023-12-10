package org.senai.dih.pointrecordsapi.model.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.senai.dih.pointrecordsapi.model.PointRecord;
import org.senai.dih.pointrecordsapi.model.enums.RegisterType;

import java.time.LocalDateTime;

public record PointRecordDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredAt, RegisterType type) {

    public PointRecordDTO(PointRecord pointRecord) {
        this(pointRecord.getId(), pointRecord.getRegisteredAt(), pointRecord.getType());
    }
}
