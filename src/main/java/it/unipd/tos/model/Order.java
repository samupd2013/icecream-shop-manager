////////////////////////////////////////////////////////////////////
// Samuele De Simone 1219399
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;
import java.util.List;
import java.time.LocalTime;
import java.util.Random;
import it.unipd.tos.model.User;

public class Order{
    List<MenuItem> items; 
    User user;
    LocalTime orario;
    boolean isFree;
    
    public Order(List<MenuItem> l, User u, LocalTime o, int c) {
        this.items = l; 
        this.user = u;
        this.orario = o;
        this.isFree = isFree(c);
    }

    public LocalTime getOrario() {
        return orario;
    }

    public User getUser() {
        return user;
    }

    public List<MenuItem> getItems(){
        return items;
    }


    private boolean isFree(int counter){
        Random r = new Random();
        return user.isMinorenne() && orario.getHour() == 18 && counter<10 && r.nextInt(10) == 0;
    }

    public boolean getIsFree(){
        return isFree;
    }
    
}