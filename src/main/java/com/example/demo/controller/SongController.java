package com.example.demo.controller;

import com.example.demo.dto.request.SongDTO;
import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Song;
import com.example.demo.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/page")
    public ResponseEntity<?> pageSong(Pageable pageable){
        return new ResponseEntity<>(songService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> listSong(){
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createSong(@Valid @RequestBody SongDTO songDTO){
        Song song = new Song(songDTO.getName(), songDTO.getAvatar(), songDTO.getLyrics(), songDTO.getMp3Url(), songDTO.getCategory(), songDTO.getSingerList());
        songService.save(song);
        return new ResponseEntity<>(new ResponMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detailSong(@PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        if(!song.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
}
