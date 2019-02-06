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
import java.lang.Math;

public class Candy extends DessertItem {
    
    private double weight;
    private int cost;
    
    public Candy(String myName, double w, int c)
    {
        name = myName;
        weight = w;
        cost = c;
    }
    
    public int getCost()
    {
        double c = Math.round(weight * cost);
        int i = (int) c;
        return i;
    }
    
}
