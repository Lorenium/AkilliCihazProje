package project;

import java.util.Scanner;

public class SmartCoolingDevice {
    final private INetworkOps networkOps;
    final private IDatabaseOps databaseOps;
    private static final int t = 250;

    public SmartCoolingDevice() {
        networkOps = new NetworkOps();
        databaseOps = new DatabaseOps();
    }
    public static void freeze(int timeout){
        try{
            Thread.sleep(timeout);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void freeze(){
        try {
            Thread.sleep(t);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public void login(){
        String username;
        String password;
        System.out.println("Giris bilgilerinizi dogrulayiniz:");
        System.out.print("Kullanici adi:");
        username= networkOps.getData();
        System.out.print("Sifre:");
        password= networkOps.getData();

        if(databaseOps.authorize(username,password)){
            this.navigateMenu();
        }
        else{
            freeze(800);
            System.out.println("Kullanıcı Doğrulanamadı..");
        }
    }
    private void navigateMenu(){
        String inpt;
        inpt=this.process();
        switch (inpt) {
            case "1" -> {
                networkOps.startCooler();
                freeze(1200);
            }
            case "2" -> {
                networkOps.shutdownCooler();
                freeze(1200);
            }
            case "3" -> {
                networkOps.sendThermometerData();
                freeze(1200);
            }
            case "4" -> {
                System.out.println("Çıkış yapılıyor!");
                freeze(1200);
                Runtime.getRuntime().exit(0);
            }
            default -> System.out.println("Yanlıs deger girdiniz tekrar deneyin!");
        }
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nBaska islem yapacak misiniz? (e/h)\n");
        char userChoice = userInput.next().charAt(0);
        userChoice = Character.toLowerCase(userChoice);
        if (userChoice == 'e') {
            freeze(300);
            navigateMenu();
        }
        else if (userChoice == 'h') {
            System.out.println("Cikis yapiliyor...");
            Runtime.getRuntime().exit(0);
        }
        else
            System.out.println("Yanlıs deger girdiniz tekrar deneyin!");
    }
    private String process(){
        networkOps.message("------------------------");
        networkOps.message("1. Sogutucuyu Ac");
        networkOps.message("2. Sogutucuyu Kapat");
        networkOps.message("3. Sicakligi Goruntule");
        networkOps.message("4. Cikis Yap");
        networkOps.message("------------------------");
        return networkOps.getInput();
    }
}
