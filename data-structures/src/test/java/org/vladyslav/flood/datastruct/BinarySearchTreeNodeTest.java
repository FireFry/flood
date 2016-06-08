package org.vladyslav.flood.datastruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeNodeTest {

    @Test
    public void validate_singleNode_shouldBeTrue() {
        assertTrue(node(-54, null, null).validate());
    }

    @Test
    public void validate_twoNodes_shouldBeTrue() {
        assertTrue(node(56, node(-1, null, null), null).validate());
    }

    @Test
    public void validate_twoNodes_shouldBeTrue2() {
        assertTrue(node(-5, null, node(-3, null, null)).validate());
    }

    @Test
    public void validate_twoNodes_shouldBeFalse() {
        assertFalse(node(0, node(4, null, null), null).validate());
    }

    @Test
    public void validate_twoNodes_shouldBeFalse2() {
        assertFalse(node(-3, null, node(-5, null, null)).validate());
    }

    @Test
    public void validate_threeNodes_shouldBeTrue() {
        assertTrue(node(5, node(2, null, null), node(7, null, null)).validate());
    }

    @Test
    public void validate_threeNodes_shouldBeFalse() {
        assertFalse(node(5, node(7, null, null), node(0, null, null)).validate());
    }

    @Test
    public void validate_fullThreeLayersTree_shouldBeTrue() {
        BinarySearchTreeNode<Double> root = node(23,
                node(7,
                        node(3,
                                node(1, null, null),
                                node(4, null, null)
                        ),
                        node(12,
                                node(9, null, null),
                                node(13, null, null)
                        )
                ),
                node(33,
                        node(29,
                                node(25, null, null),
                                node(32, null, null)
                        ),
                        node(44,
                                node(36, null, null),
                                node(47, null, null)
                        )
                )
        );

        assertTrue(root.validate());
    }

    @Test
    public void validate_fullThreeLayersTree_shouldBeFalse() {
        BinarySearchTreeNode<Double> root = node(23,
                node(7,
                        node(3,
                                node(1, null, null),
                                node(4, null, null)
                        ),
                        node(13,
                                node(9, null, null),
                                node(12, null, null)
                        )
                ),
                node(33,
                        node(29,
                                node(25, null, null),
                                node(32, null, null)
                        ),
                        node(44,
                                node(36, null, null),
                                node(47, null, null)
                        )
                )
        );

        assertFalse(root.validate());
    }

    private static BinarySearchTreeNode<Double> node(
            double value,
            BinarySearchTreeNode<Double> left,
            BinarySearchTreeNode<Double> right
    ) {
        BinarySearchTreeNode<Double> node = new BinarySearchTreeNode<>(value);
        if (left != null) {
            node.setChild(BinaryTreeKey.LEFT, left);
        }
        if (right != null) {
            node.setChild(BinaryTreeKey.RIGHT, right);
        }
        return node;
    }

}