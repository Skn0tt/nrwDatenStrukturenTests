/*
 * Copyright (c) Simon Knott 2018.
 */

public class BinaryTree<ContentType> {
  public BinaryTree() {}
  public BinaryTree(ContentType content) {}
  public BinaryTree(ContentType content, BinaryTree<ContentType> leftTree, BinaryTree<ContentType> rightTree) {}
  boolean isEmpty() {
    return false;
  }
  public ContentType getContent() {
    return null;
  }
  public void setContent(ContentType content) {}
  public BinaryTree<ContentType> getLeftTree() {
    return null;
  }
  public void setLeftTree(BinaryTree<ContentType> leftTree) {}
  public BinaryTree<ContentType> getRightTree() {
    return null;
  }
  public void setRightTree(BinaryTree<ContentType> rightTree) {}
}
