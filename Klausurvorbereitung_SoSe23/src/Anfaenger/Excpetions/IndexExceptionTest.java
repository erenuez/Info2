package Anfaenger.Excpetions;

import edu.bielefeld.io.EAM;

public class IndexExceptionTest {
	public static void main(String[] args) {
		int i;
		do {
			System.out.println("Bitte geben Sie einen Wert zwischen 1 und 100 ein (0 zum beenden): ");
			i = EAM.rInt();
			if (i == 0)
				continue;
			try {
				if ((i < 1) | (i > 100))
					throw new IndexException(1, 100);
			} catch (IndexException e) {
				System.out.println(e.getMessage());
				System.out.println(e.toString());
			}
		} while (i != 0);
	}
}
