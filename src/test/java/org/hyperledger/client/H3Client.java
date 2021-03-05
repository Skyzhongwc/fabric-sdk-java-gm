package org.hyperledger.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.security.CryptoSM;
import org.hyperledger.fabric.sdk.security.HLSDKJCryptoSuiteFactory;

public class H3Client {
    private static final Log logger = LogFactory.getLog(H3Client.class);

    public HFClient client;
    public HLSDKJCryptoSuiteFactory hlsdkjCryptoSuiteFactory = new HLSDKJCryptoSuiteFactory();
    public H3Client(String name, String mspID, String userCert, String userKey) throws Exception {
        logger.info("build new HFClient.");
        CryptoSM suite = new CryptoSM();      //载入国密密码学套件
        client = HFClient.createNewInstance();
        client.setCryptoSuite(hlsdkjCryptoSuiteFactory.getCryptoSuite(suite.getProperties()));
        //client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(new LocalUser(name, mspID, userKey, userCert));
    }

    public HFClient getClient() {
        return client;
    }

}
