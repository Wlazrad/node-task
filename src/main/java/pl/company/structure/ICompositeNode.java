package pl.company.structure;

import java.util.List;

public interface ICompositeNode extends INode {
    List<INode> getNodes();
}