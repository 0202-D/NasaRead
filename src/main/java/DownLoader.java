
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author Dm.Petrov
 * DATE: 28.07.2022
 */
public class DownLoader {
    public void downLoad(String path) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        assert url != null;
        String filename = Paths.get(url.getPath()).getFileName().toString();
        try (FileOutputStream out = new FileOutputStream(filename);
             BufferedInputStream in = new BufferedInputStream(url.openStream())) {
            byte[] array = new byte[124];
            int read;
            while ((read = in.read(array, 0, 124)) != -1) {
                out.write(array, 0, read);
                out.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}


