package com.example.february2021d21.model.entity;

import com.example.february2021d21.model.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Album extends BasicEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String imageUrl;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer copies;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)

    private LocalDate releasedDate;

    private String producer;
    @Column(nullable = false)
    private Genre genre;


    @ManyToOne
    @JoinColumn(name = "added_from_id")
    private User user;


    @ManyToOne
    private Artist artist;


    public Album() {
    }

    public Album(String name, String imageUrl, String description, Integer copies, BigDecimal price, LocalDate releasedDate, String producer, Genre genre) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.copies = copies;
        this.price = price;
        this.releasedDate = releasedDate;
        this.producer = producer;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Album setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Album setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Album setUser(User user) {
        this.user = user;
        return this;
    }
}
