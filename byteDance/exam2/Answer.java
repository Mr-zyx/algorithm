package byteDance.exam2;

import java.util.Scanner;

public class Answer {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int D = sc.nextInt();

    int[] locations = new int[N];
    for (int i = 0; i < N; i++) {
      locations[i] = sc.nextInt();
    }

    long count = 0;
    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 2; j < N; j++) {
        if ((locations[j] - locations[i]) <= D) {
          count += (j - i - 1);
        }
      }
    }

    System.out.println(count % 99997867);
  }

}
