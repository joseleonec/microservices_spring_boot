package ucuenca.ejemplo.store.shoppingservice.repository;

import ucuenca.ejemplo.store.shoppingservice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
