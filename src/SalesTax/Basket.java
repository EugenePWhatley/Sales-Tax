package SalesTax;

/**
 * Created by Eugene on 5/11/2015.
 */
public class Basket {
    private int quantity;
    private String product;
    private double price;
    private Goods goods;

    public Basket(int quantity, String product, double amount) {
        this.quantity = quantity;
        this.product = product;
        this.price = amount;
        sortBasket();
        adjustPrice();
    }

    private void adjustPrice() {
        price = format(this.getType().addTax(this));
        for(int i = 1; i < quantity; i++) {
            price+=price;
        }
    }

    private double format(double f) {
        f = f*100;
        Math.round(f);
        f = f/100;
        return f;
    }

    private void sortBasket() {
        if(product.contains("imported")){
            if(product.contains("book")||product.contains("chocolate")||product.contains("pills")){
                goods = goods.EXEMPTIMPORT;
            } else {
                goods = goods.TAXABLEIMPORT;
            }
        } else if (product.contains("book")||product.contains("chocolate")||product.contains("pills")){
            goods = goods.EXEMPT;
        } else {
            goods = goods.TAXABLE;
        }

    }

    public double getPrice() {
        return price;
    }

    public Goods getType(){
        return goods;
    }

    public void printDetails() {
        System.out.printf("%d %s: %.2f\n", quantity, product, price);
    }

}
