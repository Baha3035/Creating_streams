package kg.megacom;

public class Goods {
    private int price;
    private Country_maker maker;
    private String name;

    public Goods() {
    }

    public Goods(int price, Country_maker maker, String name) {
        this.price = price;
        this.maker = maker;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Country_maker getMaker() {
        return maker;
    }

    public void setMaker(Country_maker maker) {
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
