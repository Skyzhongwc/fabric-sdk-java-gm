package org.hyperledger.client;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoPrimitives;
import org.hyperledger.fabric.sdk.security.CryptoSM;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;
import java.util.Set;

public class LocalUser implements User {
    private boolean TLS_ENABLE = true;
    private String name;
    private String mspID;
    private Enrollment enrollment;

    /**
     * @param name     用户名
     * @param mspID    组织ID
     * @param keyFile  私钥内容字符串
     * @param certFile 证书内容字符串
     * @throws Exception
     */
    public LocalUser(String name, String mspID, String keyFile, String certFile) throws Exception {
        this.name = name;
        this.mspID = mspID;
        this.enrollment = loadPemFile(keyFile, certFile);
    }

    /**
     * @param name
     * @param mspID
     * @param keyFilePath  私钥路径
     * @param certFilePath 证书路径
     * @throws Exception
     */
    public LocalUser(String name, String mspID, Path keyFilePath, Path certFilePath) throws Exception {
        this.name = name;
        this.mspID = mspID;
        this.enrollment = loadFromPemFile(keyFilePath, certFilePath);

        if (TLS_ENABLE == true) {

        }
    }

    // 国密密码学套件
    public static Enrollment loadPemFile(String keyFile, String certFile) throws Exception {
        byte[] keyPem = keyFile.getBytes();  //载入私钥
        String certPem = certFile;      //载入证书PEM文本
        CryptoSM suite = new CryptoSM();      //载入国密密码学套件
        PrivateKey privateKey = suite.bytesToPrivateKey(keyPem);  //将PEM文本转换为私钥对象
        return new X509Enrollment(privateKey, certPem);       //创建并返回X509Enrollment对象
    }

    public static Enrollment loadFromPemFile(String keyFile, String certFile) throws Exception {
        byte[] keyPem = keyFile.getBytes();  //载入私钥
        String certPem = certFile;      //载入证书PEM文本
        CryptoPrimitives suite = new CryptoPrimitives();      //载入密码学套件
        PrivateKey privateKey = suite.bytesToPrivateKey(keyPem);  //将PEM文本转换为私钥对象
        return new X509Enrollment(privateKey, certPem);       //创建并返回X509Enrollment对象
    }

    public static Enrollment loadFromPemFile(Path keyFilePath, Path certFilePath) throws Exception {
        byte[] keyPem = Files.readAllBytes(keyFilePath);        //载入私钥PEM文件
        byte[] certPem = Files.readAllBytes(certFilePath);  //载入证书PEM文本
        CryptoPrimitives suite = new CryptoPrimitives();         //载入密码学套件
        PrivateKey privateKey = suite.bytesToPrivateKey(keyPem);     //将PEM文本转换为私钥对象
        return new X509Enrollment(privateKey, new String(certPem));  //创建并返回X509Enrollment对象
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMspId() {
        return mspID;
    }

    @Override
    public Enrollment getEnrollment() {
        return enrollment;
    }

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public String getAffiliation() {
        return null;
    }

    @Override
    public Set<String> getRoles() {
        return null;
    }


    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }
}
