package com.demo.blog.Category;

public class Category {

    String Category_id;
    String Category_name;

    public Category(String category_id, String category_name) {
        Category_id = category_id;
        Category_name = category_name;
    }

    public String getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(String category_id) {
        Category_id = category_id;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }
}
