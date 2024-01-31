package simbirsoft.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import simbirsoft.pages.AccountPage;
import simbirsoft.pages.CustomerPage;
import simbirsoft.pages.LoginPage;
import simbirsoft.pages.TransactionPage;
import simbirsoft.pages.components.CheckResultComponent;
import simbirsoft.utils.fibonacciSum.FibonacciSum;

@DisplayName("Testing XYZ Bank Transactions")
public class TransactionTest extends BaseTest {
    @Test
    @Description("Testing transactions for XYZ Bank user with deposit and withdrawal")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Xyz Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("USER-XYZ")
    public void transactionsUserTest() {

        AccountPage accountPage = new AccountPage(driver);
        CustomerPage customerPage = new CustomerPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CheckResultComponent tableResulComponent = new CheckResultComponent(driver);
        TransactionPage transactionPage = new TransactionPage(driver);
        FibonacciSum fibonacciSum = new FibonacciSum();

        loginPage.clickCustomerLoginButton();
        customerPage.openUserList();
        customerPage.selectPotterUser();
        customerPage.clickLoginButton();
        accountPage.clickDepositButton();
        accountPage.enterDepositAmount(fibonacciSum.calculateFibonacciSum());
        accountPage.confirmDeposit();
        accountPage.clickWithdrawButton();
        accountPage.enterWithdrawAmount(fibonacciSum.calculateFibonacciSum());
        accountPage.confirmWithdrawal();
        accountPage.checkBalance("0");
        accountPage.clickTransactionsButton();

        tableResulComponent.checkTransactions(String.valueOf
                (fibonacciSum.calculateFibonacciSum()), "Credit");
        tableResulComponent.checkTransactions(String.valueOf
                (fibonacciSum.calculateFibonacciSum()), "Debit");

        transactionPage.performTransactionActions("transactions.csv");

    }
}