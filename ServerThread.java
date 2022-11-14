package ro.mta.ip.TemaJava2.serverClient;

import ro.mta.ip.TemaJava.Human;
import ro.mta.ip.TemaJava.Profesor;
import ro.mta.ip.TemaJava.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;


public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    static ArrayList<Human> humans = new ArrayList<>();

    Comparator<Human> c = new Comparator<Human>() {
        //  https://stackoverflow.com/questions/46429938/adding-to-an-arraylist-in-order-of-age
        @Override
        public int compare(Human o1, Human o2) {
            return Integer.compare(o1.getVarsta(), o2.getVarsta());
        }
    };

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            //Reading the input from Client
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            //returning the output to the client : true statement is to flush the buffer otherwise
            //we have to do it manuallyy
             output = new PrintWriter(socket.getOutputStream(),true);


            //inifite loop for server
            while(true) {
                String outputString = input.readLine();
                //if user types exit command
                if(outputString.equals("exit")) {
                    break;
                }
                printToALlClients(outputString);
                //output.println("Server says " + outputString);
                System.out.println("Server received " + outputString);

                //--------------------------------------------------------------------------
                String type;
                Scanner inputLine = new Scanner(outputString);

                inputLine.next();
                if(inputLine.hasNext()) {
                    inputLine.next();
                    if(inputLine.hasNext()) {
                        inputLine.next();
                        if(inputLine.hasNext()) {
                            type = inputLine.next();

                            if(Objects.equals(type, "Student")) {
                                System.out.println("Se adauga un " + type);
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String acronim = inputLine.next();
                                int varsta =  Integer.parseInt(inputLine.next());
                                int anStudiu = Integer.parseInt(inputLine.next());
                                ro.mta.ip.TemaJava.Student ss = new Student(nume,prenume,acronim,varsta,anStudiu);
                                humans.add(ss);
                                //System.out.println(ss.toString());
                            } else if (Objects.equals(type, "Profesor")) {
                                System.out.println("Se adauga un " + type);
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String acronim = inputLine.next();
                                int varsta =  Integer.parseInt(inputLine.next());
                                String materie = inputLine.next();
                                ro.mta.ip.TemaJava.Profesor pp = new Profesor(nume,prenume,acronim,varsta,materie);
                                humans.add(pp);
                                //System.out.println(pp.toString());
                            }
                            else {
                                System.out.println("Eraore tip human gresit");
                            }

                        }
                    }
                }
                humans.sort(c);
                for(Human hu : humans)
                {
                    System.out.println(hu.toString());
                }
                //------------------------------------------------------------
            }


        } catch (Exception e) {
            System.out.println("Error occured " +e.getStackTrace());
        }
    }

    private void printToALlClients(String outputString) {
        for( ServerThread sT: threadList) {
            sT.output.println(outputString);
        }

    }


}
