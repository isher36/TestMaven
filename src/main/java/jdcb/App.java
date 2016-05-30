package jdcb;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String ibanSrc = Helper.inputText("Entrez votre iban :");
        String ibanDest = Helper.inputText("Entrez l'iban de destination:");
        String solde = Helper.inputText("Entrez le montant à transferer");
    }


}
