package model;
import com.google.gson.Gson;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
    public ArrayList<Country> load(){
        try {

            File file = new File("src/outs/countries.json");
            if (!file.exists()) {
                return new ArrayList<>();
            }
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String json = "";
            String line;
            while ( (line = reader.readLine()) != null ){
                json+=line;
            }
            fis.close();
            Gson gson = new Gson();
            Country[] Countrys2 = gson.fromJson(json, Country[].class);

            return new ArrayList<>(Arrays.asList(Countrys2));
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void savedata (ArrayList<Country> data){
        Gson gson = new Gson();
        String json = gson.toJson(data);
        try {
            FileOutputStream fos = new FileOutputStream("src/outs/countries.json");
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Country> regcountry(String info, ArrayList<Country> olimpic) throws Exception  {
		try{
			String [] m= info.split("::");
        boolean flag=false;
        int important=0;
        Country c = null;
        if(olimpic.size()>0){
            for(int i=0;i< olimpic.size() && flag==false;i++){
                if(olimpic.get(i).getName().equalsIgnoreCase(m[0])){
                    important=i;
                    flag=true;
                }
            }
            if(searchexistence(info,olimpic)){
                switch (m[1]){

                    case "bronce":
                        olimpic.get(important).setBronce(olimpic.get(important).getBronces()+Integer.parseInt(m[2]));
                        break;
                    case "plata":
                        olimpic.get(important).setPlata(olimpic.get(important).getPlatas()+Integer.parseInt(m[2]));
                        break;
                    case "oro":
                        olimpic.get(important).setOro(olimpic.get(important).getOros()+Integer.parseInt(m[2]));
                        break;
                }
            }else{
                switch (m[1]){
                    case "bronce":
                        c= new Country(m[0],Integer.parseInt(m[2]),0,0);
                        break;
                    case "plata":
                        c= new Country(m[0],0,Integer.parseInt(m[2]),0);
                        break;
                    case "oro":
                        c= new Country(m[0],0,0,Integer.parseInt(m[2]));
                        break;
                }
                olimpic.add(c);
            }
            return olimpic;
        }else{
            switch (m[1]){
                case "bronce":
                    c= new Country(m[0],Integer.parseInt(m[2]),0,0);
                    break;
                case "plata":
                    c= new Country(m[0],0,Integer.parseInt(m[2]),0);
                    break;
                case "oro":
                    c= new Country(m[0],0,0,Integer.parseInt(m[2]));
                    break;
            }
        }
        olimpic.add(c);
        return olimpic;
		}catch(Exception e){
			throw new Exception("informacion ingresada de manera incorrecta y/o con datos en el orden incorrecto");
		}
        
    }

    private boolean searchexistence(String info, ArrayList<Country> olimpic) {
        boolean flag=false;
        int p=0;
        String[] m=info.split("::");
        for(int i=0;i< olimpic.size();i++){
            if(olimpic.get(i).getName().equalsIgnoreCase(m[0])){
                return true;
            }
        }
        return false;
    }

    public String showmedals(ArrayList<Country> olimpic) {
        int i=0;
        String m="";
        Collections.sort(olimpic);
        while ( i< olimpic.size() && olimpic.get(i)!=null){
            m=m+olimpic.get(i).getName()+": "+"oros: "+olimpic.get(i).getOros()+", platas: "+olimpic.get(i).getPlatas()+", bronces: "+olimpic.get(i).getBronces()+"\n";
            i++;
        }
        return m;
    }

    public String listmedals(ArrayList<Country> olimpic) {
        int i=olimpic.size()-1;
        String m="";
        Collections.sort(olimpic, Comparator.comparingInt(Country::getTotalmedallas));
        while ( i>= 0 && olimpic.get(i)!=null){
            m=m+olimpic.get(i).getName()+": "+olimpic.get(i).getTotalmedallas()+"\n";
            i--;
        }
        return m;
    }

    public String ordernames(ArrayList<Country> olimpic) {
        ArrayList<Country> list = new ArrayList<>();
        list=olimpic;
        int n = list.size();
        int z=0;
        String m="";
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (list.get(j).getName().compareToIgnoreCase(list.get(j+1).getName()) > 0) {
                    Country temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        n=n-1;

        while ( n>= 0 && z<=n){
            m=m+olimpic.get(z).getName()+"\n";
            z++;
        }
        return m;
    }
}
