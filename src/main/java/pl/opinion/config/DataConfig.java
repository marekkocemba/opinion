package pl.opinion.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedMap;

@Configuration
@RequiredArgsConstructor
public class DataConfig {



    @Bean
    public void prepareData() throws IOException {
        Path path = Paths.get("src/main/resources/pracuj.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        String[] parts = line.split("<gpnm-application-brief");
        for(String part : parts){
            String companyLogo = getCompanyLogo(part);
            String[] jobDesc = getJobDesc(part);
            String company = getCompany(part);
            String[] location = getLocation(part);
            String[] recrutationResult = getRecrutationResult(part);

        }

    }

    private String[] getRecrutationResult(String part) {
        int index = part.indexOf("offerExpiration");
        String[] result = {null, null};
        if(index > 0){
            index = index + 61;
            String sub = part.substring(index);
            result[0] = sub.substring(0, 10);
            System.out.println(sub);

        }else{
            System.out.println("!!!!!!!!!!!!! result !!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ part);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return result;
    }

    private String[] getLocation(String part) {
        int index = part.indexOf("information__location");
        String[] location = {null, null};
        if(index > 0){
            index = index + 23;
            String sub = part.substring(index);
            int lastIndex = sub.indexOf("</div>");
            String loc = sub.substring(0, lastIndex);

            int indexLocal = loc.lastIndexOf(",");
            if(indexLocal > 0){
                 location[0] = loc.substring(0,indexLocal);
                 location[1] = loc.substring(indexLocal+2);
                System.out.println(location[0]);
            }else{
                location[0] = loc;
                location[1] = loc;
            }
        }else{
            System.out.println("!!!!!!!!!!!!! location !!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ part);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return location;
    }

    private String getCompany(String part) {
        int index = part.indexOf("information__company");
        String company = null;
        if(index > 0){
            index = index + 22;
            String sub = part.substring(index);
            int lastIndex = sub.indexOf("</div>");
            company = sub.substring(0, lastIndex);
        }else{
            System.out.println("!!!!!!!!!!!!! company !!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ part);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return company;
    }

    private String getCompanyLogo(String part) {
        int index = part.indexOf("company-logo__image");
        String companyLogo = null;
        if(index > 0){
            index = index + 26;
            String sub = part.substring(index);
            int lastIndexPng = sub.indexOf(".png");
            int lastIndexJpg = sub.indexOf(".jpg");
            companyLogo = (sub.substring(0, (lastIndexPng > lastIndexJpg ? lastIndexPng : lastIndexJpg)+4));
        }
        return companyLogo;
    }

    private String[] getJobDesc(String part) {
        int index = part.indexOf("konto.pracuj.txt##moje_aplikacje##link");
        String[] result = {null, null};
        if(index > 0) {
            String sub = (part.substring(index +61));
            int lastIndex = sub.indexOf("\">");
            result[0] = sub.substring(0,lastIndex);
            String sub2 = sub.substring(lastIndex+ 2);
            int lastIndex2 = sub2.indexOf("</a>");
            result[1] = sub2.substring(0, lastIndex2).trim();
        }else{
            System.out.println("!!!!!!!!!!!!!job desc !!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ part);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return result;
    }
}
