package Mapper;

import Constants.SORT_CONSTANTS;
import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import java.util.ArrayList;
import java.util.List;

public class GenerateExamples {
    private final static String[] names = {"Gallo","Eustaquio","Ocativo", "Jimena", "Pedro Ramonez","Javier", "German", "Roman", "Enzo", "Marcelo", "Geremias", "Jonathan", "Gustavo", "Octavio", "Ricardo", "Lionel", "Leandro", "Sofia", "Maria", "Pepe", "Claudia"};
    private final static String[] features = {"Maquinaria para edificio", "Elevador", "Tractor", "Escalera", "Agujereador", "Grua", "Grua especial", "Maquinaria especial", "Computadora"};
    private final static char [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void generate(){
        List<Machinery> m = new ArrayList<>();
        int featuresLenght=features.length;
        System.out.println(featuresLenght);
        for(int i=0;i<75;i++){
            Client client = generateClient();
            int status = (int) Math.floor(Math.random()*4 + 1);
            int hoursSince250Service = (int) Math.floor(Math.random()*400);
            int hoursSince1000Service =(int) Math.floor(Math.random()*1300);
            int totalHours = (int) Math.floor(Math.random()*8500);
            int n = (int) Math.floor(Math.random()*features.length);
            String feature=features[n];
            char c = chars[(int) Math.floor(Math.random()*chars.length)];
            String id = c + String.valueOf(i);
            Machinery machinery = new Machinery(id,status,client,feature,hoursSince250Service,hoursSince1000Service,totalHours);
            m.add(machinery);
            //System.out.println(i);

        }
        MachineryManager.saveMachinesInOrder(m,SORT_CONSTANTS.ID);
    }

    private static Client generateClient(){
        String name = names[(int) Math.floor(Math.random()*names.length)];
        int zone = (int) Math.floor(Math.random()*4 + 1);
        return new Client(name,zone);
    }
}
