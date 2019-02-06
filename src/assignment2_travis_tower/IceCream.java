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
public class IceCream extends DessertItem{
    
    protected int cost;
    
    public IceCream(String n, int c)
    {
        name = n;
        cost = c;
    }
    
    public int getCost()
    {
        return cost;
    }
    
}
