
public class Atm {

	String requiredPin = "123";
	String enteredPin;

	boolean allowAccess(String enteredPin) {
		if (requiredPin.equalsIgnoreCase(enteredPin)) {
			return true;
		}
		return false;
	}

	double balance = 555;

	void deposit(double amount) {
		balance += amount;
	}

	void withdraw(double amount) {

		balance -= amount;
	}
}
