import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class ReadFile3011 {

    public static void main(String[] args) throws IOException {

//        String str = read("E:\\class\\javanangcao\\momo.txt");
//        System.out.println(removeAccent(str));
//        String str1 = readUTF8("E:\\class\\javanangcao\\momo.txt");
//        System.out.println(removeAccent(str1));
//        String str2 = readByLine("E:\\class\\javanangcao\\learning-java-master\\resources\\cadao.txt");
//        System.out.println(str2);
//        String str3 = readBuffer("E:\\class\\javanangcao\\learning-java-master\\resources\\cadao.txt");
//        System.out.println(str3);
//        String str4 = readOnlineResource("https://raw.githubusercontent.com/nam-long/learning-java/master/resources/ca-dao.txt");
//        System.out.println(str4);
        byte[] save = readImage("http://kenh14cdn.com/thumb_w/660/2019/9/27/momo-twice-2-15695742545371936359935.jpg");
        saveFile("E:\\Github\\java_nang_cao_lehongson\\image\\momo.jpg", save);
    }
    public static String read(String filename) throws IOException {
        String str = "";

        InputStream is = new FileInputStream(filename);
        int c;
        while ((c = is.read()) != -1){
            str += (char) c;
        }
        is.close();
        return str;
    }
    public static String readUTF8(String filename) throws IOException{
        String str = "";

        Reader is = new FileReader(filename);
        int c;
        while ((c = is.read()) != -1){
            str += (char) c;
        }
        is.close();
        return str;
    }

    // bỏ dấu tiếng việt
//    public static String removeAccent(String s) {
//
//        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
//    }
    // bỏ dấu tiếng việt từng dòng
    public static String readByLine(String filename) throws IOException {

        String str = "";

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        String line;
        while ((line = dis.readLine()) != null) {
            str += line + '\n';
        }
        is.close();

        return str;
    }
    public static String readUTF8ByLine(String filename) throws IOException{
        String str = "";
        Reader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        int i = 1;
        while ((line = br.readLine()) != null){
            str += line + '\n';
        }
        reader.close();
        return str;
    }
    public static  String readBuffer(String filename) throws IOException {
        String str = null;
        byte[] buffer = new byte[10];
        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int count;
        while ((count = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        str = new String(baos.toByteArray());
        baos.close();
        is.close();
        return str;
    }
    public static String readOnlineResource(String strUrl) throws IOException{
        String str = null;
        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK){
            InputStream is = conn.getInputStream();
            BufferedInputStream bis =  new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1){
                baos.write(buffer, 0, count);
            }
            str = new String(baos.toByteArray());
            is.close();
        }
        return str;
    }
    public static byte[] readImage(String strUrl) throws IOException {
        byte[] str = null;
        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = baos.toByteArray();
            is.close();
            System.out.println("OK Momo");
        }
        return str;
    }
    public static void saveFile(String filename, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }

    public static void downloadResource(String strUrl, String filename) throws IOException{
        String str = null;
        URL url = new URL(strUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buffer = new byte[100];
        int count;
        while ((count = bis.read(buffer)) != -1){

        }
        is.close();
//        return str;
    }
}