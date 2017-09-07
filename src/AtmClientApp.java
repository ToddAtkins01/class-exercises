
import java.util.Scanner;
import java.text.NumberFormat;

public class AtmClientApp {

	public static void main(String[] args) {

		Atm bankOfMe = new Atm();
		Scanner input = new Scanner(System.in);
		NumberFormat curancyFormat = NumberFormat.getCurrencyInstance();

		System.out.println("Welcome to the Bank of Me. \nPlease enter your PIN.");
		bankOfMe.enteredPin = input.next();

		for (int idx = 0; idx < 2; idx++) {
			if (bankOfMe.allowAccess(bankOfMe.enteredPin)) {
				System.out.println("Thank you, \n");
				break;
			}
			if (!bankOfMe.allowAccess(bankOfMe.enteredPin)) {

				System.out.println("Sorry, that is incorrect. Please try again.");
				bankOfMe.enteredPin = input.next();

				if (idx == 1) {
					System.out.println(
							"We're sorry. You have reached the maximum number of attempts. Please contact Customer Support.");
				}
			}
		}

		while (bankOfMe.allowAccess(bankOfMe.enteredPin)) {
			int userOpt;

			do {
				System.out.println("Please select an option. \n");
				System.out.println("Press 1 to deposit funds");
				System.out.println("Press 2 to withdraw funds");
				System.out.println("Press 3 to check balance");
				System.out.println("Press 4 to exit");
				userOpt = input.nextInt();

			} while (userOpt != 1 && userOpt != 2 && userOpt != 3 && userOpt != 4);

			switch (userOpt) {

			case 1:
				System.out.println("Please enter the amount you would like to deposit.");
				double enteredDeposit = input.nextDouble();
				bankOfMe.deposit(enteredDeposit);
				System.out.println("Your new balance is: " + curancyFormat.format(bankOfMe.balance) + "\n");
				break;

			case 2:
				System.out.println("Please enter the amount you would like to withdraw.");
				double enteredWithdraw = input.nextDouble();
				bankOfMe.withdraw(enteredWithdraw);
				System.out.println("Your new balance is: " + curancyFormat.format(bankOfMe.balance) + "\n");
				break;

			case 3:
				System.out.println("Your balance is: " + curancyFormat.format(bankOfMe.balance) + "\n");
				break;

			case 4:
				System.out.println("Thank you for being a part of Bank Of Me.\nHave a great day!");
				System.exit(0);

			}

		}

		input.close();
	}
}
