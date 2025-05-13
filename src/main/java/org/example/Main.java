package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//          Student student = new Student();
//        student.setsName("Priya");
//        student.setRollNo(36);
//        student.setsAge(27);
//          student.setsName("Chinthakai");
//          student.setRollNo(37);
//          student.setsAge(27);
        //Student s2 = null;
//        Laptop laptop = new Laptop();
//        laptop.setId(1);
//        laptop.setBrand("Acer");
//        laptop.setName("Acer-Nani");
//        laptop.setRam(8);
//
//        Laptop laptop1 = new Laptop();
//        laptop1.setId(2);
//        laptop1.setBrand("DELL");
//        laptop1.setName("DELL-Nani");
//        laptop1.setRam(16);
//
//        Laptop laptop2 = new Laptop();
//        laptop2.setId(3);
//        laptop2.setBrand("HP");
//        laptop2.setName("HP-Nun");
//        laptop2.setRam(8);

//        Coders co = new Coders();
//        co.setcId(101);
//        co.setcName("Naveen Kumar K");
//        co.setcRollNo(24);
//        co.setLaptop(Arrays.asList(laptop,laptop1));
//        laptop.setCoder(co);
//        laptop1.setCoder(co);
//        Coders co1 = new Coders();
//        co1.setcId(102);
//        co1.setcName("Bot E");
//        co1.setcRollNo(25);
//        co1.setLaptop(List.of(laptop2));
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
        //we can optimize the above code here Configuration is a class that implements
        // SessionFactory so to use methods in SessionFactory we need object of Configuration and to connect your class with
        //we can use addAnnotatedClass Method. we need to configure() it After that it Searches for the configuration in the resource folder
        //so we created what it is searching for in the resource folder which is hibernate.cfg.xml and we have mentioned needed to connect with
        //database which is Postgres.
        //finally we need the object of SessionFactory to open a Session because when we are working database you need to store and fetch data
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Coders.class) // org.example.Student.class
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();//cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        //session.save(student) it also works
        //session.persist(student);//save is deprecated because hibernate tries to meet the standards of jakarta persistence API. so using persist makes sense
        //transaction.commit();
        //if we opened a costly resource you definitely need to close it here SessionFactory is a heavy object. SO close after Using it

        //how to fetch data from the database
        // we don't need Transaction to fetch the data from the database it is needed when we manipulate on data.
        //we can use get method in the Session to fetch the data providing object of type Student and primary key
        //In this we don't need to worry about how to convert SQL query to Object format hibernate automatically does that
        //And we worried about Converting an Object into an SQL Query format during persist
        //s2 = session.get(Student.class,24);
        //s2 = session.get(Student.class,42); it will return null there is no data with primary key in the database

        // how to update the data and remove the data from the database
        // here we are performing manipulating data we need transaction others it won't  update or get deleted

        //update in there is method call called update() in Session but it got deprecated so we use merge()
        //to do this first we need to get the object and then update if you have data to update mention
        //it in the student.setName("Dash") -- > student.setName("priya") and paas the object student to the merge

        //session.merge(student);it will update Dash to Priya first hibernate select the query on the primary and then update if it has.
        //if the object is not found then it is going to insert it into the table
        //session.merge(student);//I don't have 37 primary key in the table it is inserted object "chinthakai" into the table it will in both ways to update and inset

        // now let's delete the data from the database to do this first we need to get the object and then pass it to remove method in Session.
        //here I am deleting Chintakai Object from the table
//        Student s1;
//        s1 = session.get(Student.class,37);
//        session.remove(s1);//It removed Chintakai Object from the table.
//        //what if we try to delete the not existing object lets see
//        s1 = session.get(Student.class,37);
//        session.remove(s1);//Exception in thread "main" java.lang.IllegalArgumentException: attempt to create delete event with null entity
        //No chintakai object present so it returned illegalArgumentException

        //Now we are going to know how to change the table and column names using Coders class
//        session.persist(laptop);
//        session.persist(laptop1);
//        session.persist(laptop2);

//        session.persist(co);
//        session.persist(co1);

//        transaction.commit();//you need commit transaction to update delete add and other except select
        //sf.close();
//        session.close();
//        Session session1 = sf.openSession();
//        Coders c = session1.get(Coders.class,102);
        //when we have collection in an entity it basically uses something called lazy fetch by
        //default it is implementing lazy fetch but why? what if you have huge amount of data that
        // you don't need it then simply by calling a get method fetching everything from the table
        //it will be expensive that's why it's says i will do it when you need it. so you have to mention it
        // when you try to print it will do it like i am printing coder c.
        // what if you don't want lazy you want eager in that case we can mention it go to Coders and mention this property
        //@OneToMany(fetch = FetchType.EAGER)
        //keep it lazy for the production
        //System.out.println(c);
//        sf.close();
//        session1.close();
//        System.out.println(s1);
        //System.out.println(student);
        //System.out.println(co);


        //Let's learn how to do HQL
        //we are only working on Laptop to make it simple
        // I want to get the data from the Laptop based on ram or something other from the DB not from primary Key
        //For that we have HQL we can apply filters and do just like we do in SQL
        //here Query is an interface so we cannot create object for it directly and Session is the that implements it
//        String brand = "Acer";
//        Query query = session.createQuery("select name from Laptop where brand like ?1");
//        query.setParameter(1,brand);
//        // now lets execute it
//        List<Laptop> list = query.getResultList();
//        System.out.println(list);
        //let's learn about Ehcache first Ehcache means if establishing a some kind connection between sessions in server
        // For example I have a React client i as a user asked the client to give me some data so react client will
        //send a request to the server and the server creates a session and gets the data from the database and send it back to react client
        //now that particular session has the data that i asked if i asked it again sever will send that data without making any request to database
        //what if while getting the data i changed it. It must be changed in database but the session knows previous data
        //Here the query got filed only one time and printed it 2 times we are in the same session
//        Laptop laptop = session.get(Laptop.class,2);
//        System.out.println(laptop);
//        Laptop laptop1 = session.get(Laptop.class,2);
//        System.out.println(laptop1);
        //here same query got fired 2 times to get the data what if we establish connection between session and s1 to execute the query 1 time and print the data twice
        // Go to Laptop and add annotation @Cacheable
        Laptop l1 = session.get(Laptop.class,2);
        System.out.println(l1);
        session.close();
        Session s1 = sf.openSession();
        Laptop l2 = s1.get(Laptop.class,2);
        System.out.println(l2);
        s1.close();
        sf.close();
//        session.close();
//        s1.close();


    }
}