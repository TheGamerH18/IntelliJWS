package _20210920;

import tools.Tools;

public class CopyDelete {
    Tools tools = new Tools();

    CopyDelete() {
        String text = tools.readfromfile("C:\\Folder\\log.txt", true)[0];
        tools.print(text);
        tools.writetofile("C:\\Folder\\CopyLog.txt", text);
        tools.writetofile("C:\\Folder\\log.txt", "");
    }

    public static void main(String[] args) {
        CopyDelete copyDelete =new CopyDelete();
    }
}
