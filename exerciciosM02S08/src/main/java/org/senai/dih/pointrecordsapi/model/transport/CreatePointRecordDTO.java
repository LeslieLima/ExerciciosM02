package org.senai.dih.pointrecordsapi.model.transport;

import jakarta.validation.constraints.NotNull;
import org.senai.dih.pointrecordsapi.model.enums.RegisterType;

public record CreatePointRecordDTO(@NotNull RegisterType type) {
}
