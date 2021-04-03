package main;

public class AddIns {

    private int cream;
    private int syrup;
    private int milk;
    private int caramel;
    private int whippedCream;


    public AddIns(){
        this.cream = 0;
        this.syrup = 0;
        this.milk = 0;
        this.caramel = 0;
        this.whippedCream = 0;
    }

    public int getTotalAddIns(){
        return (this.cream + this.syrup + this.milk + this.caramel + this.whippedCream);
    }


    public int getCream(){
        return this.cream;
    }
    public int getSyrup(){
        return this.syrup;
    }
    public int getMilk(){
        return this.milk;
    }
    public int getCaramel(){
        return this.caramel;
    }
    public int getWhippedCream(){
        return this.whippedCream;
    }


    public void setCream(int quantity){
        this.cream = quantity;
    }
    public void setSyrup(int quantity){
        this.syrup = quantity;
    }
    public void setMilk(int quantity){
        this.milk = quantity;
    }
    public void setCaramel(int quantity){
        this.caramel = quantity;
    }
    public void setWhippedCream(int quantity){
        this.whippedCream = quantity;
    }


    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof AddIns) ){
            return false;
        }
        AddIns otherAddIns = (AddIns) obj;

        if ( (this.cream == otherAddIns.getCream()) && (this.syrup == otherAddIns.getSyrup()) && (this.milk == otherAddIns.getMilk()) && (this.caramel == otherAddIns.getCaramel()) && (this.whippedCream == otherAddIns.getWhippedCream()) ) {
            return true;
        }
        else {
            return false;
        }

    }
}
