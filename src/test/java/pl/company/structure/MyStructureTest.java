package pl.company.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyStructureTest {

    private MyStructure structure;
    private static final Node node1 = new Node("c1", "r1");
    private static final Node node2 = new Node("c2", "r2");
    private static final CompositeNode cNode1 = new CompositeNode("xc1","xr1");

    @BeforeEach
    void setUp() {
        structure = new MyStructure();
    }

    @Test
    void shouldAddNodeToStructureAndReturnOneOnCount() {
        //given
        Node node = new Node("code", "renderer");
        //when
        structure.add(node);
        //then
        Assertions.assertEquals(1, structure.count());
    }

    @Test
    void shouldReturnSameNodeWhenFindByCode() {
        //given
        structure.add(node1);
        structure.add(node2);
        //then
        Assertions.assertEquals(structure.findByCode("c1"), node1);
    }

    @Test
    void shouldReturnSameNodeWhenFindByRenderer() {
        //given
        structure.add(node1);
        structure.add(node2);
        //then
        Assertions.assertEquals(structure.findByRenderer("r2"), node2);
    }

    @Test
    void shouldReturnTrueWhenCheckingNodesEquality() {
        //given
        Node node1 = new Node("c1", "r1");
        Node node2 = new Node("c1", "r1");
        //then
        Assertions.assertEquals(node1, node2);
    }

    @Test
    void shouldReturnTrueWhenCheckingStructureEquality() {
        //given
        MyStructure structure1 = new MyStructure();
        structure1.add(node1);
        MyStructure structure2 = new MyStructure();
        structure2.add(node1);
        //then
        Assertions.assertEquals(structure1, structure2);
    }

    @Test
    void shouldThrowExceptionWhenAddingNullToStructure() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> structure.add(null));
    }

    @Test
    void shouldThrowExceptionWhenPassingNullCodeToFindByCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> structure.findByCode(null));
    }

    @Test
    void shouldThrowExceptionWhenPassingNullRendererToFindByRenderer() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> structure.findByRenderer(null));
    }

    @Test
    void shouldFindNodeWhenPassingCompositeNode() {
        //given
        cNode1.addNode(node1);
        cNode1.addNode(node2);
        structure.add(cNode1);
        //then
        Assertions.assertEquals(structure.findByCode("c1"), node1);
        Assertions.assertEquals(structure.findByRenderer("r1"), node1);
    }

    @Test
    void shouldReturnFineCountWhenPassedCompositeNodeToStructure() {
        //given
        cNode1.addNode(node1);
        cNode1.addNode(node2);
        structure.add(cNode1);
        //then
        Assertions.assertEquals(3, structure.count());
    }

}
