package sample;

public class Donut extends MenuItem implements Customizable{

    private static final int YEAST = 0;
    private static final float YEASTPRICE = 1.39f;
    private static final int CAKE = 1;
    private static final float CAKEPRICE = 1.59f;
    private static final int HOLE = 2;
    private static final float HOLEPRICE = 0.33f;
    private int donutType;
    //may need to include donut flavors

    public Donut(int chooseType){
        super();
        this.donutType = chooseType;
    }

    @Override
    public void itemPrice(){
        if (this.donutType == YEAST){
            this.price = YEASTPRICE;

        }
        else if (this.donutType == CAKE){
            this.price = CAKEPRICE;
        }
        else if (this.donutType == HOLE){
            this.price = HOLEPRICE;
        }
        else {
            throw new RuntimeException("Invalid donut type specified.");
        }
    }


    @Override
    public boolean add(Object obj){
        return false;
    }

    @Override
    public boolean remove(Object obj){
        return false;
    }
}
