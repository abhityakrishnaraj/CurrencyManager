package seedu.duke.account;

import java.util.ArrayList;
import java.util.List;

import seedu.duke.BasicUi;
import seedu.duke.CurrencyStructure;
import seedu.duke.Wallet;

public class AccountUi {
    private static final String INDENTATION = "    ";

    public static void showAccountEntryMessage(String username) {
        final String MESSAGE = "You are logged in as " + username + "\n" + INDENTATION + "Please enter any command."
                + "\n" + INDENTATION + "You can use command list to view all available commands";
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showAccountExitMessage(String username) {
        final String MESSAGE = "Wallet " + username + " logout.";
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showSetDefaultCurrencyResult(String oldCurrencyName, String newCurrencyName) {
        final String MESSAGE = "Your default currency has been set from " + oldCurrencyName + " to " + newCurrencyName;
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showTotalBalance(double totalBalance, CurrencyStructure currency) {
        String formattedBalance = String.format("%.2f", totalBalance);
        final String MESSAGE = "Your total balance in " + currency.getAbbrName() + " is: " + formattedBalance
                + " " + currency.getSymbol();
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showSaveResult(CurrencyStructure currency, double amount) {
        String formattedBalance = String.format("%.2f", amount);
        final String MESSAGE = "You have successfully saved " + currency.getAbbrName() + " : " + formattedBalance
                + " " + currency.getSymbol();
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showWithdrawResult(CurrencyStructure currency, double amount) {
        String formattedBalance = String.format("%.2f", amount);
        final String MESSAGE = "You have successfully withdrawn " + currency.getAbbrName() + " : " + formattedBalance
                + " " + currency.getSymbol();
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showWalletDetails(String username, CurrencyStructure defaultCurrency, List<Deposit> deposits) {
        List<String> messages = new ArrayList<>();
        String message = "Your username: " + username;
        messages.add(message);
        message = "Your default currency: " + defaultCurrency.getAbbrName();
        messages.add(message);
        for (Deposit deposit: deposits) {
            String formattedBalance = String.format("%.2f", deposit.getBalance());
            CurrencyStructure currency = deposit.getCurrency();
            message = "Your balance in " + currency.getAbbrName() + " is: " + formattedBalance
                + " " + currency.getSymbol();
            messages.add(message);
        }
        String output = BasicUi.assembleMultipleLinesOutput(messages.toArray(new String[messages.size()]));
        BasicUi.showStandardOutput(output);
    }

    public static void showHelpPrompt(){
        final String MESSAGE = "You have entered into the help center, here you can \nchange your password, username, or default currency or delete your account";
        BasicUi.showStandardOutput(MESSAGE);
    }

    public static void reenterPassword(){
        final String MESSAGE = "Please re-enter your password to make this change";
        BasicUi.showStandardOutput(MESSAGE);
        System.out.println("Password: ");
    }

    public static void showDeletionConfirmPrompt(String username) {
        final String[] MESSAGES = { "Your wallet username: " + username,
                "Are you sure to delete your wallet? Your wallet can't be retrieved and you will automatically logout.",
                "Please enter Y or yes to proceed. Any other input will cancel the deletion operation." };
        final String MESSAGE = BasicUi.assembleMultipleLinesOutput(MESSAGES);
        BasicUi.showStandardOutput(MESSAGE);
    }

    public static void showDeletionResult(Boolean isDeleted) {
        final String MESSAGE = isDeleted ? "Deletion operation successful. Wallet logout."
                : "Deletion operation canceled.";
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void listCommands() {
        final String MESSAGE = "Your available commands are : \n"
                + INDENTATION + "1) balance" + INDENTATION + "2) detail" + INDENTATION + "3) save" + INDENTATION
                + "4) withdraw" + INDENTATION + "5) delete" + INDENTATION + "6) exit" + INDENTATION + "7) list"
                + INDENTATION + "8) transfer" + "9) currencies";
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }

    public static void showTransfer(String username, String currency, int amount) {
        final String MESSAGE = "Successfully transfered " + amount + currency + " to " + username;
        BasicUi.showStandardOutput(INDENTATION + MESSAGE);
    }
}
