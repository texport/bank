import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DepositBankAccount extends BankAccount
{
    static String createDate = " ";
    static String trueDate = " ";
    static String currentDate = " ";
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public DepositBankAccount(String idBankAccount, double moneyCount)
    {
        super(idBankAccount, moneyCount);
        calendarRemoveDeposit();
    }

    private static void calendarRemoveDeposit()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 30);
        createDate = dateFormat.format(date);
        trueDate = dateFormat.format(calendar.getTime());
    }

    public void setMoneyCount(double moneyCount)
    {
        this.moneyCount = this.moneyCount + moneyCount;
        calendarRemoveDeposit();
    }

    public void setDebitCountMoney(double moneyCount)
    {
        Date date = new Date();
        currentDate = dateFormat.format(date);

        if (Objects.equals(trueDate, currentDate))
        {
            this.moneyCount = this.moneyCount - moneyCount;
        }
        else
        {
            System.out.println("С момента внесения денег не прошло 30 дней");
        }
    }
}