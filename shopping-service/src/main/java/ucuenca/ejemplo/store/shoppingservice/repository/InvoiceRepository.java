package ucuenca.ejemplo.store.shoppingservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucuenca.ejemplo.store.shoppingservice.Entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByCustomerId(Long customerId );
    public Invoice findByNumberInvoice(String numberInvoice);
}