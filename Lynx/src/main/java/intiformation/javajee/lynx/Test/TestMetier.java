package intiformation.javajee.lynx.Test;

import static org.junit.Assert.*;

import java.util.Date;

import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.metier.InterfMetier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetier {

	private static ClassPathXmlApplicationContext context;
	private static InterfMetier metier;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterfMetier) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddClient() {
		Client c= new Client("nomClient", "prenomClient", new Date(), "adresseClient");
		metier.addClient(c);
		assertNotNull(c.getCodeClient());
	}

}
