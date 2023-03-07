import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BestMovieService {
    @Autowired
    public Movie Movie;

    public Movie getBestMovie(){
        return movie;
    }
}
