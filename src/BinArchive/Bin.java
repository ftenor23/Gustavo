package BinArchive;

import EnterData.EnterData;
import Entity.Machinery;
import Manager.MachineryManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bin {

    private String file_location = "C:/Users/Facundo/IdeaProjects/Gustavo/data/maquinaria.dat";

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

    public void writeMachineryInDisc(){
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
    }

    private int getNumberOfMachines(){
        int counter=0;
        try{
            FileInputStream fileInputStream=new FileInputStream(this.file_location);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Machinery aux = (Machinery) ois.readObject();
            // Se lee el primer objeto

// Mientras haya objetos
            while (aux!=null)
            {
                if (aux instanceof Machinery) {
                    counter++;
                }
                aux = (Machinery) ois.readObject();

            }
            ois.reset();
            ois.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }

    /*public void read()
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.file_location));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            Machinery clase = (Machinery) file.readObject();
            //se cierra archivo
            file.close();
            //Se utilizan metodos de la clase asi como variables guardados en el objeto
            System.out.println("Status:" +  clase.getStatus() );
            System.out.println("Id:" + clase.getId());
            System.out.println("Features:" + clase.getFeatures());
            System.out.println("Client Name: " + clase.getClient().getName());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }*/

    public List<Machinery> readObjetsAndAddToList(){
        List<Machinery> listOfMachinery = new ArrayList<>();

        try{
            //ObjectInputStream ois = new ObjectInputStream(new FileInputStream( this.file_location));
            FileInputStream fileInputStream = new FileInputStream(this.file_location);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);


            Machinery aux = (Machinery) ois.readObject();
            // Se lee el primer objeto

// Mientras haya objetos
            while (aux!=null)
            {
                if (aux instanceof Machinery) {
                    listOfMachinery.add(aux);
                }// Se agrega objeto a lista
                    aux = (Machinery) ois.readObject();

            }

            ois.close();
            fileInputStream.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }catch (EOFException ex){
            System.out.println("Se llego al final del archivo.");
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        catch (IOException ex) {
            System.out.println(ex);
        }finally {
            return listOfMachinery;
        }

    }


}
