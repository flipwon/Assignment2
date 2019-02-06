/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_travis_tower;

/**
 *
 * @author flipp
 */
public class Cookie extends DessertItem {
    
    private int number;
    private int pricePerDozen;
    
    public Cookie(String myName, int n, int p){
        name = myName;
        number = n;
        pricePerDozen = p;
    }
    
    public int getCost()
    {
        int c = number * (pricePerDozen/12);
        return c;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public int getPricePerDozen()
    {
        return pricePerDozen;
    }
}
