package com.mahbuba.dietcare;

public class Pointvalue {
    long x;
    long  y;
    long id;
    long total;


    public Pointvalue(){}

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Pointvalue(long x, long y, long  id, long total){
        this.x=x;
        this.y=y;
        this.id=id;
        this.total=total;


    }

    public double getX(){
        return x;

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setX(long x){
        this.x=x;
    }

    public double getId() {
        return id;
    }

    public  double getY(){
        return  y;
    }

    public void setY(long y){
        this.y=y;
    }


}



