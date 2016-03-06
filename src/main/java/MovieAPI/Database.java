package MovieApi;

import java.sql.*;
import java.util.*;

public class Database {
    Database database;
    private static Database _getInstance = null;
    Connection connection = null;
    private String tableMovie = "movie";

    private Database() {
        try {
            Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:" + AppConfig.DB_LOCATION);
           connection.setAutoCommit(true) ;
       } catch (Exception e) {
           Utilities.reportException(e);
       }
    }

    public static Database getInstance() {
        if (_getInstance==null) {
            _getInstance = new Database();
        }
        return _getInstance;
    }

    //--------------------------------Movie---------------------------------------------

    public List<Movie> getAllMovies() {
        List<Movie> moviesList = new ArrayList();
        try {
            String query = "select * from " + tableMovie + " order by category ASC";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString(AppConfig.TITLE);
                String category = resultSet.getString(AppConfig.CATEGORY);
                String movieLength = Integer.toString(resultSet.getInt(AppConfig.MOVIE_LENGTH));
                String description = resultSet.getString(AppConfig.DESCRIPTION);
                String director = resultSet.getString(AppConfig.DIRECTOR);
                String imdbScore = resultSet.getString(AppConfig.IMDB_SCORE);
                String staring = resultSet.getString(AppConfig.STARING);
                String videoUrl = resultSet.getString(AppConfig.VIDEO_URL);
                String imageUrl = resultSet.getString(AppConfig.IMAGE_URL);

                moviesList.add(new Movie(title, category, movieLength, description, director,
                    imdbScore, staring, videoUrl, imageUrl));
            }
        } catch (Exception e) {
            Utilities.reportException(e);
        }
        return moviesList;
    }

    public Movie getMovie(String movieId) {
        Movie movie = null;
        try {
            String query = "select * from " + tableMovie + " where " + AppConfig.MOVIE_ID + " = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, movieId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String title = resultSet.getString(AppConfig.TITLE);
                String category = resultSet.getString(AppConfig.CATEGORY);
                String movieLength = Integer.toString(resultSet.getInt(AppConfig.MOVIE_LENGTH));
                String description = resultSet.getString(AppConfig.DESCRIPTION);
                String director = resultSet.getString(AppConfig.DIRECTOR);
                String imdbScore = resultSet.getString(AppConfig.IMDB_SCORE);
                String staring = resultSet.getString(AppConfig.STARING);
                String videoUrl = resultSet.getString(AppConfig.VIDEO_URL);
                String imageUrl = resultSet.getString(AppConfig.IMAGE_URL);

                movie = new Movie(title, category, movieLength, description, director,
                    imdbScore, staring, videoUrl, imageUrl);
            }
        } catch (Exception e) {
            Utilities.reportException(e);
        }
        return movie;
    }
}
