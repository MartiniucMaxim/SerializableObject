import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonTest {
    public static void main(String[]args)
    {

        //используем методы исключения
        //Сериализируем объект через метод исключения (try-catch)
        //В скобкам мы объясняем,куда мы сериализируем данные. И сериализируем в файл "person.dat"



        /*try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            Person p1 = new Person("Maxim","Martiniuc",true);
            Person p2 = new Person("Alyona","Solnteva",true);
            Person p3 = new Person("Mihail","Scvortov",true);
            Person p4 = new Person("Constantin","Belicov",false);
            objectOutputStream.writeObject(p1);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }*/


        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            Person p1=(Person)objectInputStream.readObject();
            System.out.printf("Name:%s \nSurname: %s \nWorking: %b",
                    p1.getName(),
                    p1.getSurname(),
                    p1.getWorking());
        } catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
