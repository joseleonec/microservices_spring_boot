package ucuenca.ejemplo.store.shoppingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucuenca.ejemplo.store.shoppingservice.Entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}