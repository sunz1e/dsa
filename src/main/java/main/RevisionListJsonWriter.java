package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import pojo.Topic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class RevisionListJsonWriter {
    RevisionList revisionList = new RevisionList(new ArrayList<>(Arrays.asList(readTopicsJsonFile())));
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String filePath = Paths.get("topics.json").toAbsolutePath().toString();


    public void addTopic(Topic entry) {
        try (FileWriter writer = new FileWriter(filePath)) {
            revisionList.getRevisionList().add(entry);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, revisionList.getRevisionList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Topic[] readTopicsJsonFile() {
        try (Reader reader = new FileReader(filePath)) {
            String topicsJsonFile = IOUtils.toString(reader);
            return objectMapper.readValue(topicsJsonFile, Topic[].class);
        } catch (IOException e) {
            return new Topic[0];
        }
    }
}
