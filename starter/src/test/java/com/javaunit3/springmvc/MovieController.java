package com.javaunit3.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {
    @Autowired
    private BestMovieService bestMovieService;
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        movieEntityList.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));

        MovieEntity movieWithMostVotes = movieEntityList.get(movieEntityList.size() - 1);
        List<String> voterNames = new ArrayList<>();

        for (VoteEntity vote: movieWithMostVotes.getVotes()){
            voterNames.add(vote.getVoterName());
        }
        String voterNamesList = String.join(",", voterNames);
        model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("bestMovieVoters", voterNamesList);
        session.getTransaction().commit();

        return "bestMovie";
    }
    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieFormPage(Model model){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity"). list();
        session.getTransaction().commit();
        model.addAttribute("movies", movieEntityList);
        return "voteForBestMovie";
    }

    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model){
        String movieId = request.getParameter("movieId");
        String voterName = request.getParameter("voterName");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setVoterName(voterName);
        movieEntity.addVote(newVote);
        session.update(movieEntity);
        
        session.getTransaction().commit();

        return "voteForBestMovie";
    }

    @Autowired
    private SessionFactory sessionFactory;
    
    @RequestMapping("/addMovieForm")
    public String addMovieFormPage(){
        return "addMovie";
    }

    @RequestMapping("/addMovie")
    public String addMovie(HttpServletRequest request){
        String movieTitle = request.getParameter("movieTitle");
        String maturityRating = request.getParameter("maturityRating");
        String genre = request.getParameter("genre");

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieTitle);
        movieEntity.setMaturityRating(maturityRating);
        movieEntity.setGenre(genre);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movieEntity);

        Integer movieId = movieEntity.getId();
        System.out.println(movieId);
        
        session.getTransaction().commit();

        return "addMovie";
    }
    
}
