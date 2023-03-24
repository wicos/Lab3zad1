import java.util.Scanner;

public class Wielomian {
    private int n;
    private double[] wspolczynniki;

    public Wielomian(int n, double[] wspolczynnik1) {
        this.n = n;
        this.wspolczynniki = new double[n+1];
        Scanner scanner = new Scanner(System.in);
        for (int i = n; i >= 0; i--) {
            System.out.print("Podaj współczynnik do potęgi " + i + ": ");
            this.wspolczynniki[i] = scanner.nextDouble();
        }
    }

    public Wielomian dodaj(Wielomian W) {
        if (this.n != W.n) {
            throw new IllegalArgumentException("Wielomiany muszą mieć ten sam stopień");
        }
        Wielomian wynik = new Wielomian(this.n, wspolczynniki);
        for (int i = 0; i <= this.n; i++) {
            wynik.wspolczynniki[i] = this.wspolczynniki[i] + W.wspolczynniki[i];
        }
        return wynik;
    }

    public Wielomian odejmij(Wielomian W) {
        if (this.n != W.n) {
            throw new IllegalArgumentException("Wielomiany muszą mieć ten sam stopień");
        }
        Wielomian wynik = new Wielomian(this.n, wspolczynniki);
        for (int i = 0; i <= this.n; i++) {
            wynik.wspolczynniki[i] = this.wspolczynniki[i] - W.wspolczynniki[i];
        }
        return wynik;
    }

    public Wielomian pomnoz(Wielomian W) {
        int stopien = this.n + W.n;
        Wielomian wynik = new Wielomian(stopien, wspolczynniki);
        for (int i = 0; i <= this.n; i++) {
            for (int j = 0; j <= W.n; j++) {
                wynik.wspolczynniki[i+j] += this.wspolczynniki[i] * W.wspolczynniki[j];
            }
        }
        return wynik;
    }

    public void wypisz() {
        System.out.print("Wielomian: ");
        for (int i = n; i >= 0; i--) {
            System.out.print(this.wspolczynniki[i] + "x^" + i);
            if (i > 0) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public double oblicz(double x) {
        if (x > 120 || x < -100) {
            throw new IllegalArgumentException("x musi być z przedziału [-100, 120]");
        }
        double wynik = 0;
        for (int i = n; i >= 0; i--) {
            wynik += this.wspolczynniki[i] * Math.pow(x, i);
        }
        return wynik;
    }
}