package edu.unbosque.fourpawcitizens;

import edu.unbosque.fourpawcitizens.model.Manager;

import java.sql.SQLOutput;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {

        Manager manager = new Manager();
        Scanner leer = new Scanner(System.in);

        System.out.println(".:.:.: BIENVENIDO SEÑOR USUARIO :.:.:.");
        System.out.println(manager.uploadData());
        System.out.println(manager.getPets().get(773));
        System.out.println(manager.menu());
        String num = "";
        num = "Ingresa la opción";
        System.out.println(num);
        num = leer.nextLine();
        int n = Integer.parseInt(num);
        while (n > 0) {
            if (n == 1) {
        int n = 1;
        int aux = -1;
        boolean bandera = false;
        boolean banderaRequerimiento =false;
        do{
            System.out.println(manager.menu());
            System.out.println("Ingrese el numero");
            n = leer.nextInt();
            if(n==1){
                System.out.println(manager.uploadData());
                bandera = true;
            }else if(n==2&& bandera == true){
                System.out.println(manager.assingID());
                banderaRequerimiento = true;
            }else if(n==3&& bandera == true){
                System.out.println("Ingrese el micro chip de la mascota a buscar: ");
                leer.nextLine();
                String micro = leer.nextLine();
                System.out.println(manager.findByMicrochip(micro));
            } else if (n == 4) {
                System.out.println("Ingrese Tipo de animal a buscar FELINO o CANINO");
                String input = leer.nextLine();
                if (input.toUpperCase().equals("FELINO") || input.equals("CANINO")) {
                    System.out.println(manager.countBySpecies(input.toUpperCase()));
                } else {
                    System.out.println("Ingrese entrada valida :/.");
            }else if(n==4&&bandera==true){
                int input = -1;
                do{
                    System.out.println("Ingrese Tipo de animal a buscar \n1.FELINO\n2.CANINO ");
                    input = leer.nextInt();
                    leer.nextLine();
                }while(input>2||input<0);
                if(input==1){
                    System.out.println(manager.countBySpecies("FELINO"));
                }else{
                    System.out.println(manager.countBySpecies("CANINO"));
                }
            }else if(n==5&&bandera==true){
                System.out.println("Ingrese la cantidad: ");
                int cantidad = leer.nextInt();
                int pos = 0;
                do{
                    System.out.println("1.Top \n2.Last");
                    pos = leer.nextInt();
                }while(pos>2||pos<0);
                leer.nextLine();
                System.out.println("Ingresa la localidad");
                String localidad = leer.nextLine();

                if(pos==1){
                    System.out.println(manager.findBypotentDangerousInNeighborhood(cantidad,"top",localidad));
                }else{
                    System.out.println(manager.findBypotentDangerousInNeighborhood(cantidad,"last",localidad));
                }

            }else if(n==6&&bandera==true&&banderaRequerimiento==true){
                int sex = 0;
                leer.nextLine();
                do{
                    System.out.println("Ingrese el sexo\n1.Macho\n2.Hembra");
                    sex = leer.nextInt();
                }while(sex>2||sex<0);
                int specie = 0;
                do{
                    System.out.println("Ingrese la especie\n1.felino\n2.canino");
                    specie = leer.nextInt();
                }while(specie>2||specie<0);
                System.out.println("Ingrese la talla ");
                leer.nextLine();
                String talla = leer.nextLine();
                int peligro = 0;
                do{
                    System.out.println("1.Peligroso\n2.No peligroso ");
                    peligro = leer.nextInt();
                }while(peligro>2||peligro<0);
                String sexo = "";
                if(sex==1){
                    sexo = "macho";
                }else{
                    sexo = "hembra";
                }
                String especie = "";
                if(specie==1){
                    especie = "felino";
                }else{
                    especie = "canino";
                }
                String peli = "";
                if(peligro==1){
                    peli = "si";
                }else{
                    peli = "no";
                }
                System.out.println(manager.findByMultipleFields(sexo,especie,talla,peli));

            }else if(n==7){
                aux++;
            }
        }
        }while((n<0||n>7)||aux==-1);
    }
}