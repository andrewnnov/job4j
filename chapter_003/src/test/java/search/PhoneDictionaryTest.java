package search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;



public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );

        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );

        phones.add(
                new Person("Petr1", "Arsentev1", "5348721", "Bryansk1")
        );


        ArrayList<Person> persons = phones.find("Arsentev1");
        assertThat(persons.get(0).getSurname(), is("Arsentev1"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );

        phones.add(
                new Person("Petr1", "Arsentev1", "5348721", "Bryansk")
        );

        ArrayList<Person> persons = phones.find("Bryansk");
        assertEquals(2, persons.size());
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
        assertThat(persons.get(1).getSurname(), is("Arsentev1"));

    }



}
