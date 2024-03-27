package org.unigrid.pax.sdk.cosmos.model.transaction;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Body {
	private List<GridnodeMessage> messages;
	private String memo;
	private String timeoutHeight;
	// ... other fields
}