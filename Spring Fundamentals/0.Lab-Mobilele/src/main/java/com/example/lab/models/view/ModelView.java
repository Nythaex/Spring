package com.example.lab.models.view;

import com.example.lab.models.entity.Enums.Category;

public class ModelView {
    private String name;
    private Category category;
    private Integer startYear;
    private Integer endYear;
    private String imageUrl;

    public ModelView(String name, Category category, Integer startYear, Integer endYear, String imageUrl) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
    }

    public ModelView() {
    }

    public String getName() {
        return name;
    }

    public ModelView setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelView setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelView setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelView setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
