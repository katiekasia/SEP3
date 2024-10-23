public class main {
    public static void main(String[] args) {
        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();

        EventRepository eventRepository = new EventRepository(databaseSingleton);

        eventRepository.createUser("Danny");
    }
}
