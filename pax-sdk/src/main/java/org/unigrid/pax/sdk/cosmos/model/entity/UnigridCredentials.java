package org.unigrid.pax.sdk.cosmos.model.entity;

import lombok.Getter;
import org.bitcoinj.core.ECKey;
import org.unigrid.pax.sdk.cosmos.utils.AddressUtil;

	
@Getter
public class UnigridCredentials {

    private ECKey ecKey;
    private String address;

    private UnigridCredentials() {

    }

    public static UnigridCredentials create(ECKey ecKey, String addressPrefix) {
	System.out.println("cosmos credentials started");
        UnigridCredentials credentials = new UnigridCredentials();
        credentials.ecKey = ecKey;
        credentials.address = AddressUtil.ecKeyToAddress(ecKey, addressPrefix);
        return credentials;
    }

    public static UnigridCredentials create(byte[] privateKey, String addressPrefix) {
        ECKey ecKey = ECKey.fromPrivate(privateKey);
        return create(ecKey, addressPrefix);
    }

}
