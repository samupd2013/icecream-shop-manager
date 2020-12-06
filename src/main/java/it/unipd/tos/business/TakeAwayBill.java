////////////////////////////////////////////////////////////////////
// Samuele De Simone 1219399
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;
import it.unipd.tos.business.exceptions.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
public interface TakeAwayBill {
  double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException;
} 