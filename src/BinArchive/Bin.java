package BinArchive;

import EnterData.EnterData;
import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bin {

    private String file_location = "C:/Users/Facundo/IdeaProjects/Gustavo/data/maquinaria.txt";

    /*public void write(Machinery machinery)
    {
        try {
            //Objeto a guardar en archivo *.DAT
            //Se crea un Stream para guardar archivo

            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.file_location, true));

            //Se escribe el objeto en archivo
            file.writeObject(machinery);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }*/

   /* public void writeMachineryInDisc(){
        try {
            //Objeto a guardar en archivo *.DAT
            //Se crea un Stream para guardar archivo
            FileOutputStream fileOutputStream=new FileOutputStream(this.file_location,true);
            ObjectOutputStream file = new ObjectOutputStream(fileOutputStream);


            boolean saveMoreObjets =true;
            //int counter = getNumberOfMachines();
            int counter = 0;
            while(saveMoreObjets){
                System.out.println("Maquina numero " + counter);
                Machinery machinery = MachineryManager.enterData();
                file.writeObject(machinery); //se escribe objeto en archivo
                System.out.println("Quiere guardar mas maquinaria en el archivo? S/N");
                String answer= EnterData.nextLine();
                if(answer.equalsIgnoreCase("N")){
                    saveMoreObjets=false;
                }
                counter++;
            }

            //se cierra archivo
            file.reset();
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }*/

    public void writeMachineryInDisc(){
        try {
            //hacer una copia de seguridad en otra carpeta cada vez que guardo el archivo
            int newMachineNumber = getNumberOfMachines()+1; //numero de maquinas registradas + 1 por la posicion de la nueva
            RandomAccessFile file = new RandomAccessFile(this.file_location,"rw");

            seekEndOfFile(file);
            boolean saveMoreObjets =true;

            while(saveMoreObjets){
                System.out.println("Maquina numero " + newMachineNumber);
                Machinery machinery = MachineryManager.enterData();
                saveMachineInArchive(machinery,file); //se escribe objeto en archivo
                System.out.println("Quiere guardar mas maquinaria en el archivo? S/N");
                String answer= EnterData.nextLine();
                if(answer.equalsIgnoreCase("N")){
                    saveMoreObjets=false;
                }
                newMachineNumber++;
            }

            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void seekEndOfFile(RandomAccessFile file) throws IOException{
        long fileLenght = file.length();
        file.seek(fileLenght);
    }

    private void saveMachineInArchive(Machinery machinery, RandomAccessFile file){
        try {
            file.writeBytes(machinery.getId() + ";");
            file.writeBytes(machinery.getFeatures() + ";");
            file.writeBytes(machinery.getStatus() + ";");
            file.writeBytes(machinery.getClient().getName() + ";");
            file.writeBytes(machinery.getClient().getZone() + "\n");
        }catch (IOException e){
            System.out.println("Exception: " + e);
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }

    }

    private int getNumberOfMachines(){
        int counter=0;
        try {
            RandomAccessFile file = new RandomAccessFile(this.file_location, "r");
            String line = file.readLine();
            while(line!=null) {
                counter++;
                line = file.readLine();
            }

            file.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return counter;
    }


    public List<Machinery> readObjetsAndAddToList(){
        List<Machinery> listOfMachinery = new ArrayList<>();
        try{
            RandomAccessFile file = new RandomAccessFile(this.file_location,"r");
            file.seek(0);

            String line = file.readLine();
            while(line!=null) {
                listOfMachinery.add(getMachinery(line));
                line = file.readLine();
            }
            file.close();
        }catch(IOException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }

        return listOfMachinery;


    }

    private Machinery getMachinery(String line){

        //1234;Televisor 23pulgadas ;1;facundo tenor;1
        String[] parts = line.split(";");
        System.out.println(parts[0] + parts[4]);

        String id = parts[0];

        String features = parts[1];

        int status = Integer.parseInt(parts[2]);
        int clientZone = Integer.parseInt(parts[4]);
        String clientName = parts[3];
        Client client=new Client(clientName,clientZone);

        return new Machinery(id,status,client,features);
    }


}
