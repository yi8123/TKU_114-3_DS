public class Transaction {
    private String id;
    private String account;
    private double amount;
    private int timeSeq; // 時間序號，數字愈小代表時間愈早

    public Transaction(String id, String account, double amount, int timeSeq) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.timeSeq = timeSeq;
    }

    public double getAmount() { return amount; }
    public int getTimeSeq() { return timeSeq; }

    @Override
    public String toString() {
        return String.format("交易編號: %s | 帳號: %-6s | 金額: %7.1f | 時間序號: %d", id, account, amount, timeSeq);
    }
}