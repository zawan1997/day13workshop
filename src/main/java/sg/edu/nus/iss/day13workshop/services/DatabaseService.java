package sg.edu.nus.iss.day13workshop.services;

import java.io.File;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    //need somewhere to store dataDir
    private File dataDir = new File("some directory");

    public File getDataDir() {
        return dataDir;
    }

    public void setDataDir(){
        //so that it refers to the class File dataDir
        this.dataDir=dataDir;
    }

    // /Users/<username/data
    public boolean isDataDirValid(){
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

    public void setDataDir(File file) {
    }
}
