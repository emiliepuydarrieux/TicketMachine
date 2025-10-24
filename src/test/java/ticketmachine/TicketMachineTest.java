package ticketmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de
	// l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		// GIVEN : une machine vierge (initialisée dans @BeforeEach)
		// WHEN On insère de l'argent
		machine.insertMoney(10);
		machine.insertMoney(20);
		// THEN La balance est mise à jour, les montants sont correctement additionnés
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}


	@Test
	// S3 : on n'imprime pas le ticket tant que le montant n'est pas suffisant
	void notPrintNotSufficient(){
		assertFalse(machine.printTicket(),"Le montant n'est pas suffisant pour imprimer le ticket");
	}

	@Test
	// S4 : on imprime le ticket le montant est suffisant
	void PrintIfSufficient(){
		machine.insertMoney(50);
		assertTrue(machine.printTicket(),"Le montant est suffisant pour imprimer le ticket");
	}

	@Test
	// S5 : Quand on imprime un ticket la balance est décrémentée du prix du ticket
	void decrBalance(){
		machine.insertMoney(50);
		if (machine.getBalance()>machine.getPrice()){
			float du=machine.getBalance()-machine.getPrice();
		}
		assertTrue(machine.printTicket(),"Le montant est suffisant pour imprimer le ticket");
	}

}
