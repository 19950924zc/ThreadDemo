package cn.zc.thread;

public class Account {
	/**
     * �˺�
     */
    private String accountNo;

    /**
     * ���
     */
    private double balance;

    public Account() {
    }

    /**
     * ���ι��캯��
     * 
     * @param accountNo �˻�
     * @param balance ���
     */
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    // ���ʸ��˻�����ʹ��synchronized���η��������ͬ������
    public synchronized double getBalance() {
        return balance;
    }
        
    /**
     * ȡǮ�ķ���
     * 
     * @param drawAmount ȡǮ���
     */
    public synchronized void draw(double drawAmount) {

        // ��������ڵ����û�ȡ��Ǯ����ȡ��ɹ�
        if (balance >= drawAmount) {
            // ȡ��ɹ�
            System.out.println(Thread.currentThread().getName() + "ȡǮ�ɹ����û�ȡ��" + drawAmount + "Ԫ");

            // �޸����
            balance -= drawAmount;
            System.out.println("\t���Ϊ�� " + balance);
            
        } else {
            
            System.out.println(Thread.currentThread().getName() + "ȡǮʧ�ܣ���������");
            
        }

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    // ��дhashCode()����
    public int hashCode() {
        return accountNo.hashCode();
    }

    // ��дequals()����
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
