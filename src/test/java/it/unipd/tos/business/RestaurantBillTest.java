////////////////////////////////////////////////////////////////////
// Samuele De Simone 1219399
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.RestaurantBill;
import it.unipd.tos.business.exceptions.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RestaurantBillTest{
    @Test
    public void TotalPrice_Test(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User u01 = new User(01,"Luca", "Rossi", true);
        RestaurantBill testBill = new RestaurantBill();

        itemsOrdered.add(new MenuItem("Gelato cioccolato e crema", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 3.00));
        itemsOrdered.add(new MenuItem("Budino pinguino", MenuItem.type.Budino, 5.00));
        itemsOrdered.add(new MenuItem("Gelato nocciola stracciatella", MenuItem.type.Gelato, 2.50));

        try{
            assertEquals(13.00, testBill.getOrderPrice(itemsOrdered, u01),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    } 

    @Test
    public void TotaleConPiu5Gelati_Test(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User u01 = new User(01,"Luca", "Rossi", true);
        RestaurantBill testBill = new RestaurantBill();

        itemsOrdered.add(new MenuItem("Gelato cioccolato e crema", MenuItem.type.Gelato, 3.50));
        itemsOrdered.add(new MenuItem("Gelato", MenuItem.type.Gelato, 1.00));
        itemsOrdered.add(new MenuItem("Gelato crema", MenuItem.type.Gelato, 3.50));
        itemsOrdered.add(new MenuItem("Gelato cioccolato", MenuItem.type.Gelato, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 3.00));
        itemsOrdered.add(new MenuItem("Budino pinguino", MenuItem.type.Budino, 5.00));
        itemsOrdered.add(new MenuItem("Gelato nocciola stracciatella", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Gelato nocciola", MenuItem.type.Gelato, 2.50));

        try{
            assertEquals(24.5, testBill.getOrderPrice(itemsOrdered, u01),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }
    
    @Test
    public void TotMaggioreDi50_Test(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User u01 = new User(01,"Luca", "Rossi", true);
        RestaurantBill testBill = new RestaurantBill();

        itemsOrdered.add(new MenuItem("Gelato cioccolato e crema", MenuItem.type.Gelato, 60.00));

        try{
            assertEquals(54, testBill.getOrderPrice(itemsOrdered, u01),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }

    @Test
    public void maggiore50ePiu5Gelati_Test(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User u01 = new User(01,"Luca", "Rossi", true);
        RestaurantBill testBill = new RestaurantBill();

        itemsOrdered.add(new MenuItem("Gelato cioccolato e crema", MenuItem.type.Gelato, 10.00));  
        itemsOrdered.add(new MenuItem("Gelato", MenuItem.type.Gelato, 2.00));
        itemsOrdered.add(new MenuItem("Gelato crema", MenuItem.type.Gelato, 10.00));
        itemsOrdered.add(new MenuItem("Gelato cioccolato", MenuItem.type.Gelato, 10.00));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 15.00));
        itemsOrdered.add(new MenuItem("Budino pinguino", MenuItem.type.Budino, 10.00));
        itemsOrdered.add(new MenuItem("Gelato nocciola stracciatella", MenuItem.type.Gelato, 10.00));
        itemsOrdered.add(new MenuItem("Gelato nocciola", MenuItem.type.Gelato, 20.00)); 

        try{
            assertEquals(77.40, testBill.getOrderPrice(itemsOrdered, u01),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }
} 