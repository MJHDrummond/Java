/*
  Program to practice various methods of simple
  encrypting of strings. Here we practiced string 
  manipulation, return statements and their methods.
  
  Author: McGregor Drummond.
  Date: 2 September 2017.
  Finished: 3 September 2017.
*/

public class Crypto {

	public static void main(String[] args) {
		
		String initText = "This is some \"really\" great. (text)!?";
		String normText = normalizeText(initText);
		System.out.println("Part 1. Normalize Text - Changed \"" + initText + "\" to \"" + normText + "\"");
		
		String obifyText = obify(normText);
		System.out.println("Part 2. Obfuscation - \"" + obifyText + "\"");
		
		String initObText = "OBI LOBIKOBE CHOBEOBESOBE";
		String unObifyText = unobify(initObText);
		System.out.println("Part 3. Unobfuscation - Changed \"" + initObText + "\" to \"" + unObifyText + "\"");

		String initCeasar = "ILIKEZOOS";
		String ceasarText = caesarify(initCeasar, 1);
		System.out.println("Part 4. Ceasar Cipher - Changed \"" + initCeasar + "\" to \"" + ceasarText + "\"");
		
		String initGroup = "HITHERE";
		String groupText = groupify(initGroup, 2);
		System.out.println("Part 5. Codegroups - Changed \"" + initGroup + "\" to \"" + groupText + "\"");
		
		String initEncrypt = "Test ! (text)?";
		String encryptText = encryptString(initEncrypt, 2, 5);
		System.out.println("Part 6. All Together - Changed \"" + initEncrypt + "\" to \"" + encryptText + "\"");
		
		String initUnGroup = "THI SIS ARE ALL YGR EAT SEN TEN CEx";
		String unGroupText = unGroupify(initUnGroup);
		System.out.println("Part 7. Ungroup - Changed \"" + initUnGroup + "\" to \"" + unGroupText + "\"");
		
		String initCypher = "Who will win the election?";
		String cypherText = encryptString(initCypher, 5, 3);
		String plainText = decryptString(cypherText, 5);
		System.out.println("Part 8. Decrypt - Encrypted \"" + initCypher + "\" to \"" + cypherText + "\" and decrypted back to \"" + plainText + "\"");
	}
	
	public static String normalizeText(String s) {
		return s.replaceAll("[^a-zA-Z]", "").toUpperCase(); //remove all special chars and spaces
	}

	public static String obify(String s) {		
		s = s.replaceAll("O", "OBO");
		s = s.replaceAll("A", "OBA");
		s = s.replaceAll("E", "OBE");
		s = s.replaceAll("I", "OBI");
		s = s.replaceAll("U", "OBU");
		s = s.replaceAll("Y", "OBY");
		return s;
	}
	
	public static String unobify(String s) {		
		return s.replaceAll("OB", "");
	}
	
	public static String caesarify(String s, int n) {		
		String shiftedAlphabet = shiftAlphabet(n); //create shifted alphabet
		String alphabet = shiftAlphabet(0); //create normal alphabet
		char[] sChars = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			sChars[i] = shiftedAlphabet.charAt(alphabet.indexOf(s.charAt(i)));
		}
		return String.valueOf(sChars);
	}
	
	public static String groupify(String s, int n) {		
		for (int i = n; i < s.length(); i += n+1) {
			if (n == 0) {
				return s;
			} else {				
			    s = s.substring(0, i) + " " + s.substring(i, s.length()); 
			}
		}

		while (s.substring(s.length()-n).contains(" ")) { //add 'x' to keep chunks equal length
			    s = s + "x";
			}
		return s;
	}
	
	public static String encryptString(String s, int n, int g) {
		s = normalizeText(s);
		s = obify(s);
		s = caesarify(s, n);
		s = groupify(s, g);
		return s;
	}
	
	public static String unGroupify(String s) {
		return s.replaceAll("[^a-zA-Z]", "").replaceAll("x", "");
	}
	
	public static String decryptString(String s, int n) {
		s = unGroupify(s);
		s = caesarify(s, -n);
		s = unobify(s);		
		return s;
	}
	
	public static String shiftAlphabet(int shift) { 
	    int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for (; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if (result.length() < 26) {
	        for (currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}
}
