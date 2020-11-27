import java.io.*;
//Описываем класс Person с тремя приватными полями и имплементируем интерфейс Serializable
//Serializable - интерфейс, не имеющий методов. Но он нужен виртуальной машине
//, чтобы объекты даннного класса могли быть сериализированы в байты.

public class Person implements Serializable {
      private String name;
      private String surname;
      private boolean working;

      Person(String name,String surname, boolean working)
      {
          this.name=name;
          this.surname=surname;
          this.working=working;
      }

      public void setName(String name)
      {
          this.name = name;
      }

    public String getName() {
        return name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    boolean getWorking()
    {
        return working;
    }
}
