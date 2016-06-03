package jdcb;

/**
 * Hello world!
 */
class App {
    public static void main(String[] args) {
        String ibanSrc = Helper.inputText("Entrez votre iban :");
        String ibanDest = Helper.inputText("Entrez l'iban de destination:");
        double solde = Double.parseDouble(Helper.inputText("Entrez le montant à transferer"));

        Bank bank = new Bank();
        bank.transferMoney(ibanSrc, 0 - solde);
        bank.transferMoney(ibanDest, solde);
    }
}
