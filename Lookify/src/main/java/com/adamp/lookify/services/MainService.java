package com.adamp.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adamp.lookify.models.Song;
import com.adamp.lookify.repositories.SongRepository;

@Service
public class MainService {
	private final SongRepository songRepo;
	
	public MainService(SongRepository songRepo) {  // this entry can be auto generated as a constructor
		this.songRepo = songRepo;
	}

	public SongRepository getSongRepo() { // will not edit or delete without this. auto gen, getter setter
		return songRepo;
	}

	// Get all Songs
	public List<Song> getAllSongs() {
		return this.songRepo.findAll();
	}
	// Find Song by ID
	public Song findSongById(Long id) {
		return this.songRepo.findById(id).orElse(null);
	}

	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public List<Song> findByArtist(String search) {
		return songRepo.findByArtistContaining(search);
	}
	
	public List<Song> top10Songs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
				
	// Create a Song
	
	public void createSong(Song song) {
		this.songRepo.save(song);
	}
	
//	// Update song
//	public Song update(Long id, String title, String artist, Integer rating) {
//		Song optionalSong = this.findSong(id);
//		optionalSong.setTitle(title);
//		optionalSong.setArtist(artist);
//		optionalSong.setRating(rating); {
//			return songRepo.save(optionalSong);
//		}
//	}
//	
//	public Song update(Song filledSong) {
//		return songRepo.save(filledSong);
//	}

//	// Delete Song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
		return;
	}

}
