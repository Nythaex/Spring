package com.example.lab.models.view;

import java.util.List;

public class BrandView {
    private String name;
    private List<ModelView> views;

    public BrandView(String name, List<ModelView> views) {
        this.name = name;
        this.views = views;
    }

    public BrandView() {
    }

    public String getName() {
        return name;
    }

    public BrandView setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelView> getViews() {
        return views;
    }

    public BrandView setViews(List<ModelView> views) {
        this.views = views;
        return this;
    }
}
