public class BankAccount
{
    double moneyCount;
    String idBankAccount;

    public BankAccount(String idBankAccount, double moneyCount)
    {
        this.idBankAccount = idBankAccount;
        this.moneyCount = moneyCount;
    }

    public double getMoneyCount()
    {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount)
    {
        this.moneyCount = this.moneyCount + moneyCount;
    }

    public void setDebitCountMoney(double moneyCount)
    {
        this.moneyCount = this.moneyCount - moneyCount;
    }

    public String getIdBankAccount()
    {
        return idBankAccount;
    }
}