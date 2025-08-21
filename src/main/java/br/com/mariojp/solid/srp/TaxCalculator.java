package br.com.mariojp.solid.srp;

public class TaxCalculator {

    private final double taxRate;

    public TaxCalculator() {
     
        String rate = System.getProperty("tax.rate", "0.18");
        this.taxRate = Double.parseDouble(rate);
    }

    public double valueTax(double subtotal) {
        return subtotal * taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }
}