package com.danisanga.playground.code.wars.kata.hallway;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        final List<String> characters = separateCharacters(hallway);

        Map<String, Integer> result = countDashesBetweenMarkers(characters);
        result.forEach((key, value) -> System.out.println(key + ": " + value));

        if (result.isEmpty()) {
            return -1;
        } else {
            Map.Entry<String, Integer> minValue = getMinValue(result);
            return Objects.nonNull(minValue) ? minValue.getValue() : -1;
        }
    }

    private static Map<String, Integer> countDashesBetweenMarkers(List<String> characters) {
        Map<String, Integer> resultMap = new LinkedHashMap<>(); // LinkedHashMap mantiene el orden de inserción
        List<Integer> markerPositions = new ArrayList<>();

        // Recoger las posiciones de '>' y '<'
        IntStream.range(0, characters.size()).forEach(i -> {
            if (characters.get(i).contains(">") || characters.get(i).contains("<")) {
                markerPositions.add(i);
            }
        });

        // Asegurarse de que las posiciones de '>' y '<' son correctas
        for (int i = 0; i < markerPositions.size() - 1; i += 2) {
            if (characters.get(markerPositions.get(i)).contains(">") && characters.get(markerPositions.get(i + 1)).contains("<")) {
                int start = markerPositions.get(i) + 1;
                int end = markerPositions.get(i + 1);
                int count = (int) characters.subList(start, end).stream().filter(ch -> ch.equals("-")).count();
                if (count == 0) {
                    count = 1;
                }
                resultMap.put(String.valueOf((char) ('a' + (i / 2))), count); // Convertir el índice a letra del abecedario
            }
        }
        return resultMap;
    }

    private static Map.Entry<String, Integer> getMinValue(Map<String, Integer> resultMap) {
        return resultMap.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
    }

    private static List<String> separateCharacters(final String hallway) {
        List<String> result = new ArrayList<>();

        // Expresión regular para capturar secuencias de '>' y '<'
        Pattern pattern = Pattern.compile("([>]+|[<]+|-)");
        Matcher matcher = pattern.matcher(hallway);

        while (matcher.find()) {
            String match = matcher.group();

            // Si es '-' lo agregamos directamente
            if (match.equals("-")) {
                result.add(match);
            } else {
                // Si es una secuencia de '>' o '<', agregamos la secuencia completa
                result.add(match);
            }
        }

        System.out.println(result);
        return result;
    }
}