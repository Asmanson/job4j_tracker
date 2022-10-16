package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element Not Found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arraynumb = {"Ebay", "Amazon", "Ozon"};
        try {
            System.out.println(indexOf(arraynumb, "Ozo"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}