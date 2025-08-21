package br.com.mariojp.solid.srp;

public class ReceiptFormatter {
	private ReceiptService service;
    private TaxCalculator taxcalc;

   
    public ReceiptFormatter() {
    }

   
    public void setService(ReceiptService service) {
        this.service = service;
    }

    public void setTaxcalc(TaxCalculator taxcalc) {
        this.taxcalc = taxcalc;
    }
    
    
    
	public String formatterText(Order order) {
	
	StringBuilder sb = new StringBuilder(); //Formatando o Recibo
	sb.append("=== RECIBO ===\n");
	for (var i : order.getItems()) {
		sb.append(i.getName()).append(" x").append(i.getQuantity()).append(" = ").append(i.getUnitPrice() * i.getQuantity())
				.append("\n");
	}
	sb.append("Subtotal: ").append(service.subtotal(order)).append("\n");
	sb.append("Tax: ").append(taxcalc.valueTax(service.subtotal(order))).append("\n");
	sb.append("Total: ").append(service.total(order)).append("\n");
	return sb.toString();

	}
}
