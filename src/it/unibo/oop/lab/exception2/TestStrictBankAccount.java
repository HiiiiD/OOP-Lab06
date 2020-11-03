package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccountImpl}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccountImpl}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	AccountHolder accHolder1 = new AccountHolder("Marco","Salomone",1);
    	AccountHolder accHolder2 = new AccountHolder("Marco","Salomon",2);
    	StrictBankAccountImpl bankAcc1 = new StrictBankAccountImpl(1,10000, 10);
    	StrictBankAccountImpl bankAcc2 = new StrictBankAccountImpl(2,10000, 10);
    	
    	for (int i = 0; i < 10; i++) {
    		bankAcc1.withdrawFromATM(1, 1);
    		bankAcc2.withdrawFromATM(2, 1);
    	}
    	
    	//Cannot operate with ATMs anymore
    	try {
			bankAcc1.withdrawFromATM(1, 1);
		} catch (TransactionsOverQuotaException e) {
			System.out.println(e.getMessage());
		}
    	//Same for bankAcc2
    	try {
			bankAcc2.withdrawFromATM(2, 1);
		} catch (TransactionsOverQuotaException e) {
			System.out.println(e.getMessage());
		}
    	//Wrong account holder
    	try {
			bankAcc1.withdraw(2, 1);
		} catch (WrongAccountHolderException e) {
			System.out.println(e.getMessage());
		}
    	//Not enough founds to withdraw
    	try {
			bankAcc1.withdraw(1, 10000);
		} catch (NotEnoughFoundsException e) {
			System.out.println(e.getMessage());
		}
    	
    }
}
