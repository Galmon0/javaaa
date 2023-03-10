package test;

public interface Stringable {
    int counter();
    String oddNums();
    String inversion();
}
class ProcessStrings implements Stringable {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ProcessStrings(String str) {
        this.str = str;
    }
    public int counter() {
        return str.length();
    }
    public String oddNums() {
        String st = "";
        int i = 0;
        char ch;
        while(i < str.length()) {
            ch = str.charAt(i);
            st += ch;
            i += 2;
        }
        return st;
    }
    public String inversion() {
        String st = "";
        char ch;
        int i = str.length() - 1;
        while(i >= 0) {
            ch = str.charAt(i);
            st += ch;
            i--;
        }
        return st;
    }

    @Override
    public String toString() {
        String res = "Исходная строка: " + str + '\n' +
                "Количество символов в строке: " + counter() + '\n' +
                "Нечётные символы строки: " + oddNums() + '\n' +
                "В обратном порядке: " + inversion();
        return res;
    }
}
class TestProcessStrings {
    public static void main(String[] args) {
        Stringable st = new ProcessStrings("Hello World!");
        System.out.println(st.toString());
    }
}