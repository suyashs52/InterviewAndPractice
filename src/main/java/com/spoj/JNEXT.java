package com.spoj;

import com.array.Queue;
import com.array.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JNEXT {
    public static <T> void code() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Stack digits = new Stack();
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < line.length; j++) {
                if ((line[i] >= '0') & (line[i] <= '9')) {
                    digits.push(line[i] - '0');
                }
            }

            Queue<T> queue = new Queue<T>(n);
            queue.enqueue(digits.peak());
            digits.pop();

            int next;

            boolean flag = false;
            while (!digits.isEmpty()) {
                next = digits.peak();
                // 1 6 1 4 8 7 6 5
                if (next >= queue.front()) {
                    queue.enqueue(next);
                    digits.pop();
                } else {
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                System.out.println("-1");
            } else {
                int a = digits.peak();
                digits.pop();
                Queue<T> temp = new Queue<T>(n);
                int b = 0;
                while (queue.getSize() > 0) {
                    if (queue.rear() < a) {

                    }
                }
            }

        }

    }
}
