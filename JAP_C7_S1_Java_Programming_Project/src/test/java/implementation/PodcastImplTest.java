package implementation;

import model.Podcast;
import model.Songs;
import myExceptions.MyException;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PodcastImplTest
{
    PodcastImpl obj = new PodcastImpl(); Scanner sc = new Scanner(System.in);

    @Test
    void retrievePodcastListsSize() throws MyException
    {
        List<Podcast> podcasts = obj.retrievePodcasts();
        assertEquals(9, podcasts.size());
        assertNotEquals(8, podcasts.size());
    }

    @Test
    void checkingPodcastListisEmpty() throws MyException
    {
        List<Podcast> podcasts = obj.retrievePodcasts();
        assertEquals(false, podcasts.isEmpty());
        assertNotEquals(true, podcasts.isEmpty());
    }

    @Test
    void checkPodcastBasedOnCelebrity() throws MyException
    {
        String celebName = "Arjit";
        List<Podcast> podcasts = obj.retrievePodcasts();
        List<Podcast> searchedPodcasts = podcasts.stream().filter(p -> p.getCelebrity().equalsIgnoreCase(celebName)).collect(Collectors.toList());
        assertEquals(2, searchedPodcasts.size());
        assertNotEquals(9, searchedPodcasts.size());
        assertNotEquals(1, searchedPodcasts.size());
    }

    @Test
    void checkingPodcastBasedOnPublishedDate() throws MyException
    {
        List<Podcast> podcasts = obj.retrievePodcasts();
        String publishedDate = "2013-04-16";
        LocalDate dt = LocalDate.parse(publishedDate);
        java.sql.Date dateData = Date.valueOf(dt);
        List<Podcast> searchedPodcasts = podcasts.stream().filter(p -> p.getPublishedDate().equals(dateData)).collect(Collectors.toList());
        assertEquals(1, searchedPodcasts.size());
        assertNotEquals(9, searchedPodcasts.size());
        assertNotEquals(2, searchedPodcasts.size());

    }
}