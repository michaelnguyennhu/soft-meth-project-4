package main;

public class Coffee extends MenuItem implements Customizable {

    private static final int SHORT = 0;
    private static final int TALL = 1;
    private static final int GRANDE = 2;
    private static final int VENTI = 3;
    private static final float SHORT_BLACK = 1.99f;
    private static final float NEXT_SIZE_PRICE = 0.50f;
    private int size;

    private static final float ADDIN_PRICE = 0.20f;
    private int numAddIns;
    private AddIns addIns;


    public Coffee(int newSize){
        super();
        this.size = newSize;
        this.numAddIns = 0;
        this.addIns = new AddIns();
    }

    @Override
    public void itemPrice(){
        this.price = SHORT_BLACK;
        for (int i = 0; i < this.size; i++){
            this.price += NEXT_SIZE_PRICE;
        }

        for (int i = 0; i < this.numAddIns; i++){
            this.price += ADDIN_PRICE;
        }
    }

    public void changeSize(int newSize){
        this.size = newSize;
    }

    public int getSize(){
        return this.size;
    }

    public int getNumAddIns(){
        return this.numAddIns;
    }

    public AddIns getAddIns(){
        return this.addIns;
    }

    public void setAddIns(AddIns newAddIns){
        this.addIns.setCream(newAddIns.getCream());
        this.addIns.setSyrup(newAddIns.getSyrup());
        this.addIns.setMilk(newAddIns.getMilk());
        this.addIns.setCaramel(newAddIns.getCaramel());
        this.addIns.setWhippedCream(newAddIns.getWhippedCream());
        this.numAddIns = this.addIns.getTotalAddIns();
    }



    //add and remove are the same here. lmk if you think of a different way to deal with addins
    @Override
    public boolean add(Object obj){
        if ( !(obj instanceof AddIns) ){
            return false;
        }

        AddIns moreAddIns = (AddIns) obj;


        if (moreAddIns.getCream()){
            this.addIns.setCream(true);
        }

        if (moreAddIns.getSyrup()){
            this.addIns.setSyrup(true);
        }

        if (moreAddIns.getMilk()){
            this.addIns.setMilk(true);
        }

        if (moreAddIns.getCaramel()){
            this.addIns.setCaramel(true);
        }

        if (moreAddIns.getWhippedCream()){
            this.addIns.setWhippedCream(true);
        }

        this.numAddIns = this.addIns.getTotalAddIns();
        return true;
    }


    @Override
    public boolean remove(Object obj){

        if ( !(obj instanceof AddIns) ){
            return false;
        }

        AddIns moreAddIns = (AddIns) obj;

        if (moreAddIns.getCream()){
            this.addIns.setCream(false);
        }

        if (moreAddIns.getSyrup()){
            this.addIns.setSyrup(false);
        }

        if (moreAddIns.getMilk()){
            this.addIns.setMilk(false);
        }

        if (moreAddIns.getCaramel()){
            this.addIns.setCaramel(false);
        }

        if (moreAddIns.getWhippedCream()){
            this.addIns.setWhippedCream(false);
        }

        this.numAddIns = this.addIns.getTotalAddIns();
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Coffee) ){
            return false;
        }

        Coffee otherCoffee = (Coffee) obj;

        if ( (this.size == otherCoffee.getSize()) && (this.numAddIns == otherCoffee.getNumAddIns()) ){
            return this.addIns.equals(otherCoffee.getAddIns());
        }
        else {
            return false;
        }

    }
    @Override
    public String toString(){
        String coffeeString = "";


        if (this.size == SHORT ){
            if (numAddIns == 0){
                coffeeString = "Short Black Coffee";
            }
            else {
                coffeeString = "Short Coffee:" + this.addIns.toString();
            }
        }
        else if (this.size == TALL){
            if (numAddIns == 0){
                coffeeString = "Tall Black Coffee";
            }
            else {
                coffeeString = "Tall Coffee:" + this.addIns.toString();
            }
        }
        else if (this.size == GRANDE){
            if (numAddIns == 0){
                coffeeString = "Grande Black Coffee";
            }
            else {
                coffeeString = "Grande Coffee:" + this.addIns.toString();
            }
        }
        else if (this.size == VENTI){
            if (numAddIns == 0){
                coffeeString = "Venti Black Coffee";
            }
            else {
                coffeeString = "Venti Coffee:" + this.addIns.toString();
            }
        }


        return coffeeString;
    }
}
