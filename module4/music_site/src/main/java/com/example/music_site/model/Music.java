package com.example.music_site.model;

import utils.validate_annotation.ConstraintMusicType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String musicName;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String musical;
    @ConstraintMusicType()
    private String musicType;
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",message = "Url Không đúng định dạng")
    private String url;

    public Music(String musicName, String musical, String musicType, String url) {
        this.musicName = musicName;
        this.musical = musical;
        this.musicType = musicType;
        this.url = url;
    }

    public Music() {
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusical() {
        return musical;
    }

    public void setMusical(String musical) {
        this.musical = musical;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
