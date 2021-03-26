package net.badbird5907.mintsmp.manager;

import net.badbird5907.mintsmp.MintSMP;
import net.badbird5907.mintsmp.team.User;

import java.io.*;

public class FileManager {
    public static void saveUser(User user) throws IOException {
        File file = new File(MintSMP.getInstance().getDataFolder() + "/playerdata/" + user.uuid + ".json");
        file.delete();
        //just to be safe
        file.createNewFile();
        String json = MintSMP.getGson().toJson(user);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(json);
        writer.close();
    }
}
