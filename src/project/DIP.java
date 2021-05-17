package project;

public class DIP implements IDIP{
    private final IDIP dip;

    public DIP(IDIP dip) {
        this.dip = dip;
    }
    public void start(){
        dip.start();
    }
    public void shutdown(){
        dip.shutdown();
    }
}
