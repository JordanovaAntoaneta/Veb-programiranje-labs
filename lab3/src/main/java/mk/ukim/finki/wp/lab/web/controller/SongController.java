package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/details/{id}")
    public String showSongDetails(@PathVariable Long id, Model model) {
        Song song = songService.findByTrackId(String.valueOf(id));
        model.addAttribute("song", song);
        return "songDetails";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songService.findByTrackId(String.valueOf(id));
        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }


    @PostMapping
    public String saveSong(@ModelAttribute Song song) {
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }

    @GetMapping("/add-form")
    public String redirectToAddForm() {
        return "redirect:/songs/add";
    }
}

