import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dm.Petrov
 * DATE: 27.07.2022
 */
public class Post {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public Post(@JsonProperty("copyright") String copyright, @JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation, @JsonProperty("hdurl") String hdurl,
                @JsonProperty("media_type") String media_type, @JsonProperty("service_version") String service_version,
                @JsonProperty("title") String title, @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Post{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
