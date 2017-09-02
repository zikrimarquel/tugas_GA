/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Marquel
 */
public class City {
    private int x;
    private int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public double distanceTo(City otherCity) {
//        rumus pitagoras
        int distanceX = Math.abs(getX() - otherCity.getX());
        int distanceY = Math.abs(getY() - otherCity.getY());
//        Math.abs biar ga negatif
        double distanceTotal = Math.sqrt( (distanceX*distanceX) + (distanceY*distanceY));
        
        return distanceTotal;
    }
    
    @Override
    public String toString() {
        return "\nX:" + this.x + "\nY:" + this.y;
    }
    
}
