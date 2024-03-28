package org.unigrid.pax.sdk.cosmos.model.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnbondingEntryDTO {
    private String account;
    private long amount;
    private long completionTime;
}
