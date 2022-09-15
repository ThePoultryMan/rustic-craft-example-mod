package io.github.thepoultryman.rustic_craft_example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModFileReader {
    public ModFile readModFile(String modId) {
        Gson gson = new Gson();
        RusticCraftExample.LOGGER.info("Reading mod data file.");
        RusticCraftExample.LOGGER.info(modId);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("assets/" + modId + ".json");
        BufferedReader reader;
        if (inputStream != null) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } else {
            return null;
        }
        ModFile modFile = gson.fromJson(reader, ModFile.class);
        RusticCraftExample.LOGGER.info("Mod file read successfully");
        RusticCraftExample.LOGGER.info("{}", modFile.getModId());
        return modFile;
    }
}
