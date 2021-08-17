package Mapper;

import Constants.SORT_CONSTANTS;
import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import java.util.ArrayList;
import java.util.List;

public class GenerateExamples {
    private final static String[] names = {"Javier", "German", "Roman", "Enzo", "Marcelo", "Geremias", "Jonathan", "Gustavo", "Octavio", "Ricardo", "Lionel", "Leandro", "Sofia", "Maria", "Pepe", "Claudia"};
    private final static String[] features = {"Maquinaria para edificio", "Elevador", "Tractor", "Escalera", "Agujereador"};
    private final static char [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void generate(){
        List<Machinery> m = new ArrayList<>();
        for(int i=0;i<1000;i++){
            Client client = generateClient();
            int status = (int) Math.random()*4 + 1;
            int hoursOfUse = (int) Math.random()*1150;
            String feature=features[(int) Math.random()*features.length];
            char c = chars[(int) Math.random()*chars.length];
            String id = c + String.valueOf(i);
            Machinery machinery = new Machinery(id,status,client,feature,hoursOfUse);
            m.add(machinery);
            System.out.println(i);

        }
        MachineryManager.saveMachinesInOrder(m,SORT_CONSTANTS.ID);
    }

    private static Client generateClient(){
        String name = names[(int) Math.floor(Math.random()*names.length)];
        int zone = (int) Math.random()*4 + 1;
        return new Client(name,zone);
    }
}