package sample;

public class Coffee extends MenuItem implements Customizable {

    private static final int SHORT = 0;
    private static final int TALL = 1;
    private static final int GRANDE = 2;
    private static final int VENTI = 3;
    private static final float SHORTBLACK = 1.99f;
    private static final float NEXTSIZEPRICE = 0.50f;
    private int size;

    private static final float ADDINPRICE = 0.20f;
    private int addIns;


    public Coffee(int newSize, int numOfAddIns){
        super();
        this.size = newSize;
        this.addIns = numOfAddIns;
    }

    @Override
    public void itemPrice(){
        this.price = SHORTBLACK;
        for (int i = 0; i < this.size; i++){
            this.price += NEXTSIZEPRICE;
        }

        for (int i = 0; i < this.addIns; i++){
            this.price += ADDINPRICE;
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
