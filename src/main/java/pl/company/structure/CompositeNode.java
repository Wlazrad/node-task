package pl.company.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> nodes = new ArrayList<>();

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public Stream<INode> stream() {
        return Stream.concat(super.stream(), nodes.stream().flatMap(INode::stream));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeNode that = (CompositeNode) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nodes);
    }

    @Override
    public String toString() {
        return "(Composite: " + nodes + ')';
    }
}
