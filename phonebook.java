import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения записей телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иванов", "111111");
        addContact(phoneBook, "Петров", "222222");
        addContact(phoneBook, "Сидоров", "333333");
        addContact(phoneBook, "Иванов", "444444");
        addContact(phoneBook, "Петров", "555555");

        // Получаем список контактов, отсортированный по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedContacts = sortContacts(phoneBook);

        // Выводим контакты на экран
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Телефоны: " + entry.getValue());
            System.out.println();
        }
    }

    // Метод добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    // Метод сортировки контактов по убыванию числа телефонов
    private static List<Map.Entry<String, List<String>>> sortContacts(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());
        return sortedContacts;
    }
}