// https://community.topcoder.com/stat?c=problem_statement&pm=6036

public class AccountBalance {
	public static int processTransactions(int startingBalance, String[] transactions) {
		int balance = startingBalance;
		
		for (String transaction : transactions) {
			String[] line = transaction.split(" ");
			int amountOfMoney = Integer.parseInt(line[1]);
			char operationCode = line[0].charAt(0);
			if (operationCode == 'C') {
				balance += amountOfMoney;
			}
			else if (operationCode == 'D') {
				balance -= amountOfMoney;
			}
		}
		
		return balance;
	}
}
