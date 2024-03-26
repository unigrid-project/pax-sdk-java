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

import com.google.protobuf.util.JsonFormat;
import cosmos.auth.v1beta1.Auth;
import cosmos.bank.v1beta1.Tx;
import cosmos.crypto.secp256k1.Keys;
import cosmos.staking.v1beta1.Staking;
import cosmos.tx.v1beta1.TxOuterClass;
import ibc.lightclients.tendermint.v1.Tendermint;

public class JsonToProtoObjectUtil {

    private static final JsonFormat.TypeRegistry typeRegistry = getTypeRegistry();

    private static final JsonFormat.Parser parser = JsonFormat.parser().usingTypeRegistry(typeRegistry);

    private static final JsonFormat.Printer printer = JsonFormat.printer().usingTypeRegistry(typeRegistry);

    public static JsonFormat.TypeRegistry getTypeRegistry() {
        JsonFormat.TypeRegistry.Builder builder = JsonFormat.TypeRegistry.newBuilder();
        builder.add(cosmos.distribution.v1beta1.Tx.getDescriptor().getMessageTypes());
        builder.add(Tx.getDescriptor().getMessageTypes());
        builder.add(Keys.getDescriptor().getMessageTypes());
        builder.add(TxOuterClass.getDescriptor().getMessageTypes());
        builder.add(Auth.getDescriptor().getMessageTypes());
        builder.add(Staking.getDescriptor().getMessageTypes());
        builder.add(cosmos.staking.v1beta1.Tx.getDescriptor().getMessageTypes());
        builder.add(ibc.core.client.v1.Client.getDescriptor().getMessageTypes());
        builder.add(ibc.core.client.v1.Tx.getDescriptor().getMessageTypes());
        //builder.add(ibc.core.client.v1.QueryOuterClass.getDescriptor().getMessageTypes());
        builder.add(ibc.core.client.v1.Genesis.getDescriptor().getMessageTypes());
        builder.add(Tendermint.getDescriptor().getMessageTypes());
        //builder.add(ibc.lightclients.solomachine.v1.Solomachine.getDescriptor().getMessageTypes());
        builder.add(ibc.core.channel.v1.Tx.getDescriptor().getMessageTypes());
        builder.add(ibc.applications.transfer.v1.Tx.getDescriptor().getMessageTypes());
        builder.add(cosmos.gov.v1beta1.Tx.getDescriptor().getMessageTypes());
        builder.add(cosmos.crypto.multisig.Keys.getDescriptor().getMessageTypes());
        builder.add(cosmos.crypto.multisig.v1beta1.Multisig.getDescriptor().getMessageTypes());

        JsonFormat.TypeRegistry typeRegistry = builder.build();
        return typeRegistry;
    }

    public static JsonFormat.Parser getParser() {
        return parser;
    }

    public static JsonFormat.Printer getPrinter() {
        return printer;
    }
}
