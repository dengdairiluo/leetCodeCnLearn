package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-25 23:57
 */
public class Q1634 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null || poly2 == null) {
            return poly1 == null ? poly2 : poly1;
        }
        PolyNode polyNode = new PolyNode();
        if (poly1.power > poly2.power) {
            polyNode = poly1;
            polyNode.next = addPoly(poly1.next, poly2);
        } else if (poly1.power < poly2.power) {
            polyNode = poly2;
            polyNode.next = addPoly(poly1, poly2.next);
        } else {
            if (poly1.coefficient + poly2.coefficient == 0) {
                polyNode = addPoly(poly1.next, poly2.next);
            } else {
                polyNode.coefficient = poly1.coefficient + poly2.coefficient;
                polyNode.power = poly1.power;
                polyNode.next = addPoly(poly1.next, poly2.next);
            }
        }
        return polyNode;
    }

    private static class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {
        }

        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }
}
