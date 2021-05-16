package VS.Services;

import VS.Model.Produs;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

import static VS.Services.FileSystemService.getPathProdusToFile;

public class ProduseService {
    public static ObjectRepository<Produs> produsRepository;


    public static void initProdusDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathProdusToFile("Produse.db").toFile())
                .openOrCreate("admin", "admin1");

        produsRepository = database.getRepository(Produs.class);
    }

    public static void addProduse(String nume, String pret, String categorieprodus)
    {

     Produs produs = new Produs(nume,pret,categorieprodus);
        produsRepository.insert(produs);

    }
    public static void getProdusePreturi(ObservableList<String> produse){
        for(Produs produs: produsRepository.find()) {
            if(produs.getNume()!=null)
            produse.add(produs.getNume()+" "+produs.getPret()+" "+produs.getCategorieprodus());
        }
    }
    public static void getProduseHaine(ObservableList<String> produse){
        for(Produs produs: produsRepository.find()) {
            if(produs.getCategorieprodus()!=null)
                produse.add(produs.getCategorieprodus());
        }
    }

    public static ArrayList<Produs> getProduseSelectate(String item){
        ArrayList<Produs> produse = new ArrayList<>();
        for(Produs produs : produsRepository.find())
            if(Objects.equals(item, produs.getCategorieprodus()))
            produse.add(produs);
        return produse;
    }

    public static ArrayList<Produs> getProduse(){
        ArrayList<Produs> produse = new ArrayList<>();
        for(Produs produs : produsRepository.find())
            produse.add(produs);
        return produse;
    }

}


