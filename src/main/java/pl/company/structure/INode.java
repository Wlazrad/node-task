package pl.company.structure;

import java.util.stream.Stream;

public interface INode {
    String getCode();

    String getRenderer();

    Stream<INode> stream();
}