import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;



public  class One {
    public static void main(String[] args) {

        /**
         asList("A", "BB", "CCC").stream()
         .filter(s -> s.length() > 1)    // s - аргумент,s.length() > 1 - тело(к аргументам применяет тело)
         // filter - оставляет только тех для кого тело true
         .map(String::length)
         .forEach(System.out::println);

         */

        /**
         asList("A", "BB", "CCC").stream()
         .filter(new Predicate<String>() {
        @Override
        public boolean test(String s) {
        return s.length() > 1;
        }
        })
         .forEach(new Consumer<String>() {
        @Override
        public void accept(String x) {
        System.out.println(x);
        }
        });
         */

        /**
         asList("A", "BB", "CCC").parallelStream()
         .forEach(System.out::println);
         */


        List<String> arg0 = asList("1", "2", "3");
        List<String> arg1 = asList("A", "B");

        for(List<String> elem : mul1(arg0,arg1)){
            System.out.println(elem);
        }

        mul2(arg0, arg1).forEach(System.out::println);


    }

    public static <T> List<List<T>> mul1(List<T> arg0, List<T> arg1){
        List<List<T>> result = new ArrayList<>();
        for(T fst : arg0){
            for (T snd : arg1){
                result.add(asList(fst,snd));
            }
        }
        return result;
    }

    public static <T> Stream<List<T>> mul2(List<T> arg0, List<T> arg1){
        return arg0.stream().flatMap(fst -> arg1.stream().map(snd -> Arrays.asList(fst, snd)));
    }

}

