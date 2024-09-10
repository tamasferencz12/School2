package machine;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public void writeAmmount() {
        System.out.printf("$%d of money\n\n", this.getMoney());
    }

    public void take() {
        System.out.printf("I gave you $%d\n\n", this.getMoney());
        this.setMoney(0);
    }
}
