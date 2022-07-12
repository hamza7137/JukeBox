package implementation;

import model.Songs;
import myExceptions.MyException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SongsImplTest
{
    SongsImpl obj = new SongsImpl(); Scanner sc = new Scanner(System.in);

    @Test
    void retrieveSongsListSize() throws MyException
    {
        List<Songs> songs = obj.retrieveSongs();
        assertEquals(16, songs.size()); // 16
        assertNotEquals(15, songs.size()); // 16
    }

    @Test
    void checkingSongsListisEmpty() throws MyException
    {
        List<Songs> songs = obj.retrieveSongs();
        assertEquals(false, songs.isEmpty());
        assertNotEquals(true, songs.isEmpty());
    }

    @Test
    void checkSongsBasedOnGenre() throws MyException
    {
        List<Songs> songs = obj.retrieveSongs();
        String genre = "Sad";
        List<Songs> searchedSongs = songs.stream().filter(p -> p.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        assertEquals(6, searchedSongs.size());
        assertNotEquals(16, searchedSongs.size());
        assertNotEquals(5, searchedSongs.size());
    }

    @Test
    void checkSongsBasedOnArtist() throws MyException
    {
        List<Songs> songs = obj.retrieveSongs();
        String artist = "Atif Aslam";
        List<Songs> searchedSongs = songs.stream().filter(p -> p.getArtist().equalsIgnoreCase(artist)).collect(Collectors.toList());
        assertEquals(3, searchedSongs.size());
        assertNotEquals(16, searchedSongs.size());
        assertNotEquals(2, searchedSongs.size());
    }

    @Test
    void checkSongsBasedOnAlbum() throws Exception
    {
        List<Songs> songs = obj.retrieveSongs();
        String album = "A Tale of Two Talhas";
        List<Songs> searchedSongs = songs.stream().filter(p -> p.getAlbum().equalsIgnoreCase(album)).collect(Collectors.toList());
        assertEquals(3, searchedSongs.size());
        assertNotEquals(16, searchedSongs.size());
        assertNotEquals(2, searchedSongs.size());
    }

}