package TextEditor;


import java.io.*;
import java.nio.Buffer;

public class FileHandler {

    private String inpath;
    private String outpath;

    public void setInpath(String inpath) {
        this.inpath = inpath;
    }

    public void setOutpath(String outpath) {
        this.outpath = outpath;
    }

    private String Text;

    FileHandler() {

    }

    public boolean savefile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outpath))) {
            writer.write(Text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readfile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inpath))) {
            StringBuilder string = new StringBuilder();
            while (reader.ready()) {
                string.append(reader.readLine());
                string.append("\n");
            }
            Text = string.toString();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
