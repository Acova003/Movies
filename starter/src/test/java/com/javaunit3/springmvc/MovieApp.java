package com.javaunit3.springmvc;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MovieApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class)) {
            BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);

            Movie bestMovie = bestMovieService.getBestMovie();

            System.out.println("Title: " + bestMovie.getTitle());
            System.out.println("Maturity rating: " + bestMovie.getMaturityRating());
            System.out.println("Genre: " + bestMovie.getGenre());
        } catch (BeansException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}