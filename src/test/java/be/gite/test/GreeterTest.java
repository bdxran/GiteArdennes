package be.gite.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import be.gite.divers.Greeter;

public class GreeterTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

}