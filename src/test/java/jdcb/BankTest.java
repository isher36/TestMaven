package jdcb;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by isher on 31/05/2016.
 */
public class BankTest extends TestCase {

    @Test
    public void testIsValidIban() throws Exception {

        //Given
        Bank bank = new Bank();

        //When
        boolean valid = bank.isValidIban("123-123456789");
        boolean notValid = bank.isValidIban("-123456789");
        boolean stillNotvalid = bank.isValidIban("123");
        //Then
        assertTrue(valid);
        assertFalse(notValid);
        assertFalse(stillNotvalid);
    }

    @Test
    public void testGetSoldeWithvalideAccount() throws Exception {
        //Given
        Bank bank = new Bank();
        Throwable e = null;
        //When
        String iban = "123-456";

        double solde = bank.getSolde(iban);

        //Then
        assertTrue(solde >= 0);

    }

    @Test(expected = Exception.class)
    public void testGetSoldeWithInvalideAccount() {
        //Given
        Bank bank = new Bank();
        Throwable e = null;
        //When
        String iban = "0-0";
        try {
            double solde = bank.getSolde(iban);
        } catch (Throwable ex) {
            e = ex;
        }
        //Then
        assertTrue(e instanceof Exception);

    }

    public void testTransferMoney() throws Exception {
        //Given

        //When

        //Then
    }

}