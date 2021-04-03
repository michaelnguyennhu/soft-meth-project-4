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



    //add and remove are the same here. lmk if you think of a different way to deal with addins
    @Override
    public boolean add(Object obj){
        if ( !(obj instanceof AddIns) ){
            return false;
        }

        AddIns moreAddIns = (AddIns) obj;
        this.addIns = moreAddIns;

        this.numAddIns = this.addIns.getTotalAddIns();

        return true;
    }


    @Override
    public boolean remove(Object obj){

        if ( !(obj instanceof AddIns) ){
            return false;
        }

        AddIns moreAddIns = (AddIns) obj;
        this.addIns = moreAddIns;

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
}
