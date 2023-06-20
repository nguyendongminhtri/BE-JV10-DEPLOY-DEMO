package com.example.demo.dto.request;

import com.example.demo.model.Category;
import com.example.demo.model.Singer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String avatar;
    @NotNull
    @NotBlank
    private String lyrics;
    @NotNull
    @NotBlank
    private String mp3Url;
    @NotNull
    private Category category;
    @NotNull
    private List<Singer> singerList = new ArrayList<>();
}
