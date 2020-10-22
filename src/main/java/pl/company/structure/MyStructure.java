package pl.company.structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

    private List<INode> nodes = new LinkedList<>();

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code can't be null");
        }
        return findNode(n -> code.equals(n.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Renderer can't be null");
        }
        return findNode(node -> renderer.equals(node.getRenderer()));
    }

    private INode findNode(Predicate<INode> nodePredicate) {
        return nodes.stream()
                .flatMap(INode::stream)
                .filter(nodePredicate)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int count() {
        return (int) nodes.stream().flatMap(INode::stream).count();
    }

    public void add(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node can't be null");
        }
        nodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStructure structure = (MyStructure) o;
        return Objects.equals(nodes, structure.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public String toString() {
        return "{" + nodes + "}";
    }
}