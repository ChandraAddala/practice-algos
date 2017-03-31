package practice.java8;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class Problems {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> transInYear2011 = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted((x, y) -> Integer.compare(x.getValue(), y.getValue()))
                .collect(toList());
        System.out.println("All transactions in the year 2011: " + transInYear2011);

        // What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
        System.out.println("Unique cities: " + uniqueCities);

        //Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = transactions.stream()
                                                        .map(Transaction::getTrader)
                                                        .filter(x -> x.getCity().equals("Cambridge"))
                                                        .distinct()
                                                        .sorted(comparing(Trader::getName))
                                                        .collect(toList());
        System.out.println("All traders from Cambridge: " + tradersFromCambridge);

        //Return a string of all traders’ names sorted alphabetically.
        String trandersNames = transactions.stream()
                                           .map(x -> x.getTrader().getName())
                                           .distinct()
                                           .sorted()
                                           .reduce("", (a, b) -> a + " " + b);
        System.out.println("A string of all traders’ names sorted alphabetically: " + trandersNames);

        //Are any traders based in Milan?
        boolean isMilanTraderExist = transactions.stream()
                                                 .map(Transaction::getTrader)
                                                 .anyMatch(x -> x.getCity().equals("Milan"));
        System.out.println("isMilanTraderExist=" + isMilanTraderExist);

        //Print all transactions’ values from the traders living in Cambridge.
        System.out.println("all transactions’ values from the traders living in Cambridge:");
        transactions.stream()
                    .filter(x -> x.getTrader().getCity() == "Cambridge")
                    .forEach(System.out::println);

        //What’s the highest value of all the transactions?
        int highestValue = transactions.stream()
                                       .map(Transaction::getValue)
                                       .max(Integer::compare)
                                       .get();
        System.out.println("highestValue: " + highestValue);

        //Find the transaction with the smallest value.
        Transaction transWithSmallValue = transactions.stream()
                                              .min(comparing(Transaction::getValue)).get();

        System.out.println("transWithSmallValue: " + transWithSmallValue);

        //Group a list of transactions by year.
        Map<Integer, Integer> groupByYear =
                transactions.stream()
                            .collect(groupingBy(Transaction::getYear, summingInt(Transaction::getValue)));

        groupByYear.forEach((k, v) -> System.out.println(k + ":" + v));

        //Partition a list of transactions into two groups: expensive and not expensive
        Map<Boolean, List<Transaction>> groupByExpense =
                transactions.stream()
                            .collect(groupingBy(x -> x.getValue() > 500, toList()));

        groupByExpense.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, Map<Boolean, List<Transaction>>> groupByCitiesAndExpense =
                transactions.stream()
                            .collect(groupingBy(x -> x.getTrader().getCity(),
                                    groupingBy(x -> x.getValue() > 500, toList())));

        groupByCitiesAndExpense.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
