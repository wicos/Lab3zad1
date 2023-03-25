import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj stopien pierwszego wielomianu: ");
        int n1 = scanner.nextInt();
        double[] wspolczynnik1 = new double[n1 + 1];
        System.out.println("Podaj wspolczynniki wielomianu (od najwyższej potegi):");
        for (int i = n1; i >= 0; i--) {
            System.out.print("x^" + i + ": ");
            wspolczynnik1[i] = scanner.nextDouble();
        }
        Wielomian wielomian1 = new Wielomian(n1, wspolczynnik1);


        System.out.print("Podaj stopien drugiego wielomianu: ");
        int n2 = scanner.nextInt();
        double[] wspolczynnik2 = new double[n2 + 1];
        System.out.println("Podaj wspolczynniki wielomianu (w kolejnosci od najwyższej potegi):");
        for (int i = n2; i >= 0; i--) {
            System.out.print("x^" + i + ": ");
            wspolczynnik2[i] = scanner.nextDouble();
        }
        Wielomian wielomian2 = new Wielomian(n2, wspolczynnik2);


        System.out.println("Wielomian nr 1:");
        wielomian1.wypisz();
        System.out.println("Wielomian nr 2:");
        wielomian2.wypisz();

        Wielomian suma = wielomian1.dodawanie (wielomian2);
        System.out.println("Wynik suma:");
        suma.wypisz();

        Wielomian roznica = wielomian1.odejmowanie (wielomian2);
        System.out.println("Wynik Roznica:");
        roznica.wypisz();

        Wielomian iloczyn = wielomian1.mnozenie (wielomian2);
        System.out.println("Iloczyn wielomianow:");
        iloczyn.wypisz();

        System.out.print("Podaj wartosc x: ");
        double x = scanner.nextDouble();
        try {
            double wynik1 = wielomian1.oblicz(x);
            System.out.println("Wartosc pierwszego wielomianu dla x=" + x + " wynosi: " + wynik1);
            double wynik2 = wielomian2.oblicz(x);
            System.out.println("Wartosc drugiego wielomianu dla x=" + x + " wynosi: " + wynik2);
        } catch (IllegalArgumentException e) {
            System.out.println("Wartosc X nie jest prawidlowa. " + e.getMessage());
        }
    }
}
