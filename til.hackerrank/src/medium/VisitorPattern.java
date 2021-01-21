package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

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

    TreeNode treeNode = new TreeNode(values[0], getColor(colors[0]), 0);
    int tempDepth = -1;
    int tempVal = Integer.MIN_VALUE;

    for (int i = 0; i < n - 1; i++) {
      int[] edge = parseIntArr(tempLines[i]);

      if (tempVal != edge[0]) {
        tempVal = edge[0];
        tempDepth++;
      }

      if (nodeList.contains(edge[1])) {
        TreeNode tempNode = new TreeNode(values[edge[0] - 1], getColor(colors[edge[0] - 1]),
            tempDepth);
        treeNode.addChild(tempNode);

        Tree tree = new TreeLeaf(values[edge[1] - 1], getColor(colors[edge[1] - 1]), tempDepth + 1);
        tempNode.addChild(tree);
      } else {
        Tree tree = new TreeLeaf(values[edge[1] - 1], getColor(colors[edge[1] - 1]), tempDepth + 1);
        treeNode.addChild(tree);
      }
    }

    return treeNode;
  }

  private static Color getColor(int value) {
    return value == 0 ? Color.RED : Color.GREEN;
  }

  private static int[] parseIntArr(String line) {
    return Stream.of(line.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
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

  public int getResult() {
    //트리 잎들의 values들을 더해서 리턴
    return 0;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
  }
}

class ProductOfRedNodesVisitor extends TreeVis {

  public int getResult() {
    //빨강 노드들에 저장된 값을 리턴.
    return 1;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
  }
}

class FancyVisitor extends TreeVis {

  public int getResult() {
    //트리의 잎이 아닌 노드들값들의 합계간의 차이 리턴
    return 0;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
  }
}