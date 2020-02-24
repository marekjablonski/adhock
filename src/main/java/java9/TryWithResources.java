package java9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        System.out.println(readData("test"));
    }
    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
//java 8:
       // try (BufferedReader br1 = br) {
        //    return br1.readLine();
      //  }
        // java 9   we can put object reference to try with resources

//        try (br) {
//            return br.readLine();
//        }
        return "dd";
  }
}
