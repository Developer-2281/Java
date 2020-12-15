package com.adamp.lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adamp.lookify.models.Song;
import com.adamp.lookify.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
		
	}
	@GetMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> allSongs = mainService.getAllSongs();
		model.addAttribute("allSongs", allSongs);  // allSongs will be the variable passed the html
		return "dashboard.jsp";
	}

	@GetMapping("/song/new")
	public String newSong(@ModelAttribute("song") Song song, HttpSession session) {
		return "newsong.jsp";
	}

    // This function sends the new model information to the model service
    // else it uses binding to persist inputed model data to be corrected of errors
	@RequestMapping(value="/submitSong", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "newsong.jsp";
        } else {
            mainService.createSong(song);
            return "redirect:/dashboard";
        }
    }
	
//	@PostMapping
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = mainService.top10Songs();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	
	@GetMapping("/songs{id}")
	public String songInfo(@PathVariable("id")Long id, Model model) {
		Song song = mainService.findSongById(id);
		model.addAttribute("Song", song);
		return "songInfo.jsp";
	}
	
	@GetMapping("/searchArtist")
	public String search(@RequestParam("search")String search, Model model) {
		List<Song> songs = mainService.findByArtist(search);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}

	//Edit
	  
	//Delete

	//delete
	@RequestMapping("song/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		mainService.deleteSong(id);
		return "redirect:/dashboard";
	}
	//show model
	@GetMapping("/song/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Song song = mainService.findSongById(id);
		model.addAttribute("song", song);
		return "songInfo.jsp";
	
	}
}
