
package com.mycompany.lab13;

import java.lang.System.Logger.Level;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
public class Main {
    //nazwa klasy sterownika do bazy danych
    public String driver="org.apache.jdbc.EmbeddedDriver";
    
    //Framework- tryb w jakim chcemy mieć dostęp do bazy danych(wbudowany-silnik bazy danych
    //zintegorwany z naszą aplikacją)
    private String framework="embedded";
    
    //Nazwa protokołu komunikacyjnego- rózna dla różnych silników baz danych
    private String protocol="jdbc:derby:c:\\Users\\Ja\\Desktop\\Derby\\derbyDB;create=true;";
     
    
  
    public static void main(String[] args) {
        new Main().workWithDB(); 
       
        System.out.println("Aplicatioc Stop working");
    }
   
    void workWithDB()
    {
        //Deklaracja niezbędnych zmiennych
        //Połączenie do bazy danych
        Connection myConn=null;
        
        //Pomocnicza kolekcja na zapytania do bazy danych
        ArrayList<Statement> statements=new ArrayList<>();
        
        //Zmienne reprezentujące wyrażenia-zapytania do bazy danych parametryzowane
        PreparedStatement psInsert;
        PreparedStatement psUpdate;
        
        // zwykłe zmienne
        Statement s;
        //Zbiór rezultatów zapytań
        ResultSet rs=null;
        
        try{
            //Załadowanie i rejestracja sterowników sterownika(klasy tłumaczącej zapytania na
            // wywołania API silnika bazy danych) do DMBS Derby
            
            Class.forName(driver).getDeclaredConstructor().newInstance();
            
            Properties props=new Properties(); // właściwości połączenia
            
            props.put("user","user1");
            props.put("password","user1");
            
            String dbName="derbyDB"; // nazwa bazy danych dowolna
            
            myConn=DriverManager.getConnection(protocol);
            System.out.println("Connected to and created database"+dbName);
            
            myConn.setAutoCommit(false);
            
            //Tworzymy obiekt wyrażenia, który będzie stosowany do różnych zapytań w języku SQL do bazy danych
            s=myConn.createStatement();
            
            //Dodajemy wyrażenia do pomocniczej kolekcji
            statements.add(s);
            
            //Tworzymy tabelę z dwoma kolumnami.. Używając polecenia języka DDL(Data Definition Language)
            s.execute("create table location(num int,addr varchar(40)");
            System.out.println("Created table location");
            
            // I dodajemy kilka wierszy danych ...
            
            psInsert=myConn.prepareStatement("insert into location values(?,?)");
            //znaki zapytania to parametry, pod którą podstawione zostaną wartości
            
            //Zapis do kolekcji pomocniczej zapytań
            statements.add(psInsert);
            
            //Ustawienie wartości pierwszego parametru pod "?"
            psInsert.setInt(1,1956);
            //Ustawienie wartości drugiego parametru
            psInsert.setString(2,"Webster St");
            
            System.out.println("Inserted 1956 Webster");
            
            psInsert.setInt(1,1910);
            psInsert.setString(2,"Union St.");
            psInsert.executeUpdate();
            System.out.println("Inserted 1910 Union");
            
            psUpdate=myConn.prepareStatement("update location set num=?,addr=? where num=?");
            statements.add(psUpdate);
            
            psUpdate.setInt(1,180);
            psUpdate.setString(2,"Grand Ave");
            psUpdate.executeUpdate();
            System.out.println("Update 1956 Webster to 180 Grand");
            
            psUpdate.setInt(1,300);
            psUpdate.setString(2,"Lakeshore Ave");
            psUpdate.setInt(3,180);
            psUpdate.executeUpdate();
            System.out.println("Updated 180 Grand to 300 Lakeshore");
            
            rs=s.executeQuery("SELECT num,addr FROM location ORDER BY num");
            
            int number; // numer domu pobrany z bazy danych
            boolean failure=false;
            
            if(!rs.next()){
                failure=true;
                //pomocnicza metoda do ładnego formatowania komunikatów o błędach
                reportFailure("No rows in ResultSet");
            }
            // Pobieramy wartość ze wskazanej kolumny( za pomocą numeru kolumny lub jej nazwy) z aktywnego
            //wiersza zbioru rezultatów
            
            if((number=rs.getInt(1))!=300){
                failure=true;
                reportFailure("Wrong row returned, expected num=300,got "+number);
            }
            
            if(!rs.next()){
                failure=true;
                reportFailure("Too few rows");
            }
            if((number=rs.getInt(1))!=1910){
                failure=true;
                reportFailure("Wrong row returned, expected num=1910, got "+number);
            }
            
            if(rs.next()){
                failure=true;
                reportFailure("Too many rows");
            }
            
            if(!failure){
                System.out.println("Verified the rows");
            }
            // sunięcie tabeli z bazy danych całkowicie tracimy dane z bazy danych
            s.execute("drop table location");
            System.out.println("Dropped table location");
            
            // Zatwierdzamy transakcję dopiero teraz wszystkie inserty, update-y zajdą dopiero teraz
            
            myConn.commit();
            System.out.println("Committed the transaction");
            
            if(framework.equals("embedded"))
            {
                try{
                    // atrybut shutdown=true wyłącza Derby
                    Connection connection = DriverManager.getConnection("jdbc:derby:jdbc:derby:c:\\Users\\Ja\\Desktop\\Derby\\derbyDB;shutdown=true");
                }catch(SQLException se)
                {
                    if((se.getErrorCode()==5000) &&("XJ015".equals(se.getSQLState())))
                    {
                        // dostajemy wyjątek oczekiwany
                        System.err.println("Derby shutdown normally");
                        // Oczekiwany wyjątek przy zamykaniu jednej bazy danych to:
                        //SQL stat="09006" i kod błędu 4500
                    }else
                    {
                        // jeśli kod błędu lub SQL state jest inny, mamy nieoczekiwany wyjątek
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                }
               }  
              }
      }catch(SQLException sqla)
      {
          // Metoda pomocnicza do wyświelania błędów
          printSQLException(sqla);
      }catch(ClassNotFoundException ex){
          
      }catch(InstantiationException ex){
          
      }catch(IllegalAccessException ex){
         
          
      }catch(NoSuchMethodException ex){
          
      }catch(SecurityException ex){
         
      }catch(IllegalArgumentException ex){
        
      }catch(InvocationTargetException ex){
         
      }finally{
            // zwolnienie wszystkich otwartych zasobów w celu uniknięcia niechcianego zajęcia pamięci
            
            //ResultSet
         try{
             if(rs!=null)
                {
                   rs.close();
                   rs=null;
                } 
            }  catch(SQLException sqle){
                printSQLException(sqle);
            }         
        }
        
        // Statements i PreparedStatements
        
        int i=0;
        while(!statements.isEmpty()){
            //PreparedStatement dziedziczy po Statement
            
         Statement st=(Statement)statements.remove(i);
         
         try{
             if(st!=null){
                 st.close();
                 st=null;
             }
         }catch(SQLException sqle){
             printSQLException(sqle);
         }
            
        }
        //Connection
        try{
            if(myConn!=null){
                myConn.close();
                myConn=null;
            }
        }catch(SQLException sqle){
            printSQLException(sqle);
        }
    }
    
    private void reportFailure(String message){
        System.err.println("\nData verification failed");
        System.err.println("\t+message");
    }
    
    public static void printSQLException(SQLException e){
        
        //Rozpakowuje łańcuch wyjątków, w celu określenia rzeczywistego powodu wystąpienia wyjątku
        
        while(e!=null){
            System.err.println("\n-----SQLException-----");
            System.err.println(" SQL State "+e.getSQLState());
            System.err.println(" Error Code: "+e.getErrorCode());
            System.err.println(" Message: "+ e.getMessage());
            
            e=e.getNextException();
        }
    }
}