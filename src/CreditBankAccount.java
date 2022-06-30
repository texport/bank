public class CreditBankAccount extends BankAccount
{
    public CreditBankAccount(String idBankAccount, double moneyCount)
    {
        super(idBankAccount, moneyCount);
    }

    public void setDebitCountMoney(double moneyCount)
    {
        this.moneyCount = this.moneyCount - moneyCount - (moneyCount/100);
        System.out.println("Комиссия за обслуживание 1% - " + (moneyCount/100) + " тг.");
    }
}