package com.epicusername12.aoc.day8.y2017;

import com.epicusername12.aoc.utils.Utils;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            final CPU cpu = new CPU();
            final Stream<String> inputLines = Utils.readFileLinesToStringArray("input_day8_2017.txt");

            inputLines.forEach(cpu::processInstruction);

            System.out.format("Maximum register value: %d%n", cpu.getMaxRegisterValue());
            System.out.format("Maximum register value at all times: %d%n", cpu.getMaxValue());

        } catch (IOException e) {
            System.err.println("Couldn't read the input file.");
        }
    }
}