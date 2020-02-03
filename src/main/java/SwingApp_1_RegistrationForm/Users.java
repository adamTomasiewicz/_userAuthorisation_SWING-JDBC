package g_gui.SwingApp_1_RegistrationForm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Users {

    static int idCounter;
    static List<Users> listUsers = new LinkedList<>();

    private int id;
    private String login;
    private String password;
    private Sex sex;
    private List<String> listInterests;

  static  {
      importUsers_fromTXT();
      /*  new Users("JanKowalski", "janeczek5", Sex.MAN, Arrays.asList("fishing","cooking","drinking"));
        new Users("JagodaWscibska", "jagodka5", Sex.WOMAN, Arrays.asList("fishing","cooking","drinking"));
        new Users("JanMariaRokita", "kroljesttylko1", Sex.MAN, Arrays.asList("fishing","cooking","drinking"));
        new Users("JurekOgorek", "party69", Sex.OTHER, Arrays.asList("fishing","cooking","drinking"));
*/
    }
        enum Sex {
        MAN("Man"), WOMAN("Woman"), OTHER("Other");
        private String string;
        Sex(String string) {
            this.string = string;
        }
    }

    public Users(String login, String password, Sex sex, List<String> listInterests) {
        this.id = idCounter++;
        this.login = login;
        this.password = password;
        this.sex = sex;
        this.listInterests = listInterests;
        listUsers.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<String> getListInterests() {
        return listInterests;
    }

    public void setListInterests(List<String> listInterests) {
        this.listInterests = listInterests;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Users.idCounter = idCounter;
    }

    public static List<Users> getListUsers() {
        return listUsers;
    }

    public static void setListUsers(List<Users> listUsers) {
        Users.listUsers = listUsers;
    }

    @Override
    public String toString() {
        return
                //"id=" + id + " | "+
                "login=<" + login + "> ,, "+
                "password=<" + password + "> ,, "+
                "sex=<" + sex + "> ,, "+
                "listInterests=" + listInterests;
    }
    static void manageDuplicates () {
        String path1 = "D:\\OneDrive - AT\\_dev\\_java101\\src\\main\\java\\g_gui\\SwingApp_1_RegistrationForm\\listUsers.txt";
        File file1 = new File(path1);
        Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(file1);
        } catch (FileNotFoundException e) {e.printStackTrace();
        }
        // usuwanie duplikatow
        List<Users> listUsersToRemove = new ArrayList<>();
        while (scanner1.hasNextLine()) {
            String string=scanner1.nextLine();
            String substringId = string.substring(string.indexOf('<') + 1, string.indexOf('>'));
            System.out.println(substringId);
            Integer id = Integer.parseInt(substringId);
            for (Users user: listUsers)
                if (user.getId()==id) listUsersToRemove.add(user);
        }
        for (Users user: listUsersToRemove) {
            listUsers.remove(user);
        }
        scanner1.close();
    }
    static void importUsers_fromTXT() {
        String path1 = "D:\\tempp\\listUsers.txt";

        File file1 = new File(path1);
        Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(file1);
        } catch (FileNotFoundException e) {e.printStackTrace();
        }
       // manageDuplicates();
        // dodawanie z pliku
        while (scanner1.hasNextLine()) {
            String string=scanner1.nextLine();
            String[] stringArray1 = string.split(" ,, ");

            String substringLogin = stringArray1[0].substring(stringArray1[0].indexOf('<') + 1, stringArray1[0].indexOf('>'));
            String substringPassword = stringArray1[1].substring(stringArray1[1].indexOf('<') + 1, stringArray1[1].indexOf('>'));
            String substringSex = stringArray1[2].substring(stringArray1[2].indexOf('<') + 1, stringArray1[2].indexOf('>'));
            String substringInterests = stringArray1[3].substring(stringArray1[3].indexOf('[') + 1, stringArray1[3].indexOf(']'));

            Users user = new Users(substringLogin,substringPassword,Sex.valueOf(substringSex), Arrays.asList(""));
            String[] stringArray2 = substringInterests.split(", ");
            List<String> listInterests = new LinkedList<>();
            for (int i = 0; i <stringArray2.length ; i++) {
                listInterests.add(stringArray2[i]);
            }
            user.setListInterests(listInterests);
        }
        scanner1.close();
    }

    static void exportUsers_toTXT() throws IOException {
        String path1 = "D:\\tempp\\listUsers.txt";

        File file1 = new File(path1);
        file1.createNewFile();
        PrintWriter printWriter1 = new PrintWriter(file1);
        // Iterator<Pracownik> iterator = listaWszystkichPracownikow.iterator();
        ListIterator<Users> listIteratorUsers = listUsers.listIterator();
        while(listIteratorUsers.hasNext()) {
            printWriter1.println(listIteratorUsers.next());
            printWriter1.flush();
        }
        printWriter1.close();
    }


}
