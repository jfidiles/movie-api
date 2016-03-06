package MovieApi;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MovieController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> home () {
        return new ResponseEntity<String>("API running!", HttpStatus.OK);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMovies() {
        Database database = Database.getInstance();
        List<Movie> listMovies= database.getAllMovies();

        return new ResponseEntity<List<Movie>>(listMovies, HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovie(@PathVariable ("movieId") String movieId) {
        Database database = Database.getInstance();
        Movie movie = database.getMovie(movieId);
        if (movie == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }
}
