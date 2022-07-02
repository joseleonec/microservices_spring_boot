package ucuenca.ejemplo.store.shoppingservice.Service;

import java.util.List;

import ucuenca.ejemplo.store.shoppingservice.Entity.Invoice;

public interface InvoiceService {
    public List<Invoice> findInvoiceAll();

    public Invoice createInvoice(Invoice invoice);
    public Invoice updateInvoice(Invoice invoice);
    public Invoice deleteInvoice(Invoice invoice);

    public Invoice getInvoice(Long id);
}