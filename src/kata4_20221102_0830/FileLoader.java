package kata4_20221102_0830;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class FileLoader implements Loader {
    private final File file;

    public FileLoader(String fileName) {
        this.file = new File(fileName);
    }   
    
    @Override
    public Iterable<String> items() {
        return new Iterable<String>(){
            @Override
            public Iterator<String> iterator() {
                return createIterator();
            }
        };
    }
    
    private Iterator<String> createIterator() {
        return new Iterator<String>(){
            BufferedReader reader = openReader();
            String nextLine = nextLine();
            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String result = nextLine;
                nextLine = nextLine();
                return result;
            }

            private String nextLine() {
                try {
                    return reader.readLine();
                } catch (Exception ex) {
                    return null;
                }
            }

            
        };
    }
    
    private BufferedReader openReader() {
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    
}
