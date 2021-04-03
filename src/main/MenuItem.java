package main;

public class MenuItem {
    protected float price;

    public MenuItem(){
        this.price = 0;
    }

    public void itemPrice(){
    }


    public float getItemPrice(){
        return this.price;
    }


    @Override
    public boolean equals(Object obj){

        if ( (this instanceof Coffee) && (obj instanceof Coffee)){
            Coffee thisCoffee = (Coffee) this;
            Coffee otherCoffee = (Coffee) obj;
            return thisCoffee.equals(otherCoffee);
        }
        else if ( (this instanceof Donut) && (obj instanceof Donut) ){
            Donut thisDonut = (Donut) this;
            Donut otherDonut = (Donut) obj;
            return thisDonut.equals(otherDonut);
        }
        else {
            return false;
        }

    }
}
