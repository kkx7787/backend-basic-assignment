package problem3;

// 마이너스 통장 계좌 클래스
class OverdraftAccount extends BankAccount {
    public OverdraftAccount(String accountNumber, String owner) {
        super(accountNumber, "마이너스", owner, 0);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void transfer(BankAccount targetAccount, double amount) {
        balance -= amount;
        targetAccount.deposit(amount);
    }

    @Override
    public void showAccount() {
        String balanceStr = String.format("%,d", Math.round(balance)); // 소수점 없이 반올림하여 정수로 표시
        System.out.printf("%s 통장 - 잔액 : %s원\n", super.accountName, balanceStr);
    }
}
