package edu.ib.zpo14;

import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double radius;
    private View view;
    private Paint paint;

    public Ball(View view, double x, double y, double radius,Paint paint) {
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.ax = 0;
        this.ay = 0;
        this.radius=radius;
        this.view=view;
        this.paint=paint;
    }

    public void calculate(){
        vx+=ax;
        if(vx>50) vx=50;
        if(vx<-50) vx=-50;
        vy+=ay;
        if(vy>50) vy=50;
        if(vy<-50) vy=-50;
        x+=vx;
        if(x<radius){
            x=radius;
            vx*=-0.8;
        }
        if(x>view.getWidth()-radius){
            x=view.getWidth()-radius;
            vx*=-0.8;
        }
        y+=vy;
        if(y<radius){
            y=radius;
            vy*=-0.8;
        }
        if(y>view.getHeight()-radius){
            y=view.getHeight()-radius;
            vy*=-0.8;
        }
        //Log.d(MainActivity.TAG,"ax="+ax+" ay="+ay+" vx="+vx+" vy="+vy+" x="+x+" y="+y);
    }
    public Paint getPaint(){
        return paint;
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }
}