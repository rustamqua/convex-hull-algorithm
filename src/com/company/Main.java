package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Vector;

public class Main{
    public static void main(String[] args) {
        convexHull a = new convexHull(200,100);
    }

}
class Point implements Comparable<Point>{
    Integer x,y;
    Point(Integer x,Integer y){
        this.x=x;
        this.y=y;
    }
    public int compareTo(Point p){
        return this.x.compareTo(p.x);
    }
}
class convexHull{
    Vector<Point> conv;
    Point[] points;
    convexHull(int plane, int amount){
       Point[] points = new Point[amount];
       for(int i=0;i<amount;i++){
           Integer temp =plane-(int)(Math.random()*100);
           Integer temp2 =plane-(int) (Math.random()*100);
           points[i] = new Point(temp,temp2);
       }
       Arrays.sort(points);
       this.points = points;
        Vector<Point> convex = new Vector<Point>();
        int p =amount-1;
        int q=amount-1;
        do {
            convex.add(points[p]);
            q= (p+1)%amount;
            for(int i = 0;i<amount;i++){
                if(check.orientation(points[p],points[i],points[q])==-1){
                    q=i;
                }
            }
            p=q;
        }while (p!=amount-1);
        this.conv = convex;    }
    Vector<Point> getConvex(){
        return this.conv;
    }
}

class check{
    public static int orientation(Point p, Point q, Point r)
    {
        int temp = (q.y-p.y) * (r.x-q.x) -
                (q.x-p.x) * (r.y-q.y);
        if (temp == 0) return 0;
        return (temp > 0)? 1: -1;
    }
}
