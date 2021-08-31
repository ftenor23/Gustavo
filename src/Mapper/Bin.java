package Mapper;

import Entity.Machinery;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.sql.*;

public class Bin {

    //private static final String FILE_LOCATION = "../Gustavo_jar/maquinaria.txt";
    private static final String FILE_LOCATION = "maquinaria.txt";






    public static List<Machinery> readObjetsAndAddToList(){
        List<Machinery> listOfMachinery = new ArrayList<>();
        RandomAccessFile file;
        try{
            file = new RandomAccessFile(FILE_LOCATION,"r");
            file.seek(0);

            String line = file.readLine();
            while(line!=null) {
                listOfMachinery.add(getMachinery(line));
                line = file.readLine();
            }
            file.close();
        } catch(Exception e){
            System.out.println("Exception: " +e);
        }
        return listOfMachinery;
    }

    private static Machinery getMachinery(String line){
        Gson gson=new Gson();
        return gson.fromJson(line,Machinery.class);
    }

    public static void overwriteArchive(List<Machinery> list){
        Gson gson=new Gson();
        try{
            eraseArchive();
            RandomAccessFile file = new RandomAccessFile(FILE_LOCATION,"rw");
            file.seek(0);
            String line;
            for (Machinery machinery : list) {
                line = gson.toJson(machinery);
                file.writeBytes(line + "\n");
            }
        file.close();
        } catch(Exception e){
            System.out.println("Exception " +e);
        }
    }


    private static void eraseArchive(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_LOCATION));
            bw.write("");
            bw.close();
        }catch(Exception e){
            System.out.println("Exception: " +e);
        }
    }

    /*public static void saveInDB(Machinery machinery){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_maquinarias","root","");
            PreparedStatement pst = cn.prepareStatement("insert into maquinarias values(?,?,?,?,?,?,?)");
            pst.setString(1, machinery.getId().trim());
            pst.setInt(2,machinery.getStatus());
            pst.setString(3, machinery.getClientName());
            pst.setInt(4,machinery.getClientZone());
            pst.setString(5, machinery.getFeatures().trim());
            pst.setString(6, machinery.getPending().trim());
            pst.setInt(7,machinery.getHoursOfUse());
            pst.executeUpdate();
        }catch(Exception e){

        }
    }*/
}
