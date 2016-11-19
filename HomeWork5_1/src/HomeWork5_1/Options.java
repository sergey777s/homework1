package HomeWork5_1;

import java.util.Arrays;
import java.util.List;

public class Options {
    private String[] audio = {"audio", ".mp3", ".wav", ".wm"};
    private String[] video = {"video", ".avi", ".mp4", ".flv"};
    private String[] image = {"image", ".jpeg", ".jpg", ".gif", ".tiff", ".png"};
    private List<String[]> allTypesOfFiles = Arrays.asList(audio, video, image);

    public List<String[]> getAllTypesOfFiles() {
        return allTypesOfFiles;
    }
}