package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VisitorPattern {

  public static Tree solve() {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    int[] values = parseIntArr(scan.nextLine());
    int[] colors = parseIntArr(scan.nextLine());

    String[] tempLines = new String[n - 1];
    Set<Integer> nodeList = new HashSet<>();
    for (int i = 0; i < n - 1; i++) {
      String tempLine = scan.nextLine();
      tempLines[i] = tempLine;

      int[] edge = parseIntArr(tempLine);
      nodeList.add(edge[0]);
    }

    TreeNode rootNode = new TreeNode(values[0], getColor(colors[0]), 0);
    TreeNode topNode = rootNode;
    int currentDepth = 0;
    int currentValue = Integer.MIN_VALUE;

    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      int[] edge = parseIntArr(tempLines[i]);

      if (edge[0] != 1 && currentValue != edge[0]) {
        if (nodeMap.get(edge[0]) != null) {
          topNode = nodeMap.get(edge[0]);
        } else {
          continue;
        }

        currentDepth++;
      }

      if (nodeList.contains(edge[1])) {
        TreeNode node = new TreeNode(values[edge[1] - 1], getColor(colors[edge[1] - 1]),
            currentDepth + 1);
        topNode.addChild(node);
        nodeMap.put(edge[1], node);
      } else {
        TreeLeaf tree = new TreeLeaf(values[edge[1] - 1], getColor(colors[edge[1] - 1]),
            currentDepth + 1);
        topNode.addChild(tree);
      }

      currentValue = edge[0];
    }

    return rootNode;
  }

  private static Color getColor(int value) {
    return value == 0 ? Color.RED : Color.GREEN;
  }

  private static int[] parseIntArr(String line) {
    String[] lines = line.split(" ");
    int[] result = new int[lines.length];
    for (int i = 0; i < lines.length; i++) {
      result[i] = Integer.parseInt(lines[i]);
    }

    return result;
  }


  public static void main(String[] args) {
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    int res1 = vis1.getResult();
    int res2 = vis2.getResult();
    int res3 = vis3.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
}

enum Color {
  RED, GREEN
}

abstract class Tree {

  private int value;
  private Color color;
  private int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() { //노드의 값 반환
    return value;
  }

  public Color getColor() { //색상 반환
    return color;
  }

  public int getDepth() { //노드의 깊이. 뿌리는 0, 각 하위는 +1
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {

  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis {

  public abstract int getResult();

  public abstract void visitNode(TreeNode node);

  public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

  int sum = 0;

  public int getResult() {
    return sum;
  }

  public void visitNode(TreeNode node) {
  }

  public void visitLeaf(TreeLeaf leaf) {
    sum += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor extends TreeVis {

  List<Integer> list = new ArrayList<>();

  public int getResult() {
    int product = list.get(0);
    for (int i = 0; i < list.size(); i++) {
      if (i != 0) {
        product = product * list.get(i);
      }
    }

    return product;
  }

  public void visitNode(TreeNode node) {
    if (node.getColor() == Color.RED) {
      list.add(node.getValue());
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.RED) {
      list.add(leaf.getValue());
    }
  }
}

class FancyVisitor extends TreeVis {

  int sumOfNonLeafEvenDepth = 0;
  int sumOfGreenLeaf = 0;

  public int getResult() {
    return Math.abs(sumOfNonLeafEvenDepth - sumOfGreenLeaf);
  }

  public void visitNode(TreeNode node) {
    if (node.getDepth() % 2 == 0) {
      sumOfNonLeafEvenDepth += node.getValue();
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.GREEN) {
      sumOfGreenLeaf += leaf.getValue();
    }
  }
}