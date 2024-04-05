import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            File logFile = new File("keystrokes.txt");
            if (!logFile.exists())
            {
                logFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(logFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập từ bàn phím hoặc nhập 'q' để thoát.");
            while (true)
            {
                String key = scanner.nextLine();
                if (key.equals("q"))
                {
                    System.out.println("Quitting...");
                    break;
                }

                System.out.println("Bạn đã nhập: " + key);
                bufferedWriter.write(key);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            scanner.close();
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}