package practice;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class MethodTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        List<String> failedList=new ArrayList<>();
        list.add("http://cdn.vyng.me/public/09c11af9-b773-4114-9b09-e614dcadf1f1/24469053_opt.mp4");
        list.add("https://storage.googleapis.com/vyng-app-storage/public/000004b5-81a0-466f-817b-62305acb163b/000004b5-81a0-466f-817b-62305acb163b.mp3");
        getPathListForOldBucket(list,failedList).forEach(System.out::println);
    }

    private static List<String> getPathListForOldBucket(List<String> urlList, List<String> failedUrlLists) {
        List<String> pathList = new ArrayList<>();
        for (String url : urlList) {
            if (url != null) {
                try {
                    String decodeURL = URLDecoder.decode(url, "UTF-8");
                    if (decodeURL.contains("vyng-app-storage")) {
                        String[] urlArray = decodeURL.split("vyng-app-storage/");
                        if (urlArray.length > 1) {
                            String path = urlArray[1].split("\\?")[0];
                            pathList.add(path);
                        }
                    }
                    else if(decodeURL.contains("cdn.vyng.me/public/")){
                        String[] urlArray = decodeURL.split("public/");
                        if (urlArray.length > 1) {
                            String path = "public/"+urlArray[1];
                            pathList.add(path);
                        }
                    }
                } catch (Exception e) {
                    failedUrlLists.add(url);
                    //logger.info(e.getMessage());
                }
            }
        }
        return pathList;
    }
}
