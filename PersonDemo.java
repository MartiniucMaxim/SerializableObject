import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonDemo {
    public static void main(String[]args)
    {

        String filename = "employment.text";//задаём перемнную filename.
        ArrayList<Person> employee = new ArrayList<Person>();//через список массивов объектов Person записываем объекты employee
        employee.add(new Person("Tom","Eddison",true));
        employee.add(new Person("Andy","Worhol",true));
        employee.add(new Person("Candys","Wellington",true));
        employee.add(new Person("Nadya","Borkovskaya",true));

        //Делаем cперва сериализацию объектов
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename)))//создаёт сначала объект ObjectOutputStream, где мы записываем сериализацию и в объекте FileOutputStream засовываем наши данные в переменную filename
        {
            objectOutputStream.writeObject(employee);
            System.out.println("Date has been written, now.");
        } catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        //Далее идёт дессериализация объектов в новый список
        ArrayList<Person> newEmployee = new ArrayList<Person>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename)))
        {
            //из объекта newEmployee дессериализуем данные из списка массива объектов и их вычитываем.
            newEmployee=((ArrayList<Person>)objectInputStream.readObject());
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        for(Person person: newEmployee)
        {

            System.out.printf("Name: %s\nSurname: %s\nWorking: %b",
                    person.getName(),
                    person.getSurname(),
                    person.getWorking());
            System.out.println("\n");
        }




    }

}
