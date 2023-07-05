public enum EnumTest {
    AA(1, "aaaaa"),
    BB(1, "bbbbb"),
    CC(1, "ccccc"),
    DD(1, "ddddd");

    private int id;
    private String name;

    EnumTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {

        EnumTest[] enumConstants = EnumTest.class.getEnumConstants();

        EnumTest.values();

        System.out.println(enumConstants);
    }
}
