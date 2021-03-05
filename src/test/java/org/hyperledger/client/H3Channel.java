package org.hyperledger.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.sdk.BlockchainInfo;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;

import java.util.EnumSet;
import java.util.Properties;

public class H3Channel {
    private static final Log logger = LogFactory.getLog(H3Channel.class);

    private Channel channel;
    private HFClient client;
    private boolean enableServiceDiscover = false;

    public H3Channel(H3Client client, String channelName) throws InvalidArgumentException {
        this.client = client.getClient();
        this.channel = this.client.newChannel(channelName);
    }

    public Channel getChannel() {
        return channel;
    }

    public void init() throws Exception {
        channel.initialize();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (!channel.isShutdown()) {
            channel.shutdown(true);
        }
    }

    public void addPeer(String hostName, String grpcURL) throws Exception {
        Peer peer = client.newPeer(hostName, grpcURL);
        channel.addPeer(peer);
    }

    public void addPeer(String hostName, String grpcURL, Properties properties) throws Exception {
        Peer peer = client.newPeer(hostName, grpcURL, properties);
        channel.addPeer(peer);
    }

    public void addPeer(String hostName, String grpcURL, Properties properties, boolean enableServiceDiscover) throws Exception {
        Peer peer = client.newPeer(hostName, grpcURL, properties);
        this.enableServiceDiscover = enableServiceDiscover;
        if (this.enableServiceDiscover) {
            channel.addPeer(peer, Channel.PeerOptions.createPeerOptions().setPeerRoles(EnumSet.of(Peer.PeerRole.SERVICE_DISCOVERY, Peer.PeerRole.LEDGER_QUERY, Peer.PeerRole.EVENT_SOURCE, Peer.PeerRole.CHAINCODE_QUERY)));
        } else {
            channel.addPeer(peer);
        }
    }

    public long queryBlockHeight() throws Exception {
        Peer[] peers = getChannel().getPeers().toArray(new Peer[0]);
        if (peers.length == 0) {
            logger.info("节点长度为0");
            return 0;
        }

        Channel channel = this.getChannel();

        BlockchainInfo blockchainInfo = channel.queryBlockchainInfo(peers[0]);

        return blockchainInfo.getHeight();
    }


}
