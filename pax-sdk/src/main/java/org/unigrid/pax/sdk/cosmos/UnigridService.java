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

import com.google.protobuf.Any;
import cosmos.auth.v1beta1.Auth;
import cosmos.auth.v1beta1.QueryOuterClass;
import jakarta.inject.Inject;
import org.unigrid.pax.sdk.cosmos.model.ApiConfig;

public class UnigridService {

	@Inject
	private GrpcService grpcService;

	public SignUtil createSignUtilService(String address) {
		long sequence = getSequence(address);
		long accountNumber = getAccountNumber(address);
		SignUtil transactionService = new SignUtil(grpcService, sequence, accountNumber, ApiConfig.getDENOM(), ApiConfig.getCHAIN_ID());

		return transactionService;
	}

	private long getSequence(String address) {
		// Set up the auth query client
		cosmos.auth.v1beta1.QueryGrpc.QueryBlockingStub authQueryClient = cosmos.auth.v1beta1.QueryGrpc
			.newBlockingStub(grpcService.getChannel());

		// Prepare the account query request
		QueryOuterClass.QueryAccountRequest accountRequest = QueryOuterClass.QueryAccountRequest.newBuilder()
			.setAddress(address)
			.build();

		try {
			// Query the account information
			QueryOuterClass.QueryAccountResponse response = authQueryClient.account(accountRequest);

			Any accountAny = response.getAccount();
			Auth.BaseAccount baseAccount = accountAny.unpack(Auth.BaseAccount.class);
			// Process baseAccount as needed
			System.out.println("SEQUENCE NUMBER: " + baseAccount.getSequence());
			return baseAccount.getSequence();

		} catch (Exception e) {
			// Handle exceptions (e.g., account not found, gRPC errors, unpacking errors)
			e.printStackTrace();
			return -1; // or handle it as per your application's requirement
		}

	}

	public long getAccountNumber(String address) {
		cosmos.auth.v1beta1.QueryGrpc.QueryBlockingStub authQueryClient = cosmos.auth.v1beta1.QueryGrpc
			.newBlockingStub(grpcService.getChannel());
		QueryOuterClass.QueryAccountRequest accountRequest = QueryOuterClass.QueryAccountRequest.newBuilder().setAddress(address).build();

		try {
			QueryOuterClass.QueryAccountResponse response = authQueryClient.account(accountRequest);
			Any accountAny = response.getAccount();
			System.out.println("Type URL in getAccountNumber: " + accountAny.getTypeUrl());
			Auth.BaseAccount baseAccount = accountAny.unpack(Auth.BaseAccount.class);
			System.out.println("baseAccount.getPubKey(): " + baseAccount.getPubKey()
				+ " \naddress :" + baseAccount.getAddress());

			// Process baseAccount as needed
			// we need the account number and not the sequence here
			System.out.println("ACCOUNT NUMBER: " + baseAccount.getAccountNumber());
			return baseAccount.getAccountNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Handle this as per your application's requirement
		}
	}

	public long convertBigDecimalInUugd(double amount) {
		double conversionFactor = 100000000.0;
		double result = amount * conversionFactor;
		return (long) result;
	}

}