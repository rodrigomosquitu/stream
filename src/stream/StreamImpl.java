package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamImpl implements Stream {

	public static String PATTERN = "(?i)[aeiou](?!\\\\1)[b-df-hj-np-tv-z](?!\\\\1)([aeiou](?!\\\\1))";
	
	Matcher matcher;
	List<String> lista = new ArrayList<String>();
	int index = 0;
	
    public String testString;

	/**
	 * @param testString
	 */
	public StreamImpl(String testString) {
		super();
		this.testString = testString;
		
		initLista();
	}

	/**
	 * Identifica os tokens (vogal, consoante, vogal) e verifica se a última vogal é unica
	 */
	public void initLista() {
	    Pattern p = Pattern.compile(PATTERN);
	    matcher = p.matcher(testString);
	    
	    while (matcher.find()) {
	        String charTest = matcher.group().substring(matcher.group().length()-1);
	        int stringTokenizer = new StringTokenizer(" " + getTestString() + " ", charTest).countTokens()-1;
	        
            if (stringTokenizer == 1) 
            	lista.add(charTest);
	    }
    }
	
	@Override
	public char getNext() {
		if (lista.isEmpty()) {
			System.out.print("Nenhum token foi encontrado!");
			return "0".charAt(0);
		}
		else
			return lista.get(index++).charAt(0);
	}

	@Override
	public boolean hasNext() {
		return index != lista.size();
	}

	public static char firstChar(String input) {
		StreamImpl stream = new StreamImpl(input);
	    return stream.lista.get(0).charAt(0);
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}
}

