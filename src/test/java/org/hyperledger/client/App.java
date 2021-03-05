package org.hyperledger.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;

/**
 * @ClassName: App
 * @Description:
 * @Author: zhongwanchun
 * @Date: 2021/3/1 10:10
 */
public class App {
    private static final Log logger = LogFactory.getLog(App.class);

    public static void main(String[] args) {

//        String keyFile = "-----BEGIN PRIVATE KEY-----\n" +
//                "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgoxiFntN4+xHyn7qC\n" +
//                "kuhknL6hF8/29t1P2/BVm7ZaIFyhRANCAAQFotOS9aUe0MH+WB71NsPOppP85IWe\n" +
//                "GUBn7/bNCG9LC6Jw+lO3AtpEBCdCFSRd1BpQZg99hzzjY8PNMk+mLjan\n" +
//                "-----END PRIVATE KEY-----";
//        String certFile = "-----BEGIN CERTIFICATE-----\n" +
//                "MIICBTCCAaugAwIBAgIQOEKXGqZY+/AKgRg3np7QVDAKBggqhkjOPQQDAjBbMQsw\n" +
//                "CQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNU2FuIEZy\n" +
//                "YW5jaXNjbzENMAsGA1UEChMEb3JnMTEQMA4GA1UEAxMHY2Eub3JnMTAeFw0yMDA4\n" +
//                "MDUwOTE2MDBaFw0zMDA4MDMwOTE2MDBaMF8xCzAJBgNVBAYTAlVTMRMwEQYDVQQI\n" +
//                "EwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1TYW4gRnJhbmNpc2NvMQ4wDAYDVQQLEwVh\n" +
//                "ZG1pbjETMBEGA1UEAwwKQWRtaW5Ab3JnMTBZMBMGByqGSM49AgEGCCqGSM49AwEH\n" +
//                "A0IABAWi05L1pR7Qwf5YHvU2w86mk/zkhZ4ZQGfv9s0Ib0sLonD6U7cC2kQEJ0IV\n" +
//                "JF3UGlBmD32HPONjw80yT6YuNqejTTBLMA4GA1UdDwEB/wQEAwIHgDAMBgNVHRMB\n" +
//                "Af8EAjAAMCsGA1UdIwQkMCKAIFDRw/lAelSe6DYyl79LxtRiVYW6jiy35j6/V16Z\n" +
//                "gDLMMAoGCCqGSM49BAMCA0gAMEUCIQCFdQ5Fqqgr5mjewmuSmPaByLfWHOHmyiVr\n" +
//                "8n1nkRyBWgIgawT/VvqZPDBB2srFYQvylHXCAjqXVKcVpsysw/49B5w=\n" +
//                "-----END CERTIFICATE-----";
//        String tlsCert = "-----BEGIN CERTIFICATE-----\n" +
//                "MIICNzCCAd6gAwIBAgIRAMjFkOmocDiPqvhjyfh5dY8wCgYIKoZIzj0EAwIwXjEL\n" +
//                "MAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExFjAUBgNVBAcTDVNhbiBG\n" +
//                "cmFuY2lzY28xDTALBgNVBAoTBG9yZzExEzARBgNVBAMTCnRsc2NhLm9yZzEwHhcN\n" +
//                "MjAwODA1MDkxNjAwWhcNMzAwODAzMDkxNjAwWjBPMQswCQYDVQQGEwJVUzETMBEG\n" +
//                "A1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNU2FuIEZyYW5jaXNjbzETMBEGA1UE\n" +
//                "AxMKcGVlcjAtb3JnMTBZMBMGByqGSM49AgEGCCqGSM49AwEHA0IABL8kpbDIFZpx\n" +
//                "KYG6R4PgNCwvNGFYlNUjWI3sFHK+q1Bb1AzWAfiaZwZrQrPsM+0dtiPddeEUtztl\n" +
//                "j9c/1Fc+vjCjgYswgYgwDgYDVR0PAQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUF\n" +
//                "BwMBBggrBgEFBQcDAjAMBgNVHRMBAf8EAjAAMCsGA1UdIwQkMCKAIAg4xbN/WWl6\n" +
//                "EnPvshjJrxXzhwoDbKHbzNtgsWAtFgzJMBwGA1UdEQQVMBOCCnBlZXIwLW9yZzGC\n" +
//                "BXBlZXIwMAoGCCqGSM49BAMCA0cAMEQCICyvqWFGRQ5UuZH7hwbjVLewsd8TgPOP\n" +
//                "EGcUTIKZZVlJAiAC1h1I5odRz/eXWuh0V9hs8D0+G5lErUxBJ9C7U2zCTQ==\n" +
//                "-----END CERTIFICATE-----";
//        String mspID = "Org1MSP";
//        String channelName = "baaschannel";
//        String hostName = "peer0-org1";
//        String grpcURL = "grpcs://192.169.0.140:30010";

        String keyFile = "-----BEGIN PRIVATE KEY-----\n" +
                "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgpUZBIDbdgYhHXPy+\n" +
                "l76KBwQoNIuU3dpmJtr0mp+zd/CgCgYIKoEcz1UBgi2hRANCAAQkSYw443IrGl68\n" +
                "7ZMeyPVfePArd5VGjpfJrP4TLXzmB/iKa6WzKjF0UQCW2gaArUSh/Ld3n4U2OncJ\n" +
                "WIGWIHTh\n" +
                "-----END PRIVATE KEY-----\n";
        String certFile = "-----BEGIN CERTIFICATE-----\n" +
                "MIICKzCCAdCgAwIBAgIQJAGtb6crXZiUpL4AfsyYRDAKBggqgRzPVQGDdTBzMQsw\n" +
                "CQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNU2FuIEZy\n" +
                "YW5jaXNjbzEZMBcGA1UEChMQb3JnMS5leGFtcGxlLmNvbTEcMBoGA1UEAxMTY2Eu\n" +
                "b3JnMS5leGFtcGxlLmNvbTAeFw0yMTAxMjgwODEyMDBaFw0zMTAxMjYwODEyMDBa\n" +
                "MGwxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1T\n" +
                "YW4gRnJhbmNpc2NvMQ8wDQYDVQQLEwZjbGllbnQxHzAdBgNVBAMMFkFkbWluQG9y\n" +
                "ZzEuZXhhbXBsZS5jb20wWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAQkSYw443Ir\n" +
                "Gl687ZMeyPVfePArd5VGjpfJrP4TLXzmB/iKa6WzKjF0UQCW2gaArUSh/Ld3n4U2\n" +
                "OncJWIGWIHTho00wSzAOBgNVHQ8BAf8EBAMCB4AwDAYDVR0TAQH/BAIwADArBgNV\n" +
                "HSMEJDAigCBJItBp1oIuODhJh2YFj36DS5aA1LjcPqh/IUSXQb+3NTAKBggqgRzP\n" +
                "VQGDdQNJADBGAiEAmayr24p2WGVktfKp/4L5m3XvM5mkcg63QIkpiPgFbmECIQCr\n" +
                "TO9+Swy7U85k5fuUaF+ECSv8R62w1Y8sJVrYdRYs3Q==\n" +
                "-----END CERTIFICATE-----";
        String tlsCert = "-----BEGIN CERTIFICATE-----\n" +
                "MIICaDCCAg6gAwIBAgIRAKlJ1WO5qLR8cAyZOrxeV1MwCgYIKoEcz1UBg3UwdjEL\n" +
                "MAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExFjAUBgNVBAcTDVNhbiBG\n" +
                "cmFuY2lzY28xGTAXBgNVBAoTEG9yZzEuZXhhbXBsZS5jb20xHzAdBgNVBAMTFnRs\n" +
                "c2NhLm9yZzEuZXhhbXBsZS5jb20wHhcNMjEwMTI4MDgxMjAwWhcNMzEwMTI2MDgx\n" +
                "MjAwWjBbMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UE\n" +
                "BxMNU2FuIEZyYW5jaXNjbzEfMB0GA1UEAxMWcGVlcjAub3JnMS5leGFtcGxlLmNv\n" +
                "bTBZMBMGByqGSM49AgEGCCqBHM9VAYItA0IABJtT+tEoKSlxIKg+LNOSiugG0Zxx\n" +
                "qEmq4HdEwImUbI0nO4AbtHprOhFqYdnqP2lo2oRRRgKviKiAOz5XKhEYHLKjgZcw\n" +
                "gZQwDgYDVR0PAQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcD\n" +
                "AjAMBgNVHRMBAf8EAjAAMCsGA1UdIwQkMCKAID6EknAv5lydfkw8QuAmNoRthJ8Y\n" +
                "gGayqc1hNlvj3i8YMCgGA1UdEQQhMB+CFnBlZXIwLm9yZzEuZXhhbXBsZS5jb22C\n" +
                "BXBlZXIwMAoGCCqBHM9VAYN1A0gAMEUCIQDpk8DMnI/xFI4L8XFD9aQckbErQDEO\n" +
                "xDY7M8L16j6ZxAIgZCEn0wI9g8+REH3ItdITkyFkAmuQjTZdp1sfD6M/x6I=\n" +
                "-----END CERTIFICATE-----";
        String mspID = "Org1MSP";
        String channelName = "mychannel";
        String hostName = "peer0.org1.example.com";
        String grpcURL = "grpcs://192.169.0.112:7051";

        long amount = 0;
        try {
            H3Client client = new H3Client("admin", mspID, certFile, keyFile);
            H3Channel channel = new H3Channel(client, channelName);
            Properties proper = Config.loadTLS(tlsCert.getBytes(), hostName);
            channel.addPeer(hostName, grpcURL, proper);
            channel.init();
            amount = channel.queryBlockHeight();
        } catch (Exception e) {
            logger.error("err: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("区块高度: " + amount);
    }
}

