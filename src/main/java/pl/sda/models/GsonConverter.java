package pl.sda.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GsonConverter {

    Gson gson = new Gson();

    public List<JsonNode> fromJson(File file) throws IOException {
        return Arrays.asList(gson.fromJson(toString(file), JsonNode[].class));
    }


    private String toString(File file) throws IOException {
        return Files.readString(file.toPath());
    }
}
