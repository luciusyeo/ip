package chani;

public class TodoTaskFactory implements TaskFactory{
    @Override
    public Task create(String... args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("TodoTask requires description");
        }
        return new ToDoTask(args[0]);
    }
}
