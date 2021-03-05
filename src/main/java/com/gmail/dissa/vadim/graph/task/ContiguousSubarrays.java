package com.gmail.dissa.vadim.graph.task;

import java.util.Arrays;

public class ContiguousSubarrays {

    int[] countSubarrays(int[] arr) {
        if (arr == null){
            return new int[0];
        }
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = 1;

            int l = i - 1;
            while (l >= 0 && arr[i] > arr[l]) {
                l--;
                result[i]++;
            }

            int r = i + 1;
            while (r < arr.length && arr[i] > arr[r]) {
                r++;
                result[i]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(new ContiguousSubarrays().countSubarrays(new int[]{3, 4, 1, 6, 2})).forEach(System.out::println);
    }
}
