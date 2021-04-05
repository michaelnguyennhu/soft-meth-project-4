package main;

public class Donut extends MenuItem {

    private static final int YEAST = 0;
    private static final float YEAST_PRICE = 1.39f;
    private static final int CAKE = 1;
    private static final float CAKE_PRICE = 1.59f;
    private static final int HOLE = 2;
    private static final float HOLE_PRICE = 0.33f;
    private int donutType;

    //make variables for the donut flavors
    private static final int GLAZED = 0;
    private static final int CHOCOLATE = 1;
    private static final int VANILLA = 2;
    private int donutFlavor;

    public Donut(int chooseType, int chooseFlavor){
        super();
        this.donutType = chooseType;
        this.donutFlavor = chooseFlavor;
    }

    public void changeType(int chooseType){
        this.donutType = chooseType;
    }

    public void changeFlavor(int chooseFlavor){
        this.donutFlavor = chooseFlavor;
    }

    public int getType(){
        return this.donutType;
    }

    public int getFlavor(){
        return this.donutFlavor;
    }


    @Override
    public void itemPrice(){
        if (this.donutType == YEAST){
            this.price = YEAST_PRICE;

        }
        else if (this.donutType == CAKE){
            this.price = CAKE_PRICE;
        }
        else if (this.donutType == HOLE){
            this.price = HOLE_PRICE;
        }
        else {
            throw new RuntimeException("Invalid donut type specified.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Donut) ){
            return false;
        }

        Donut otherDonut = (Donut) obj;
        if ( (this.donutType == otherDonut.getType()) && (this.donutFlavor == otherDonut.getFlavor()) ){
            return true;
        }
        else {
            return false;
        }
    }


}
