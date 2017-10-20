package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stream.StreamImpl;

public class Tests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	static String strTest = "aAbBABicafeUFO";
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
    public void countShouldBeThree() {
		
		StreamImpl stream = new StreamImpl(strTest);
		
		int count=0;
		while(stream.hasNext()) {
			count++;
			stream.getNext();
		}
		
        assertEquals(3, count);
    }
	
	@Test
    public void showCorrectChars() {
		
		StreamImpl stream = new StreamImpl(strTest);

        assertEquals("i".charAt(0), stream.getNext());
        assertEquals("e".charAt(0), stream.getNext());
        assertEquals("O".charAt(0), stream.getNext());
    }
	
	@Test
    public void showFirstChar() {
        assertEquals("U".charAt(0), StreamImpl.firstChar("aTUtesate"));
    }
	
	@Test
    public void noTokenFound() {
		
		StreamImpl stream = new StreamImpl("aTUtesatU");
        stream.getNext();
        
        assertEquals("Nenhum token foi encontrado!", outContent.toString());
    }
}

