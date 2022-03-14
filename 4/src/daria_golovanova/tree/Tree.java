package daria_golovanova.tree;

import java.util.Objects;
import java.util.Random;

public class Tree {
    private TreeKindEnum treeKindEnum;
    private double TreeRadius;
    private int age;
    Random random = new Random();

    public Tree(TreeKindEnum treeKindEnum, double treeRadius, int age) {
        setTreeKindEnum(treeKindEnum);
        setTreeRadius(treeRadius);
        setAge(age);

    }

    public void ageUp(int age) {
        int finalAge = age;
        class Circle {
            private int circle = 1;

            public int getNumberOfCircles() {
                if (finalAge > 10) {
                    return circle*10;
                }
                else return random.nextInt(11);
            }
        }
        age++;
    }

    public void setTreeRadius(double treeRadius) {
        TreeRadius = treeRadius;
    }

    public void setTreeKindEnum(TreeKindEnum treeKindEnum) {
        this.treeKindEnum = treeKindEnum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tree " +
                 treeKindEnum ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree tree = (Tree) o;
        return Double.compare(tree.TreeRadius, TreeRadius) == 0 &&
                age == tree.age &&
                treeKindEnum == tree.treeKindEnum &&
                Objects.equals(random, tree.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeKindEnum, TreeRadius, age, random);
    }
}
