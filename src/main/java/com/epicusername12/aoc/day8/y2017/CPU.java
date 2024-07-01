package com.epicusername12.aoc.day8.y2017;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPU {
    private final Map<String, Integer> registers = new HashMap<>();
    private int maxValue = Integer.MIN_VALUE; // Partie 2

    private int getRegister(String reg) {
        registers.putIfAbsent(reg, 0);
        return registers.get(reg);
    }

    private void setRegister(String reg, Integer value) {
        // Partie 2
        if (value > maxValue) {
            maxValue = value;
        }

        registers.put(reg, value);
    }

    private boolean executeCompare(String reg, String op, Integer value) {

        int regVal = getRegister(reg);
        return switch (op) {
            case "==" -> regVal == value;
            case ">=" -> regVal >= value;
            case "<=" -> regVal <= value;
            case ">" -> regVal > value;
            case "<" -> regVal < value;
            case "!=" -> regVal != value;
            default -> false;
        };
    }

    private void executeInstruction(String reg, String op, Integer value) {
        final int destVal = getRegister(reg);
        if (op.contentEquals("inc")) {
            setRegister(reg, destVal + value);
        } else if (op.contentEquals("dec")) {
            setRegister(reg, destVal - value);
        }
    }

    public void processInstruction(String instruction) {

        Pattern instructionPattern = Pattern.compile("(?<destReg>.*) (?<op>inc|dec) (?<opVal>-?\\d+) if (?<compReg>.*) (?<compOp>[<>=!]+) (?<compVal>-?\\d+)");
        Matcher instructionMatcher = instructionPattern.matcher(instruction);

        if (instructionMatcher.find()) {
            String destRegister = instructionMatcher.group("destReg");
            String operation = instructionMatcher.group("op");
            Integer operationValue = Integer.valueOf(instructionMatcher.group("opVal"));
            String compareRegister = instructionMatcher.group("compReg");
            String compareOperation = instructionMatcher.group("compOp");
            Integer compareValue = Integer.valueOf(instructionMatcher.group("compVal"));

            if (executeCompare(compareRegister, compareOperation, compareValue)) {
                executeInstruction(destRegister, operation, operationValue);
            }
        }
    }

    public Integer getMaxRegisterValue() {
        return registers.values().stream().max(Integer::compare).orElse(0);
    }

    public Integer getMaxValue() {
        return maxValue;
    }

}
