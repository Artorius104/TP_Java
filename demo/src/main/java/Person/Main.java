package Person;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Main(long id, String firstName, String lastName, LocalDate birthDate) {

    // 3.1 Opérations sur les streams

    public static Stream<Main> filterByLastName(Stream<Main> persons, String lastName) {
        return persons.filter(person -> person.lastName().equals(lastName));
    }

    public static Stream<Main> filterByAgeAbove18(Stream<Main> persons) {
        return persons.filter(person -> calculateAge(person.birthDate()) > 18);
    }

    public static Stream<Main> filterBySameFirstNameLastName(Stream<Main> persons) {
        return persons.filter(person -> person.firstName().equals(person.lastName()));
    }

    public static Stream<String> distinctUpperCaseLastNames(Stream<Main> persons) {
        return persons.map(person -> person.lastName().toUpperCase()).distinct();
    }

    public static List<Main> sortedByBirthDate(Stream<Main> persons) {
        return persons.sorted(Comparator.comparing(Main::birthDate)).collect(Collectors.toList());
    }

    // 3.2 Opérations sur les collections

    public static List<Main> onlyAdults(List<Main> persons) {
        return persons.stream().filter(person -> calculateAge(person.birthDate()) > 18).collect(Collectors.toList());
    }

    public static double averageAge(List<Main> persons) {
        return persons.stream().mapToInt(person -> calculateAge(person.birthDate())).average().orElse(0);
    }

    public static String lastNamesSeparatedWithSpace(List<Main> persons) {
        return persons.stream().map(Main::lastName).collect(Collectors.joining(" "));
    }

    public static Map<String, List<Main>> groupByFirstName(List<Main> persons) {
        return persons.stream().collect(Collectors.groupingBy(Main::firstName));
    }

    // Méthode utilitaire pour calculer l'âge à partir de la date de naissance
    private static int calculateAge(LocalDate birthDate) {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public static void main(String[] args) {
        // Création d'une liste d'objets Personne
        List<Main> personList = Arrays.asList(
                new Main(1, "John", "Doe", LocalDate.of(1990, 5, 15)),
                new Main(2, "Jane", "Smith", LocalDate.of(1985, 7, 20)),
                new Main(3, "Alice", "Alice", LocalDate.of(1999, 3, 10)),
                new Main(4, "Bob", "Bob", LocalDate.of(2005, 12, 3)),
                new Main(5, "Eve", "Doe", LocalDate.of(1980, 2, 28))
        );

        // 3.1 Opérations sur les streams
        Stream<Main> filteredByLastName = filterByLastName(personList.stream(), "Doe");
        System.out.println("Filtered by Last Name: " +
                filteredByLastName.collect(Collectors.toList()));

        Stream<Main> filteredByAgeAbove18 = filterByAgeAbove18(personList.stream());
        System.out.println("Filtered by Age Above 18: " +
                filteredByAgeAbove18.collect(Collectors.toList()));

        Stream<Main> filteredBySameFirstNameLastName = filterBySameFirstNameLastName(personList.stream());
        System.out.println("Filtered by Same First Name and Last Name: " +
                filteredBySameFirstNameLastName.collect(Collectors.toList()));

        Stream<String> distinctLastNames = distinctUpperCaseLastNames(personList.stream());
        System.out.println("Distinct Last Names in Uppercase: " +
                distinctLastNames.collect(Collectors.toList()));

        List<Main> sortedByBirthDate = sortedByBirthDate(personList.stream());
        System.out.println("Sorted by Birth Date: " + sortedByBirthDate);

        // 3.2 Opérations sur les collections
        List<Main> adults = onlyAdults(personList);
        System.out.println("Adults: " + adults);

        double averageAge = averageAge(personList);
        System.out.println("Average Age: " + averageAge);

        String lastNames = lastNamesSeparatedWithSpace(personList);
        System.out.println("Last Names Separated with Space: " + lastNames);

        Map<String, List<Main>> groupedByFirstName = groupByFirstName(personList);
        System.out.println("Grouped by First Name: " + groupedByFirstName);
    }
}
