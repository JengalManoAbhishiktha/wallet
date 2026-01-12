import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Use size n+1 because accounts are 1-based
        int[] u = new int[n + 1];

        // Read initial values
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            u[x] = y;
        }

        int t = sc.nextInt();

        // Process transactions
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (u[a] >= c) {
                u[a] -= c;
                u[b] += c;
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        }

        System.out.println();

        // Store (value, index) pairs
        List<int[]> r = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            r.add(new int[]{u[i], i});
        }

        // Sort by value
        r.sort(Comparator.comparingInt(a -> a[0]));

        // Print result
        for (int[] p : r) {
            System.out.println(p[1] + " " + p[0]);
        }

        sc.close();
    }
}
