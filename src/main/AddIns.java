package main;

public class AddIns {

    private boolean cream;
    private boolean syrup;
    private boolean milk;
    private boolean caramel;
    private boolean whippedCream;


    public AddIns(){
        this.cream = false;
        this.syrup = false;
        this.milk = false;
        this.caramel = false;
        this.whippedCream = false;
    }

    public int getTotalAddIns(){
        int totalAddIns = 0;
        if (this.cream){
            totalAddIns++;
        }
        if (this.syrup){
            totalAddIns++;
        }
        if (this.milk){
            totalAddIns++;
        }
        if (this.caramel){
            totalAddIns++;
        }
        if (this.whippedCream){
            totalAddIns++;
        }

        return totalAddIns;
    }


    public boolean getCream(){
        return this.cream;
    }
    public boolean getSyrup(){
        return this.syrup;
    }
    public boolean getMilk(){
        return this.milk;
    }
    public boolean getCaramel(){
        return this.caramel;
    }
    public boolean getWhippedCream(){
        return this.whippedCream;
    }


    public void setCream(boolean added){
        this.cream = added;
    }
    public void setSyrup(boolean added){
        this.syrup = added;
    }
    public void setMilk(boolean added){
        this.milk = added;
    }
    public void setCaramel(boolean added){
        this.caramel = added;
    }
    public void setWhippedCream(boolean added){
        this.whippedCream = added;
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

    @Override
    public String toString() {
        String addInString = "";
        if (this.cream){
            addInString = addInString + "Cream:";
        }
        if (this.syrup){
            addInString = addInString + "Syrup:";
        }
        if (this.milk){
            addInString = addInString + "Milk:";
        }
        if (this.caramel){
            addInString = addInString + "Caramel:";
        }
        if (this.cream){
            addInString = addInString + "Cream:";
        }

        return addInString;
    }
}
