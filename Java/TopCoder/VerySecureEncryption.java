// https://community.topcoder.com/stat?c=problem_statement&pm=14005

public class VerySecureEncryption {
	public static String encrypt(String message, int[] key, int K) {
		char[] encryptedMessage = new char[ message.length() ];
		
		for (int i = 0; i < K; ++i) {
			for (int j = 0; j < message.length(); ++j) {
				encryptedMessage[ key[j] ] = message.charAt(j);
			}
			message = String.valueOf(encryptedMessage);
		}
	
		// it's possible to directly return 'message', as its value is the same, but this improves code readability
		return String.valueOf(encryptedMessage); 
	}
}
