package TestPackage;


import org.junit.jupiter.api.Test;

public class C36FileInfo {

    @Test
    public void fileInfoTest(){
        // RETURNS THE CHARACTER THAT SEPARATES FILE PATHS
        System.out.println("1) " + System.getProperty("file.separator"));
        String sep = System.getProperty("file.separator");
        String userHome = sep + "Users" + sep + "suleymankirkil" + sep;

        System.out.println(userHome);

        // SHOWS THE ADDRESS WHERE THE PROJECT IS LOADED AND THE ADDRESSES OF THE LOADED JAR FILES
        System.out.println("2) " + System.getProperty("java.class.path"));

        // INSTALLATION DIRECTORY FOR JAVA RUNTIME ENVIRONMENT (JRE)
        System.out.println("3) " + System.getProperty("java.home"));

        // JRE VENDOR NAME
        System.out.println("4) " + System.getProperty("java.vendor"));

        // JRE VENDOR URL
        System.out.println("5) " + System.getProperty("java.vendor.url"));

        // JRE VERSION NUMBER
        System.out.println("6) " + System.getProperty("java.version"));

        // OPERATING SYSTEM NAME
        System.out.println("7) " + System.getProperty("os.name"));

        // OPERATING SYSTEM VERSION
        System.out.println("8) " + System.getProperty("os.version"));

        // PATH SEPARATOR CHARACTER USED
        System.out.println("9) " + System.getProperty("path.separator"));

        // USER WORKING DIRECTORY - project's content root
        System.out.println("10) " + System.getProperty("user.dir"));

        // USER HOME DIRECTORY - windows user name under C
        System.out.println("11) " + System.getProperty("user.home"));

        // USER ACCOUNT NAME
        System.out.println("12) " + System.getProperty("user.name"));


    }
}
