package org.oa.model;

import java.util.List;
import java.util.Map;

public class Menu {
    public Map parent;
    public List children;

    public Menu() {
    }

    public Menu(Map parent, List children) {
        this.parent = parent;
        this.children = children;
    }

    public Map getParent() {
        return parent;
    }

    public void setParent(Map parent) {
        this.parent = parent;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
