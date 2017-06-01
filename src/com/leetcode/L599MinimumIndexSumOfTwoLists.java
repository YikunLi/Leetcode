package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L599MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines",
                "Hungry Hunter Steakhouse", "Shogun" };
        Solution solution = new SolutionImpl();
        System.out.println(
                Arrays.toString(solution.findRestaurant(list1, list2)));
        list1 = new String[] { "Shogun", "Tapioca Express", "Burger King",
                "KFC" };
        list2 = new String[] { "KFC", "Shogun", "Burger King" };
        System.out.println(
                Arrays.toString(solution.findRestaurant(list1, list2)));
        list1 = new String[] { "Shogun", "KFC" };
        list2 = new String[] { "KFC", "Shogun", "Burger King" };
        System.out.println(
                Arrays.toString(solution.findRestaurant(list1, list2)));
    }

    public static interface Solution {
        public String[] findRestaurant(String[] list1, String[] list2);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> restaurants = new ArrayList<String>();
            int sumLike = Integer.MAX_VALUE;
            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i].equals(list2[j]) && i + j <= sumLike) {
                        if (i + j < sumLike) {
                            restaurants.clear();
                        }
                        restaurants.add(list1[i]);
                        sumLike = i + j;
                    }
                }
            }
            return restaurants.toArray(new String[restaurants.size()]);
        }

    }
}
