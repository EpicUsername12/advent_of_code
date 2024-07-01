package com.epicusername12.aoc.day8.y2017;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Node {
    private List<Node> childrens = new ArrayList<>();
    private List<Integer> metadata = new ArrayList<>();

    public int sumMetadata() {
        return childrens.stream().mapToInt(Node::sumMetadata).sum() + metadata.stream().mapToInt(Integer::intValue).sum();
    }

    public static int parseNode(Node parentNode, List<Integer> numbers, int offset) {
        int localOffset = 0;

        int numChildren = numbers.get(offset);
        int numMetadata = numbers.get(offset + 1);

        localOffset += 2;

        for (int i = 0; i < numChildren; i++) {
            Node childNode = new Node();
            localOffset += parseNode(childNode, numbers, offset + localOffset);

            parentNode.getChildrens().add(childNode);
        }

        for (int i = 0; i < numMetadata; i++, localOffset++) {
            parentNode.getMetadata().add(numbers.get(offset + localOffset));
        }

        return localOffset;
    }
}
