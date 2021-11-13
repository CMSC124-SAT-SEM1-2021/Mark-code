import java.io.*;
import java.util.LinkedList;

public class lex {
	static char[]lexemeArray = new char [10];
	static int lexCount =0;
	static String tokenx = null;
	static LinkedList<String> lexemeCont = new LinkedList<String>();
	static int llcount = 0;
	
	
	public static void main (String[] args) throws Throwable  {
		lexemeCont.addFirst("LEXEME    "+ " - " + "TOKEN" );
		llcount++;
		getChar();
		
		for(int i = 0; i<llcount; i++) {
			String lexeme = lexemeCont.removeLast();
			
			if(!lexeme.endsWith("EOF")) {
				System.out.println(lexeme);
			} else {
				System.out.println(lexeme);
				System.out.println("\n"+"Invalid input!");
				break;
			}
		}
		
		
	}

	public static String getChar () throws Throwable {
		
        File file = new File( "C:\\Users\\ctian\\Desktop\\test.txt");			//path of files
		BufferedReader br = new BufferedReader(new FileReader(file));				//Reader
		
		int x; 															
        String st = null;
        
        while ((st = br.readLine()) != null) {						//while end is not reached st is equal to line
        	 System.out.println(st);
             
             for(int i=0; i<st.length(); i++) {						// traverse sentence
             	char input =st.charAt(i);
             	
             	
             	if (Character.isDigit(input)) {						//checking if char is digit letter or unknown
        			x = 1;											//DIGIT =1
        		} else if (Character.isLetter(input)) {
        			x = 0;											//LETER =0
        		}else {
        			x = 2;      									//UNKNOWN =2
        		}
             	
             	
             	if (x == 1 || x== 0) {					//if letter or digit, add to array to form lexeme
             		addChar(input);
             	} else if (x == 2) {             		
             		String word = new String(lexemeArray);			//create string from array
             		String token = lookup(word);
             		
             		if(!word.trim().isEmpty()) {
             			lexemeCont.addFirst(word+ " - " + token );						//adding lexeme to linkedlist
             			llcount++;
             		}
             		
             		if(input != ' ') {
             			token = lookup2(input);
             			lexemeCont.addFirst(input+ "          - " + token );			//adding the unknown to linkedlist
             			llcount++;
             		}
             		
             		for(int j=0; j<10; j++) {			//reseting  array
    					lexemeArray[j] = ' ';
    				}
    				lexCount=0;							//reseting counter    				  				
             	}else if(i==st.length()-1){												//end \n is reached
             		String word = new String(lexemeArray);
             		String token = lookup(word);
             		if(!word.trim().isEmpty()) {
             			lexemeCont.addFirst(word+ " - " + token );						//adding lexeme to linkedlist
             			llcount++;
             		}
             		
             		if(input != ' ') {
             			token = lookup2(input);
             			lexemeCont.addFirst(input+ "          - " + token );			//adding the unknown to linkedlist
             			llcount++;
             		}
             		
             		for(int j=0; j<10; j++) {											//reseting  array
    					lexemeArray[j] = ' ';
    				}
             		lexCount=0;		
             	}
             }        	
        }

        return null;
	}
	
	public static void addChar(char input){				
		if(lexCount <10) {
			lexemeArray[lexCount] = input;
			lexCount ++;
		}
	}
	
	public static String lookup(String word) {					//lookup for lexeme
		String token ="";
			if (!word.trim().isEmpty()) {
				token = "INT_LIT";
		
				for (int i=0; i<lexCount; i++) {
			
					if(Character.isLetter(word.charAt(i))) {
						token = "IDENT";
					} 
				}		
			}
		return token;	
	}
	
	public static String lookup2(char input) {						//lookup for unknown
		String token ="";
		if (input == '+') {
			token = "Addition Op";
		} else if (input == '-') {
			token = "Subtraction Op";
		} else if (input == '*') {
			token = "Multiplication Op";
		}else if (input == '/') {
			token = "Division Op";
		}else if (input == '(') {
			token = "Open Parenthesis";
		}else if (input == ')') {
			token = "Close Parenthesis";
		}else if (input == '=') {
			token = "Equal Op";
		}else {
			token ="EOF";
		}
			
		return token;	
	}
	
}