package kg.megacom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Goods> goods = new ArrayList<>();
            goods.add(new Goods(1300, Country_maker.USA, "Banana"));
            goods.add(new Goods(1550, Country_maker.USA, "Orange"));
            goods.add(new Goods(1000, Country_maker.KYRGYZSTAN, "Silk"));
            goods.add(new Goods(2300, Country_maker.INDIA, "Milk"));
            goods.add(new Goods(800, Country_maker.KAZAKHSTAN, "Apple"));
            goods.add(new Goods(700, Country_maker.KYRGYZSTAN, "Mineral water"));
            goods.add(new Goods(1200, Country_maker.INDIA, "Pineapple"));


        List<Goods> bestGoods = goods.stream().
                filter(good -> good.getPrice() > 1250)
                .filter(good -> good.getMaker() == Country_maker.USA || good.getMaker() == Country_maker.INDIA)
                .collect(Collectors.toList());

        List<Goods> worstGoods = goods.stream().
                filter(good -> good.getPrice() < 1250)
                .filter(good -> good.getMaker() == Country_maker.KYRGYZSTAN || good.getMaker() == Country_maker.KAZAKHSTAN)
                .collect(Collectors.toList());

        List<List<Goods>> allLists = new ArrayList<>(); // Creating a list for all lists of goods (mainly the best and the worst)
        allLists.add(bestGoods);
        allLists.add(worstGoods);



            Countable countOfPrice = bestGood -> bestGood.get(0).getPrice()
                + bestGood.get(1).getPrice(); //Declaring a functional interface



        allLists.forEach(goodList -> System.out.println(countOfPrice.countOfPriceOfTwoGoods(goodList)));
    }
}
@FunctionalInterface
interface Countable{
    int countOfPriceOfTwoGoods(List<Goods> list);
}
