package cn.zc.thread;

public class Account {
	/**
     * 账号
     */
    private String accountNo;

    /**
     * 余额
     */
    private double balance;

    public Account() {
    }

    /**
     * 带参构造函数
     * 
     * @param accountNo 账户
     * @param balance 余额
     */
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    // 访问该账户的余额，使用synchronized修饰符将它变成同步方法
    public synchronized double getBalance() {
        return balance;
    }
        
    /**
     * 取钱的方法
     * 
     * @param drawAmount 取钱金额
     */
    public synchronized void draw(double drawAmount) {

        // 如果余额大于等于用户取的钱，则取款成功
        if (balance >= drawAmount) {
            // 取款成功
            System.out.println(Thread.currentThread().getName() + "取钱成功！用户取出" + drawAmount + "元");

            // 修改余额
            balance -= drawAmount;
            System.out.println("\t余额为： " + balance);
            
        } else {
            
            System.out.println(Thread.currentThread().getName() + "取钱失败！您的余额不足");
            
        }

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    // 重写hashCode()方法
    public int hashCode() {
        return accountNo.hashCode();
    }

    // 重写equals()方法
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.accountNo.equals(accountNo);
        }
        return false;
    }
}
