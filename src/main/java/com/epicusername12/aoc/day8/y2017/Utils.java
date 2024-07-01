package com.epicusername12.aoc.day8.y2017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Utils {

    private Utils() {
    }

    public static String readFileToString(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static List<Integer> extractNumbers(String data) {
        Pattern numberPattern = Pattern.compile("\\d+");
        return numberPattern.matcher(data).results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .toList();
    }

}
