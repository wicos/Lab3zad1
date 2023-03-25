import java.util.Scanner;

public class Wielomian {
    private int n;
    private double[] wspol;

    public Wielomian(int n, double[] wspolczynnik1) {
        this.n = n;
        this.wspol = new double[n+1];
        Scanner scanner = new Scanner(System.in);
        for (int i = n; i >= 0; i--) {
            System.out.print("Podaj wspolczynnik do potęgi " + i + ": ");
            this.wspol[i] = scanner.nextDouble();
        }
    }

    public Wielomian dodawanie(Wielomian W) {
        if (this.n != W.n) {
            throw new IllegalArgumentException("Wielomiany muszą mieć ten sam stopien");
        }
        Wielomian wynik = new Wielomian(this.n, wspol);
        for (int i = 0; i <= this.n; i++) {
            wynik.wspol[i] = this.wspol[i] + W.wspol[i];
        }
        return wynik;
    }

    public Wielomian odejmowanie(Wielomian W) {
        if (this.n != W.n) {
            throw new IllegalArgumentException("Wielomiany muszą mieć ten sam stopien");
        }
        Wielomian wynik = new Wielomian(this.n, wspol);
        for (int i = 0; i <= this.n; i++) {
            wynik.wspol[i] = this.wspol[i] - W.wspol[i];
        }
        return wynik;
    }

    public Wielomian mnozenie(Wielomian W) {
        int stopien = this.n + W.n;
        Wielomian wynik = new Wielomian(stopien, wspol);
        for (int i = 0; i <= this.n; i++) {
            for (int j = 0; j <= W.n; j++) {
                wynik.wspol[i+j] += this.wspol[i] * W.wspol[j];
            }
        }
        return wynik;
    }

    public void wypisz() {
        System.out.print("Wielomian: ");
        for (int i = n; i >= 0; i--) {
            System.out.print(this.wspol[i] + "x^" + i);
            if (i > 0) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public double oblicz(double x) {
        if (x > 120 || x < -100) {
            throw new IllegalArgumentException("x powinno byc z przedzialu -100 do 120");
        }
        double wynik = 0;
        for (int i = n; i >= 0; i--) {
            wynik += this.wspol[i] * Math.pow(x, i);
        }
        return wynik;
    }
}