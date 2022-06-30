import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    static HashMap<String, BankAccount> currentBankAccount = new HashMap<>();
    static HashMap<String, CreditBankAccount> currentCreditBankAccount = new HashMap<>();
    static HashMap<String, DepositBankAccount> currentDepositBankAccount = new HashMap<>();

    public static void main(String[] args)
    {
        String text = " ";
        System.out.println("Добро пожаловать в наш банк");

        while (!text.equals("0"))
        {
            System.out.println("""
                    -------------------------------------
                    Текущий счет
                    -------------------------------------
                    '1' - открыть текущий счет
                    '2' - пополнить счет
                    '3' - проверить счет
                    '4' - снять деньги со счета
                    '0' - выйти из банка
                    -------------------------------------
                    Кредитный счет
                    -------------------------------------
                    '10' - открыть кредитный счет
                    '11' - пополнить кредитный счет
                    '12' - проверить кредитный счет
                    '13' - снять деньги с кредитного счета
                    '0' - выйти из банка
                    -------------------------------------
                    Депозит счет
                    -------------------------------------
                    '20' - открыть депозит счет
                    '21' - пополнить депозит счет
                    '22' - проверить депозит счет
                    '23' - снять деньги с депозит счета
                    '0' - выйти из банка
                    -------------------------------------""");
            text = getText();

            switch (text) {
                case "1" -> addCard();
                case "2" -> addMoney(text);
                case "3" -> checkCard(text);
                case "4" -> removeMoney(text);
                case "10" -> addCreditCard();
                case "11" -> addCreditMoney(text);
                case "12" -> checkCreditCard(text);
                case "13" -> removeCreditMoney(text);
                case "20" -> addDepositCard();
                case "21" -> addDepositMoney(text);
                case "22" -> checkDepositCard(text);
                case "23" -> removeDepositMoney(text);
            }
        }
    }

    // Добавляем текущий счет и работаем с ним
    private static void addCard()
    {
        CreditCardNumberGenerator creditCardNumber = new CreditCardNumberGenerator();
        BankAccount bankAccount = new BankAccount(creditCardNumber.generate("4142", 16), 0.0);
        currentBankAccount.put(bankAccount.idBankAccount, bankAccount);
        System.out.println("Вы открыли расчетный счет с номером " + bankAccount.getIdBankAccount());
    }

    private static void addMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentBankAccount.containsKey(text))
        {
            BankAccount bankAccount = currentBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите отправить на свой счет");
            text = getText();
            bankAccount.setMoneyCount(Double.parseDouble(text));
            System.out.println("Вы внесли на свой счет " + text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void removeMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentBankAccount.containsKey(text))
        {
            BankAccount bankAccount = currentBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите снять с счета");
            text = getText();
            bankAccount.setDebitCountMoney(Double.parseDouble(text));
            System.out.println("Вы сняли со счета " + text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void checkCard(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentBankAccount.containsKey(text))
        {
            BankAccount bankAccount = currentBankAccount.get(text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    // Добавляем депозитный счет и работаем с ним
    private static void addDepositCard()
    {
        CreditCardNumberGenerator creditCardNumber = new CreditCardNumberGenerator();
        DepositBankAccount bankCreditAccount = new DepositBankAccount(creditCardNumber.generate("4242", 16), 0.0);
        currentDepositBankAccount.put(bankCreditAccount.idBankAccount, bankCreditAccount);
        System.out.println("Вы открыли депозитный счет с номером " + bankCreditAccount.getIdBankAccount());
    }

    private static void addDepositMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentDepositBankAccount.containsKey(text))
        {
            DepositBankAccount bankAccount = currentDepositBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите отправить на свой счет");
            text = getText();
            bankAccount.setMoneyCount(Double.parseDouble(text));
            System.out.println("Вы внесли на свой счет " + text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void removeDepositMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentDepositBankAccount.containsKey(text))
        {
            DepositBankAccount bankAccount = currentDepositBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите снять с счета");
            text = getText();
            bankAccount.setDebitCountMoney(Double.parseDouble(text));
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void checkDepositCard(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentDepositBankAccount.containsKey(text))
        {
            DepositBankAccount bankAccount = currentDepositBankAccount.get(text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    // Добавляем кредитный счет и работаем с ним
    private static void addCreditCard()
    {
        CreditCardNumberGenerator creditCardNumber = new CreditCardNumberGenerator();
        CreditBankAccount bankCreditAccount = new CreditBankAccount(creditCardNumber.generate("4242", 16), 0.0);
        currentCreditBankAccount.put(bankCreditAccount.idBankAccount, bankCreditAccount);
        System.out.println("Вы открыли расчетный счет с номером " + bankCreditAccount.getIdBankAccount());
    }

    private static void addCreditMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentCreditBankAccount.containsKey(text))
        {
            CreditBankAccount bankAccount = currentCreditBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите отправить на свой счет");
            text = getText();
            bankAccount.setMoneyCount(Double.parseDouble(text));
            System.out.println("Вы внесли на свой счет " + text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void removeCreditMoney(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentCreditBankAccount.containsKey(text))
        {
            CreditBankAccount bankAccount = currentCreditBankAccount.get(text);
            System.out.println("Введите сумму денег которую хотите снять с счета");
            text = getText();
            bankAccount.setDebitCountMoney(Double.parseDouble(text));
            System.out.println("Вы сняли со счета " + text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static void checkCreditCard(String text)
    {
        System.out.println("Введите номер вашего счета");

        if (currentCreditBankAccount.containsKey(text))
        {
            BankAccount bankAccount = currentCreditBankAccount.get(text);
            System.out.println("Ваш текущий баланс на счете " + bankAccount.getMoneyCount());
        }
    }

    private static String getText()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}