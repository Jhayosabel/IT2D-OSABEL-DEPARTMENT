package it2d.osabel.midterm;

import java.util.Scanner;

public class IT2DOSABELMIDTERM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
        IT2DOSABELMIDTERM department = new IT2DOSABELMIDTERM();

        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            
            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    department.addDepartment();
                    break;
                case 2:
                    department.viewDepartment();
                    break;
                case 3:
                    department.updateDepartment();
                    break;
                case 4:
                    department.deleteDepartment();
                    break;
                case 5:
                    System.out.println("Thank You, See you soonest!");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));
        
        System.out.println("Thank You, See you soonest!");
    }

    public void addDepartment() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Department id: ");
        String wdate = sc.next();
        System.out.print("Department name: ");
        String wtype = sc.next();
        System.out.print("Department head: ");
        String dura = sc.next();
        System.out.print("Location: ");
        String location = sc.next();
        System.out.print("Phone number: ");
        String phoneNumber = sc.next();
        System.out.print("Email: ");
        String email = sc.next();

        String sql = "INSERT INTO tbl_department (Department_id, department_name, Department_head, location, phonenumber, email) VALUES (?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, wdate, wtype, dura, location, phoneNumber, email);
    }

    private void viewCustomer() {
        config conf = new config();
        String query = "SELECT * FROM tbl_Customer";
        String[] headers = {"Department_ID", "department_name", "department_head", "location", "phonenumber", "email"};
        String[] columns = {"D_id", "department_name", "department_head", "location", "phonenumber", "email"};
        
        conf.viewRecords(query, headers, columns);
    }

    private void updateDepartment() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();

        System.out.print("New Department ID: ");
        String nwdate = sc.next();
        System.out.print("New Department Name: ");
        String nwtype = sc.next();
        System.out.print("New Department head: ");
        String ndura = sc.next();
        System.out.print("New location: ");
        String nloc = sc.next();
        System.out.print("New phone number: ");
        String nphone = sc.next();
        System.out.print("New email: ");
        String nemail = sc.next();

        String qry = "UPDATE tbl_department SET department_id = ?, department_name = ?, department_head = ?, location = ?, phonenumber = ?, email = ? WHERE d_id = ?";
        conf.updateRecord(qry, nwdate, nwtype, ndura, nloc, nphone, nemail, id);
    }

    private void deleteDepartment() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_department WHERE d_id = ?";
        conf.deleteRecord(qry, id);
    }

    private void viewDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

   

