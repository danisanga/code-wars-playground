package com.danisanga.playground.code.wars.kata.hallway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code Wars <a href="https://www.codewars.com/kata/6368426ec94f16a1e7e137fc/java">kata</a>.
 */
public class Hallway {

    public static int contact(String hallway) {

        // Checks if hallway String is valid... If it does not contain">" or "<" no people will contact each other.
        if (!hallway.contains(">") && !hallway.contains("<")) {
            return -1;
        }

        // Gets characters from hallway.
        final List<Character> characters = hallway.chars().mapToObj(e -> (char) e).toList();
        System.out.println(characters);

        // Search for coincidences... This means get the number of "-" between people.
        // TODO - WIP
        Map<String, Integer> coincidences = new HashMap<>();
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).equals('>')) {
                int numberOfHyphens = 0;
                while (i < characters.size() && !characters.get(i).equals('<')) {
                    numberOfHyphens++;
                    i++;
                }
                coincidences.put(">", numberOfHyphens);
                break;
            }
        }

        // Returns expected result.
        return coincidences.get(">");
    }
}