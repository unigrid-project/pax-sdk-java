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

package org.unigrid.pax.sdk.cosmos;

import cosmos.base.abci.v1beta1.Abci;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import org.bouncycastle.util.encoders.Hex;
import org.unigrid.pax.sdk.cosmos.model.SendInfo;

@ApplicationScoped
public class UnigridChainCommands {
	@Inject
	private UnigridService unigridService;

	public void sendTokens(String privateKeyHex, String toAddress, String fromAddress) throws Exception {
		byte[] privateKey = Hex.decode(privateKeyHex);
		UnigridCredentials credentials = UnigridCredentials.create(privateKey, "unigrid");


		SignUtil transactionService = unigridService.createSignUtilService(fromAddress);
		long amountInUugd = unigridService.convertBigDecimalInUugd(Double.parseDouble("100.00"));

		System.out.println("amount in uugd: " + amountInUugd);

		SendInfo sendMsg = SendInfo.builder()
			.credentials(credentials)
			.toAddress(toAddress)
			.amountInAtom(amountInUugd)
			.build();

		Abci.TxResponse txResponse = transactionService.sendTx(credentials, sendMsg, new BigDecimal("0.000001"), 200000);
		System.out.println("RESPONSE");
		System.out.println(txResponse);

	}
}
