package it.unipd.tos.model;
import it.unipd.tos.model.Order;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class OrderTest{
    @Test
    public void getOrario_Test(){
        Order o1 = new Order(new ArrayList<MenuItem>(), new User(1, "Luca", "Rossi", true), LocalTime.MAX, 1 );
        Order o2 = new Order(new ArrayList<MenuItem>(), new User(1, "Luca", "Rossi", true), LocalTime.parse("18:00"), 1 );
        Order o3 = new Order(new ArrayList<MenuItem>(), new User(1, "Luca", "Rossi", true), LocalTime.MIDNIGHT, 1 );
        assertEquals(LocalTime.MAX,o1.getOrario());
        assertEquals(LocalTime.parse("18:00"), o2.getOrario());
        assertEquals(LocalTime.MIDNIGHT, o3.getOrario());
    }
}