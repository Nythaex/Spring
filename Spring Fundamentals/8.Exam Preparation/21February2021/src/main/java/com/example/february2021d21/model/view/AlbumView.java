package com.example.february2021d21.model.view;

import com.example.february2021d21.model.entity.Artist;
import com.example.february2021d21.model.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumView {
    private Long id;
    private String imageUrl;
    private String name;
    private String artist;
    private Genre genre;
    private BigDecimal price;
    private LocalDate releasedDate;
    private Integer copies;

    public AlbumView(Long id,String imageUrl, String name, String artist, Genre genre, BigDecimal price, LocalDate releasedDate, Integer copies) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.releasedDate = releasedDate;
        this.copies = copies;
        this.id=id;
    }

    public AlbumView() {
    }

    public Long getId() {
        return id;
    }

    public AlbumView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumView setName(String name) {
        this.name = name;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AlbumView setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumView setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumView setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumView setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }
}
