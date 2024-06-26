/*
	The Janus Wallet
	Copyright © 2021-2022 The Unigrid Foundation, UGD Software AB

	This program is free software: you can redistribute it and/or modify it under the terms of the
	addended GNU Affero General Public License as published by the Free Software Foundation, version 3
	of the License (see COPYING and COPYING.addendum).

	This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
	even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	GNU Affero General Public License for more details.

	You should have received an addended copy of the GNU Affero General Public License with this program.
	If not, see <http://www.gnu.org/licenses/> and <https://github.com/unigrid-project/janus-java>.
 */
package org.unigrid.pax.sdk.cosmos.model;

import lombok.Getter;

public class ApiConfig {
	@Getter
	//private static final String BASE_URL = "https://rest-testnet.unigrid.org/";
	private static final String BASE_URL = "https://rest-devnet.unigrid.org/";
	@Getter
	private static final String CHAIN_ID = "unigrid-devnet-2";
	@Getter
	private static final String GRPC_IP = "173.212.208.212";
	@Getter
	private static final String DENOM = "uugd";
	@Getter
	static final String UUGD_VALUE = "100000000";
}
