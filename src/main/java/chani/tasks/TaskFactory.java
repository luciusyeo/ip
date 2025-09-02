package chani.tasks;

public interface TaskFactory {
    Task create(String... args);
}
