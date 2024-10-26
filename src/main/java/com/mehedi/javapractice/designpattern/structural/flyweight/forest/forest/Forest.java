package com.mehedi.javapractice.designpattern.structural.flyweight.forest.forest;

import com.mehedi.javapractice.designpattern.structural.flyweight.forest.trees.Tree;
import com.mehedi.javapractice.designpattern.structural.flyweight.forest.trees.TreeFactory;
import com.mehedi.javapractice.designpattern.structural.flyweight.forest.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics g) {
        for(Tree tree : trees) {
            tree.draw(g);
        }
    }
}
