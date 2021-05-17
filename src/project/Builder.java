package project;

public class Builder {
    private final String version;

    private Builder(HelperBuilder builder) {
        this.version = builder.version;
    }
    public static class HelperBuilder
    {
        private String version;
        public HelperBuilder version (String version) {
            this.version = version;
            return this;
        }
        public Builder build() {
            return new Builder(this);
        }
    }

    @Override public String toString() {
        return "------------------------------------\n" +
                "-----Smart Cooling Device Build-----\n" +
                "------------Version: " + version + "-----------\n" +
                "------------------------------------\n\n";
    }

}
