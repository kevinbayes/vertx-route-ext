package me.bayes.vertx.vest.jaxrs;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import me.bayes.vertx.vest.jaxrs.VestApplication;
import me.bayes.vertx.vest.jaxrs.sample.PingEndpoint;
import me.bayes.vertx.vest.jaxrs.sample.other.OtherEndpoint;

import org.junit.Test;

public class TestVertxApplication {

	@Test
	public void testGivenPackageToScanOneClassFound() {
		//Given
		VestApplication application = new VestApplication() {
		};
		Set<String> packages = new HashSet<String>(1);
		packages.add("me.bayes.vertx.vest.jaxrs.sample");
		
		//When
		application.addPackagesToScan(packages);
		
		//Then
		assertTrue(application.getClasses().size() == 1);
		assertTrue(application.getClasses().contains(PingEndpoint.class));
	}
	
	@Test
	public void testGivenOneClassOneClassFound() {
		//Given
		VestApplication application = new VestApplication() {
		};
		
		//When
		application.addEndpointClasses(me.bayes.vertx.vest.jaxrs.sample.PingEndpoint.class);
		
		//Then
		assertTrue(application.getClasses().size() == 1);
		assertTrue(application.getClasses().contains(PingEndpoint.class));
	}
	
	
	@Test
	public void testGivenOnceClassAndOnePackageTwoClassFound() {
		//Given
		VestApplication application = new VestApplication() {
		};
		Set<String> packages = new HashSet<String>(1);
		packages.add("me.bayes.vertx.vest.jaxrs.sample.other");
		
		//When
		application.addPackagesToScan(packages);
		application.addEndpointClasses(me.bayes.vertx.vest.jaxrs.sample.PingEndpoint.class);
		
		//Then
		assertTrue(application.getClasses().size() == 2);
		assertTrue(application.getClasses().contains(PingEndpoint.class));
		assertTrue(application.getClasses().contains(OtherEndpoint.class));
	}

}