package SalesTax;

/**
 * Created by Eugene on 5/11/2015.
 */
public enum Goods {
    TAXABLE(0.1),
    EXEMPT(0),
    EXEMPTIMPORT(0.05),
    TAXABLEIMPORT(0.15);

    private double amount;
    private double tax;

    Goods(double amount){
        this.amount = amount;
    }

    public double addTax(Basket b){
        tax = b.getPrice()*amount;
        return b.getPrice()+tax;
    }

    public double getTax(){
        return tax;
    }


}
