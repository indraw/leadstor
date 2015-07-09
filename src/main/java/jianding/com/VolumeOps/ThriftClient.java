package jianding.com.VolumeOps;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.springframework.stereotype.Service;

@Service
public class ThriftClient {
	  static int volnum = 0;
	  public int createVolume() {
		  CreateVolumeArgs cva = new CreateVolumeArgs();
		  cva.setVolumeName("testv" +  volnum++);
		  try {
			  return createVolume(cva);
		  } catch (Exception ex) {
			  ex.printStackTrace();
			  return (-1);
		  }
	  }
	  public int createVolume(CreateVolumeArgs cva) {
		String args[]={"simple","haha"};
	    try {
	      TTransport transport;
	      if (args[0].contains("simple")) {
	        transport = new TSocket("localhost", 9090); // we assume server running at port 9090
	        transport.open();
	      }
	      else {
	        /*
	         * Similar to the server, you can use the parameters to setup client parameters or
	         * use the default settings. On the client side, you will need a TrustStore which
	         * contains the trusted certificate along with the public key. 
	         * For this example it's a self-signed cert. 
	         */
	        TSSLTransportParameters params = new TSSLTransportParameters();
	        params.setTrustStore("../../lib/java/test/.truststore", "thrift", "SunX509", "JKS");
	        /*
	         * Get a client transport instead of a server transport. The connection is opened on
	         * invocation of the factory method, no need to specifically call open()
	         */
	        transport = TSSLTransportFactory.getClientSocket("localhost", 9091, 0, params);
	      }

	      TProtocol protocol = new  TBinaryProtocol(transport);
	      VolumeOps.Client client = new VolumeOps.Client(protocol);
	      System.out.println("started to create volume");
	      int retv = client.CreateVolume(cva);
	      transport.close();
	      return (retv);
	    } catch (TException x) {
	      x.printStackTrace();
	      return (-1);
	    } 
	  }
}
