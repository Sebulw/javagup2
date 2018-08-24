package password.manager.sandbox;

import org.apache.commons.text.StrBuilder;
import password.manager.model.PasswordEntry;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

class StreamsMain {


    @Deprecated
    private static Comparator<String> byLength = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };

    public static void main(String[] args) throws CloneNotSupportedException {

        String st = "";

        StrBuilder sb = new StrBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("A").append(i);
        }

        PasswordEntry build = PasswordEntry.Builder.of()
                .withLogin("xenteros")
                .withWebsite("facebook")
                .withPassword("pass")
                .build();

        BB bb = new BB();


        Dog d = new Dog("Fifi");
        barkify(d);
        System.out.println(d.toString());
        burkify(d);
        System.out.println(d.toString());



        String s = "ABC";
        String str = new String("ABC");
        str = str.intern();

        System.out.println(s==str);


        List<String> names = StringCollections.names();
//        System.out.println(zadanie7a(names));
        List<StringWithOccurenceCount> collect =
                zadanie7(names).entrySet()
                        .stream()
                        .map(entry -> new StringWithOccurenceCount(entry.getKey(), entry.getValue()))
                        .sorted(comparingLong(StringWithOccurenceCount::getOccurrences)
                                .reversed())
                        .collect(toList());
//        System.out.println(collect);
    }

    public static void barkify(Dog d) {
//        System.out.println(d.toString());
        d = new Dog("Bark");
//        System.out.println(d.toString());
    }

    public static void burkify(Dog d) {
        d.setName("Burk");
    }


    private static Collection<String> zadanie1(List<String> names) {
        return names.stream()
                .filter(name -> name.length() <= 4)
                .map(String::toLowerCase)
                .collect(toList());
    }

    private static Collection<String> zadanie2(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("B"))
                .distinct()
                .collect(toList());
    }

    private static Collection<String> zadanie3(List<String> names) {
        return names.stream()
                .map(s -> s.substring(0, 3).toUpperCase())
                .distinct()
                .collect(toList());
    }

    private static Collection<String> zadanie4(List<String> names) {
        return names.stream()
                .distinct()
                .sorted(comparingInt(String::length).reversed())
                .limit(10)
                .collect(toList());
    }

    private static Collection<String> zadanie5(List<String> names) {
        return names.stream()
                .distinct()
                .sorted(comparingInt(String::length)
                        .thenComparing(s -> s.substring(s.length() - 1)))
                .limit(5)
                .sorted(comparingInt(String::length).reversed())
                .collect(toList());
    }

    private static Collection<String> zadanie6(List<String> names) {
        return names.stream()
                .filter(s -> s.substring(0, 3).contains("A") || s.substring(0, 3).contains("a"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(toList());
    }

    private static Map<String, Long> zadanie7(List<String> names) {
        return names.stream()
                .collect(groupingBy(identity(), Collectors.counting()));
    }

    private static Map<Integer, List<String>> zadanie7a(List<String> names) {
        return names.stream()
                .distinct()
                .collect(groupingBy(String::length, toList()));
    }

    private static List<String> zadanie8(List<String> names) {
        return names.stream()
                .flatMap(name -> Arrays.stream(name.split("")))
                .map(String::toLowerCase)
                .distinct()
                .collect(toList());
    }

    private static List<String> zadanie9(List<String> names) {
        return names.stream()
                .filter(s -> s.startsWith("B") && (s.length() == 7 || s.length() == 6))
                .flatMap(name -> Arrays.stream(name.split("")))
                .map(String::toLowerCase)
                .distinct()
                .sorted(naturalOrder())
                .collect(toList());
    }


}
