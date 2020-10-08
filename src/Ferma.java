import java.util.Random;

public class Ferma {
    /**
     * O(k * log N * log N), где k - кол-во итераций ферма (100 в нашем случае)
     * @param x число для проверки
     * @return истина если простое
     */
    public boolean ferma(long x, int k) {
        if (x == 2) return true;
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            System.out.println("## test " + i + 1 + " ##");
            long a = (random.nextLong() % (x - 2)) + 2;
            if (euclidNOD(a, x) != 1) return false;
            if (pows(a, x-1, x) != 1) return false;
        }
        return true;
    }

    private long pows(long a, long l, long x) {
        if (l == 0) return 1;
        if (l%2 == 0) {
            long temp = pows(a, l/2, x);
            return mul(temp, temp, x) % x;
        }
        return (mul(pows(a, l-1, x), a, x)) % x;
    }

    private long mul(long a, long b, long m) {
        if (b == 1) return a;
        if (b%2 == 0) {
            long temp = mul(a, b/2, m);
            return (2 * temp) % m;
        }
        return (mul(a, b-1, m) + a) % m;
    }

    private long euclidNOD(long a, long x) {
        if (x == 0) return a;
        return euclidNOD(x, a%x);
    }
}
