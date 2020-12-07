////////////////////////////////////////////////////////////////////
// Samuele De Simone 1219399
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.ArrayList;
import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem.type;
import it.unipd.tos.model.Order;
import it.unipd.tos.business.exceptions.TakeAwayBillException;

import java.util.Random;
import java.time.LocalTime;
public class RestaurantBill implements TakeAwayBill{
    public static int counterRegalo = 0;
    private List<User> usersConRegalo = new ArrayList<User>();
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime t) throws TakeAwayBillException{
        return getOrderPrice(new Order(itemsOrdered, user, t, counterRegalo));
    }

    public double getOrderPrice(Order o) throws TakeAwayBillException{
        double tot = 0;
        int numGelati = 0;
        double minPrezzoGelato = Double.MAX_VALUE; 
        double totBevande = 0;
        for(MenuItem m : o.getItems()){
            tot+=m.getPrice();
            if(m.getType() == type.Gelato){
                numGelati += 1;
                if(m.getPrice() < minPrezzoGelato){
                    minPrezzoGelato = m.getPrice();
                }
            }
            if(m.getType()==type.Bevanda){
                totBevande += m.getPrice();
            }
        }

        if(numGelati > 5){
            tot -= minPrezzoGelato * 0.5;
        }
        if(tot-totBevande > 50){
            tot *= 0.9;
        }
        if(o.getItems().size() > 30){
            throw new TakeAwayBillException("Non si possono ordinare più di 30 elementi");
        }
        if(tot < 10){
            tot += 0.5;
        }

        if(o.getIsFree() && !usersConRegalo.contains(o.getUser())){
            counterRegalo++;
            usersConRegalo.add(o.getUser());
            tot = 0;
        }
        return tot;
    }
}