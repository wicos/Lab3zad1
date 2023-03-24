import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // wczytanie stopnia i współczynników pierwszego wielomianu
        System.out.print("Podaj stopień pierwszego wielomianu: ");
        int n1 = scanner.nextInt();
        double[] wspolczynnik1 = new double[n1 + 1];
        System.out.println("Podaj współczynniki wielomianu (w kolejności od najwyższej potęgi):");
        for (int i = n1; i >= 0; i--) {
            System.out.print("x^" + i + ": ");
            wspolczynnik1[i] = scanner.nextDouble();
        }
        Wielomian wielomian1 = new Wielomian(n1, wspolczynnik1);

        // wczytanie stopnia i współczynników drugiego wielomianu
        System.out.print("Podaj stopień drugiego wielomianu: ");
        int n2 = scanner.nextInt();
        double[] wspolczynnik2 = new double[n2 + 1];
        System.out.println("Podaj współczynniki wielomianu (w kolejności od najwyższej potęgi):");
        for (int i = n2; i >= 0; i--) {
            System.out.print("x^" + i + ": ");
            wspolczynnik2[i] = scanner.nextDouble();
        }
        Wielomian wielomian2 = new Wielomian(n2, wspolczynnik2);

        // wypisanie obu wielomianów
        System.out.println("Wielomian 1:");
        wielomian1.wypisz();
        System.out.println("Wielomian 2:");
        wielomian2.wypisz();

        // dodawanie wielomianów
        Wielomian suma = wielomian1.dodaj (wielomian2);
        System.out.println("Suma wielomianów:");
        suma.wypisz();

        // odejmowanie wielomianów
        Wielomian roznica = wielomian1.odejmij (wielomian2);
        System.out.println("Różnica wielomianów:");
        roznica.wypisz();

        // mnożenie wielomianów
        Wielomian iloczyn = wielomian1.pomnoz (wielomian2);
        System.out.println("Iloczyn wielomianów:");
        iloczyn.wypisz();

        // obliczanie wartości wielomianów dla podanej wartości x
        System.out.print("Podaj wartość x: ");
        double x = scanner.nextDouble();
        try {
            double wynik1 = wielomian1.oblicz(x);
            System.out.println("Wartość pierwszego wielomianu dla x=" + x + " wynosi: " + wynik1);
            double wynik2 = wielomian2.oblicz(x);
            System.out.println("Wartość drugiego wielomianu dla x=" + x + " wynosi: " + wynik2);
        } catch (IllegalArgumentException e) {
            System.out.println("Podana wartość x jest nieprawidłowa. " + e.getMessage());
        }
    }
}
