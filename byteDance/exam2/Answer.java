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

    int count = 0;
    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 1; j < N - 1; j++) {
        for (int k = j + 1; k < N; k++) {
          if ((locations[j] - locations[i]) <= D && (locations[k] - locations[j]) <= D
              && (locations[k] - locations[i]) <= D) {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }

}
