package MovieApi;

public class Movie {
	private String title;
	private String category;
    private String movieLength;
    private String description;
    private String director;
    private String imdbScore;
    private String staring;
    private String videoUrl;
    private String imageUrl;

    public Movie() {}

    public Movie(String title, String category, String movieLength, String description, String director,
        String imdbScore, String staring, String videoUrl, String imageUrl) {

    	this.title = title;
    	this.category = category;
    	this.movieLength = movieLength;
    	this.description = description;
    	this.director = director;
    	this.imdbScore = imdbScore;
    	this.staring = staring;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getMovieLength() {
        return this.movieLength;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDirector() {
        return this.director;
    }

    public String getImdbScore() {
        return this.imdbScore;
    }

    public String getStars() {
        return this.staring;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
