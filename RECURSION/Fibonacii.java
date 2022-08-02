public class Fibonacii {

    public static void main(String[] args) {

        // System.out.println(fibo(7));

        // System.out.println(fact(7));

        // System.out.println(sumOfDigit(13420115));

        // System.out.println(reverse(12345));

        // System.out.println(palindrome(1321));

        // System.out.println(countElement(1234500002, 0));

        System.out.println();
        System.out.println("EOF");
    }

    // fibonacii
    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // factorial
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    // sum of digits
    public static int sumOfDigit(int n) {

        if (n % 10 == n) {
            return n;
        }

        return (n % 10) + sumOfDigit(n / 10);
    }

    // reverse the number
    public static int reverse(int n) {

        int digits = (int) (Math.log10(n) + 1);

        return helper(n, digits);
    }

    // helper of reverse function
    public static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }

        int rem = n % 10;
        return rem * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    // palindrome or not
    public static boolean palindrome(int n) {

        return n == reverse(n);
    }

    // count the specific number frequency in number
    public static int countElement(int n, int element) {

        return helper(n, element, 0);
    }

    // helper of countElement
    public static int helper(int n, int element, int cnt) {

        if (n == 0) {
            return cnt;
        }

        int rem = n % 10;
        if (rem == element) {
            return helper(n/10, element, cnt + 1);
        }

        return helper(n / 10, element, cnt);
    }

}