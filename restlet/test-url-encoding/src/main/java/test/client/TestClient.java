package test.client;

import org.restlet.data.Reference;
import org.restlet.resource.ClientResource;

public class TestClient {

	private static void test(){
	    
	    Reference ref = new Reference();
	    ref.setScheme("http");
	    ref.setHostDomain("localhost");
	    ref.setHostPort(8182);
	    ref.addSegment("test");
	    ref.addSegment("http://test");
	    System.out.println("URL = " + ref);
	    
	    ClientResource cr = new ClientResource(ref);
	    cr.get();
	}
	
	public static void main(String[] args) {
		test();
	}
}
