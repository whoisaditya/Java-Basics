public class house {
    static String street_name;
    static String address;
    static int no = 7;
    {
        no = 8;
        street_name = "School Back Side";
        address = "Vellore " + "63200";
    }
    house()
    {
        street_name = "School Back Side";
        System.out.println(no);
    }

    class room
    {
        int room_no = no + 1;
        String street_name = "Back Side";
        room ()
        {
            System.out.println(address);
            System.out.println(street_name);
        }
        int show()
        {
            System.out.println("House no: " + no);
            System.out.println(street_name);
            System.out.println("Room no: " + room_no);
            return 0;
        }

    }
    static class hall 
    {
        String address = "updated address is " + house.address;
    }

    public static void main(String[] args) {
        house obj = new house();
        house.room r_obj = obj.new room();
        r_obj.show();
        house.hall h_obj = new house.hall();
        System.out.println(h_obj.address);
    }
}
