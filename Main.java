import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(222, "Серж Корж Иванович", 22, "+79252223344"));
        contactList.addToEnd(new Contact(345, "Иванов Сергей Петрович", 33,  "+798533362222"));
        contactList.addToEnd(new Contact(456, "Дениска Редиска Редиска", 44, "+79255555555"));
        contactList.addToEnd(new Contact(678, "Денисенко Лариса Ивановна", 23, "+79255144222"));
        contactList.addToEnd(new Contact(789, "Иванов Иван Иванович", 25, "+79251112233"));
        contactList.addToEnd(new Contact(234, "Семенов Сергей Иванович", 55, "+79252223344"));
        contactList.addToEnd(new Contact(345, "Петров Сергей Петрович",60, "+798533362222"));
        contactList.addToEnd(new Contact(456, "Михайлов Андрей Петрович", 18, "+79255555555"));
        contactList.addToEnd(new Contact(678, "Медведев Иван Сергеевич", 39,  "+79255144222"));
        contactList.addToEnd(new Contact(789, "Герман Татьяна Петровна",23, "+79251112233"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();

        System.out.println("РАЗВОРОТ СВЯЗАННОГО СПИСКА");

        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {
        int id;
        String name;
        int age;
        String phone;

        /**
         * @param id
         * @param name
         * @param i
         * @param phone
         */
        public Contact(int id, String name, int age, String phone) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", ФИО='" + name + '\'' +
                    ", Возраст='" + age + '\'' +
                    ", Телефон='" + phone + '\'' +
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable {
        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {

            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            if (isEmpty()) {
                head = newItem;
                tail = newItem;

            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        
        /**
         *  Разворачиваем список, с проверкой если не пусто.
         */
        public void reverse() {
            if (!isEmpty() && head.next != null) { 
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}