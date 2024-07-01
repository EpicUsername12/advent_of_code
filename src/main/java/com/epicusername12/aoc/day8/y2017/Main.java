package com.epicusername12.aoc.day8.y2017;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            final String inputText = Utils.readFileToString("input_day8_2018.txt");
            final List<Integer> inputNumbers = Utils.extractNumbers(inputText);

            final Node rootNode = new Node();
            Node.parseNode(rootNode, inputNumbers, 0);

            System.out.format("Sum of metadata: %d%n", rootNode.sumMetadata());

        } catch (IOException e) {
            System.err.println("Couldn't read the input file.");
        }
    }
}