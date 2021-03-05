package org.hyperledger.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    public static String Crypto_Config_Path = "D:\\prj\\crypto-config_vm\\";

    public static String adminKeyFile = Crypto_Config_Path + "peerOrganizations\\" +
            "org1.example.com\\users\\Admin@org1.example.com\\msp\\keystore\\a4da90157e7c5e747d2c98b9320990821d53565bfe3877aa3b31d9c15c7e61bb_sk";

    public static String adminCertFile = Crypto_Config_Path + "peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\" +
            "msp\\signcerts\\Admin@org1.example.com-cert.pem";

    public static void setCrypto_Config_Path(String crypto_Config_Path) {
        Crypto_Config_Path = crypto_Config_Path;
    }

    public static void setAdminKeyFile(String adminKeyFile) {
        Config.adminKeyFile = Paths.get(Crypto_Config_Path, adminKeyFile).toString();
    }

    public static void setAdminCertFile(String adminCertFile) {
        Config.adminCertFile = Paths.get(Crypto_Config_Path, adminCertFile).toString();
    }

    /**
     * 为Fabric网络中节点配置TLS根证书
     *
     * @param rootTLSCertPath 根证书路径
     * @param hostName        节点域名
     * @return
     * @throws IOException
     */
    public static Properties loadTLSFile(String rootTLSCertPath, String hostName) throws IOException {
        Properties properties = new Properties();
        properties.put("pemBytes", Files.readAllBytes(Paths.get(Crypto_Config_Path + rootTLSCertPath)));
        properties.setProperty("sslProvider", "openSSL");
        properties.setProperty("negotiationType", "TLS");
        properties.setProperty("trustServerCertificate", "true");
        properties.setProperty("hostnameOverride", hostName);
        return properties;
    }

    /**
     * 为Fabric网络中节点配置TLS根证书
     *
     * @param tlsCert  根证书pem 字节
     * @param hostName 节点域名
     * @return properties 键值对
     * @throws IOException
     */
    public static Properties loadTLS(byte[] tlsCert, String hostName) throws IOException {
        Properties properties = new Properties();
        properties.put("pemBytes", tlsCert);
        properties.setProperty("sslProvider", "openSSL");
        properties.setProperty("negotiationType", "TLS");
        properties.setProperty("trustServerCertificate", "true");
        properties.setProperty("hostnameOverride", hostName);
        return properties;
    }
}
