package brugerautorisation.transport.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Connection {
	

	URL url;
	QName qName;
	Service service;
	Brugeradmin ba;

	public Connection(){
		
	}
	
	public void getUser(String username, String password) throws MalformedURLException{
		this.url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
		this.qName = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
		this.service = Service.create(url, qName);
		ba = service.getPort(Brugeradmin.class);
		ba.hentBruger(username, password);
	}
	
}
