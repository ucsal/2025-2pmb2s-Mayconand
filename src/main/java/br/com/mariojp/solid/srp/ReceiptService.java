package br.com.mariojp.solid.srp;

public class ReceiptService {
	
	private TaxCalculator taxcalc;
	private ReceiptFormatter form;
	
	
	public ReceiptService() {
	    this.taxcalc = new TaxCalculator();
	    this.form = new ReceiptFormatter();
	 
	    this.form.setService(this);
	    this.form.setTaxcalc(this.taxcalc);
	}

	public double subtotal(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		return subtotal;
	}
	
	public double total(Order order) {
		double total = subtotal(order)+taxcalc.valueTax(subtotal(order));
		
		return total;
	}
	
	public String generate(Order order) {
		return form.formatterText(order);
	}
	
}
