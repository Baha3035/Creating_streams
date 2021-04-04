package kg.megacom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        goods.add(new Goods(701, Country_maker.USA, "Mineral water"));
        goods.add(new Goods(702, Country_maker.KAZAKHSTAN, "Mineral water"));
        goods.add(new Goods(1200, Country_maker.INDIA, "Pineapple"));
        goods.add(new Goods(1990, Country_maker.INDIA, "Black berry"));
        goods.add(new Goods(3000, Country_maker.KYRGYZSTAN, "Cotton"));
        goods.add(new Goods(1500, Country_maker.USA, "Cow meat"));
        goods.add(new Goods(1400, Country_maker.KAZAKHSTAN, "Goat meat"));
        goods.add(new Goods(1000, Country_maker.USA, "Basketball ball"));
        goods.add(new Goods(800, Country_maker.KYRGYZSTAN, "Onion"));
        goods.add(new Goods(7000, Country_maker.INDIA, "Iron"));
        goods.add(new Goods(600, Country_maker.KAZAKHSTAN, "Carrot"));
        goods.add(new Goods(4000, Country_maker.USA, "Ice"));
        goods.add(new Goods(40000, Country_maker.INDIA, "Ketone"));

        Stream<Goods> streamOfGoods = goods.stream();
            long countOfGoods = streamOfGoods.filter(good -> good.getMaker() ==
                    Country_maker.KYRGYZSTAN).count();

        Stream<Goods> streamOfDistinctGoods = goods.stream();
            long countOfDistinctGoods = streamOfDistinctGoods.filter(good -> good.getMaker() ==
                    Country_maker.KYRGYZSTAN).distinct().count();
        System.out.println("Count of goods from Kyrgyzstan: " + countOfGoods);
        System.out.println("Count of distinct goods from Kyrgyzstan: " + countOfDistinctGoods);



        Stream<Goods> streamOfGoods2 = Stream.of(new Goods(1300, Country_maker.USA, "Banana"),
                new Goods(1550, Country_maker.USA, "Orange"),
                new Goods(1000, Country_maker.KYRGYZSTAN, "Silk"),
                new Goods(2300, Country_maker.INDIA, "Milk"),
                new Goods(800, Country_maker.KAZAKHSTAN, "Apple"),
                new Goods(700, Country_maker.KYRGYZSTAN, "Mineral water"),
                new Goods(1200, Country_maker.INDIA, "Pineapple"),
                new Goods(1500, Country_maker.INDIA, "Black berry"));

        System.out.println("Count of goods after discarding first 3 goods: " + streamOfGoods2.skip(3).count());


        System.out.println(" ");
        Stream<Goods> streamOfGoods3 = Arrays.stream(goods.toArray(new Goods[0]));

        IntStream streamOfPrices = streamOfGoods3.filter(good -> good.getPrice() > 3000).mapToInt(Goods::getPrice);
        System.out.println("List of prices of goods' stream here: ");
        streamOfPrices.forEach(System.out::println);

        System.out.println(" ");


            IntStream streamFromNames1 = goods.get(0).getName().chars();
            IntStream streamFromNames2 = goods.get(1).getName().chars();
            IntStream streamFromNames3 = goods.get(2).getName().chars();
                System.out.println("There are '" +
                        streamFromNames1.filter(x -> x % 2 == 0).count() +
                        "' even numbers");

                System.out.println("There are '" +
                        streamFromNames2.filter(x -> x % 2 != 0).count() +
                        "' odd numbers");

                System.out.println("There are '" +
                        streamFromNames3.filter(x -> x % 24 == 0).count() +
                        "' numbers divisible by 24");



        Stream<Object> streamOfGoodsWithBuilder = Stream.<Object>builder().add(new Goods(1300, Country_maker.USA, "Banana")).
                add(new Goods(1550, Country_maker.USA, "Orange")).
                add(new Goods(1000, Country_maker.KYRGYZSTAN, "Silk")).
                add(new Goods(2300, Country_maker.INDIA, "Milk")).
                add(new Goods(800, Country_maker.KAZAKHSTAN, "Apple")).
                add(new Goods(700, Country_maker.KYRGYZSTAN, "Mineral water")).
                add(new Goods(1200, Country_maker.INDIA, "Pineapple")).
                add(new Goods(1500, Country_maker.INDIA, "Black berry")).build();

        System.out.println(" ");
        System.out.println("Here is the list of the elements in the stream from builder:");
        streamOfGoodsWithBuilder.forEach(System.out::println);
    }
}

