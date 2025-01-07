public enum Denomination3{penny(.01), nickel(.05), dime(.01), quarter(.25);

    private final double value;

    private Denomination3(double value) {
        this.value = value;}

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

