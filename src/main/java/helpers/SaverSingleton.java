package helpers;

public class SaverSingleton {
    private static SaverSingleton ourInstance = new SaverSingleton();

    public static SaverSingleton getInstance() {
        return ourInstance;
    }

    private SaverSingleton() {
    }

    private String first = "", second = "";

    public void setParameters(String firstS, String secondS) {
        first = firstS;
        second = secondS;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
