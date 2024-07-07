# TP_Java

Exercice 1

Question 1
Non. L'interface Gojo ne possède pas de méthode abstraite, donc elle ne peut pas être une interface fonctionnelle.

Question 2
Oui. L'interface Sayen possède une méthode abstraite, donc il s'agit d'une interface fonctionnelle.

Question 3
Oui. L'interface Sayen possède une méthode abstraite, donc il s'agit d'une interface fonctionnelle.

Question 4
Oui. L'interface Bandit possède une méthode abstraite, donc il s'agit d'une interface fonctionnelle.

Question 5
Oui. L'interface Pokemon possède une méthode abstraite et elle n'a pas besoin d'être public pour être une interface fonctionnelle, donc il s'agit d'une interface fonctionnelle.

Question 6
Oui. Le mot clé @FunctionalInterface indique que l'interface est fonctionnelle et elle possède une méthode abstraite.

Question 7
Oui. Le mot clé @FunctionalInterface indique que l'interface est fonctionnelle et elle possède qu'une méthode abstraite car la méthode escroquer() ne l'est pas.

Question 8
Non. L'interface Influvoleur est fonctionnelle mais Berdat ne l'est pas car elle possède 2 méthodes abstraites: escroquerlesvieux() et pleurersurinternet()

Question 9
Oui. L'interface Gojo est fonctionnelle car elle n'a qu'une méthode abstraite et Exorciste n'en contient pas.


Exercice 2

Question 1
Chakra<T> lambda = () -> value;
exemple :
Chakra<Integer> lambda = () -> 5;

Question 2
Spell<String> lambda = (s) -> {
    System.out.println("Casting spell with: " + s);
};

Question 3
Function<String, Integer> lambda = (s) -> s.length();

Question 4
BiFunction<Integer, Integer, Integer> lambda = (a, b) -> a + b;

Question 5
ObjLongConsumer<String> lambda = (s, l) -> System.out.println(s + l);

Question 6
IntUnaryOperator lambda = (operand) -> operand * operand;

Question 7
TemporalQuery<DayOfWeek> query = (temp) -> LocalDate.from(temp).getDayOfWeek();

Question 8
Callback<Integer, String> callback = (param) -> {
    int result = param * 2;
    return "Le résultat de la multiplication est : " + result;
};


