package com.example.february2021d21.model.binding;

import com.example.february2021d21.model.entity.Artist;
import com.example.february2021d21.model.entity.User;
import com.example.february2021d21.model.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumBinding {
    @NotNull
    @Size(min = 3,max = 20)
    private String name;
    @NotNull
    @Size(min = 5)
    private String imageUrl;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @Min(1)
    private Integer copies;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;
    @NotNull
    private String producer;
    @NotNull
    private Genre genre;
    @NotNull
    @Size(min = 1)
    private String artist;

    public AddAlbumBinding() {
    }

    public AddAlbumBinding(String name, String imageUrl, String description, Integer copies, BigDecimal price, LocalDate releasedDate, String producer, Genre genre, String artist) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.copies = copies;
        this.price = price;
        this.releasedDate = releasedDate;
        this.producer = producer;
        this.genre = genre;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public AddAlbumBinding setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddAlbumBinding setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddAlbumBinding setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AddAlbumBinding setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddAlbumBinding setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AddAlbumBinding setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AddAlbumBinding setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AddAlbumBinding setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AddAlbumBinding setArtist(String artist) {
        this.artist = artist;
        return this;
    }
}
