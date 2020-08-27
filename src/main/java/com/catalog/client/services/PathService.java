package com.catalog.client.services;

import com.catalog.client.dto.PathDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Igor on 8/25/2020.
 */
@Service
public class PathService {

    public List<String> getFolderContent(PathDto dto){

        String path = createPath(dto.getPath());

        File folder=new File(path);
        File[] listOfFiles=folder.listFiles();

        List<String> result = Arrays.stream(listOfFiles).map(File::getName).collect(Collectors.toList());
        return result;
    }

    private String createPath(String path){

        String[] parts = path.split("/");
        StringBuffer result = new StringBuffer().append(File.separator);
        for( String t : parts ){
            result.append(t).append(File.separator);
        }
        return result.toString();

        //return "\\\\\\\\"+getComputerName()+"\\\\"+path.replaceAll("/","\\\\").replaceAll(":", "");
    }

    public static void main(String[] args){
        //System.out.println(createPath("e:\\filmovi\\"));
        //String path = "\\\\8700k\\d\\filmovi";

       List<String> result = new PathService().getFolderContent( new PathDto("d:/filmovi") );
        result.stream().forEach( d -> { System.out.println(d);});
    }




    private String getComputerName()
    {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }

}
