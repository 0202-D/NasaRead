
/**
 * @author Dm.Petrov
 * DATE: 27.07.2022
 */
public class Main {
    private static final String REMOTE_SERVICE_URI =
            "https://api.nasa.gov/planetary/apod?api_key=LcwOOO8pO4oxr8HUgjb24liKIY8oTVJndlRlIsIM";

    public static void main(String[] args) {
        ParserToPost parser = new ParserToPost();
        Post post = parser.parse(REMOTE_SERVICE_URI);
        DownLoader downLoader = new DownLoader();
        downLoader.downLoad(post.getUrl());
    }
}
