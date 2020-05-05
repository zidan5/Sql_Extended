
interface ICustomerDAO {
       public void update(Integer id);
       public void delete(int id);
       public void MaxPayment();
       public void SortCustomerByColumn(String col);
       public void rangeOfProducts(int start, int end);
}
public class CustomerJdbc {
    private int CustomerID;
    private String Firstname;
    private String Lastname;
    private String Gender;
    private String Address;
    private int Phone;
    private String Email;
    private String City;
    private String Country;

    public void setCustomerID(Integer id) {
        this.CustomerID = id;
    }
    public Integer CustomerID() {
        return CustomerID;
    }
    public void setFirstname(String name) {
        this.Firstname = name;
    }
    public String getFirstname() {
        return Firstname;
    }
    public void setLastname(String name) {
        this.Lastname = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setGender(String gen) {
        this.Gender= gen;
    }
    public String getGender() {
        return Gender;
    }
    public void setAddress(String addrs) {
        this.Address= addrs;
    }
    public String getAddress() {
        return Address;
    }
    public void setPhone(Integer phone) {
        this.Phone = phone;
    }
    public Integer Phone() {
        return Phone;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public String Email() {
        return Email;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }
    public String getCountry() {
        return Country;
    }
    public void setCity(String City) {
        this.City = City;
    }
    public String getCity() {
        return City;
    }
}

public Class CustomerJDBCTemplate implements ICustomerDAO {

    private JdbcTemplate jdbcTemplateObject;

public void update(String name, Strin lastname, int id){
        String SQL = "UPDATE Customers SET FirstName =?, LastName=? WHERE CustomerID =?";
        jdbcTemplateObject.update(SQL, name, lastname,id);
        return;
 }
public void delete(Integer id){
        String SQL = "DELETE FROM public.Customers Where CustomerID=?";
        jdbcTemplateObject.update(SQL,id);
        return;
 }
public void MaxPayment(){
        String SQL = "SELECT MAX(Amount) FROM public.Payments";
        jdbcTemplateObject.update(SQL);
        return;
}
public void SortCustomerByColumn(String col){
        String SQL = "SELECT * FROM Customers ORDER BY ?";
        jdbcTemplateObject.update(SQL ,col);
        return;

 }
 public void rangeOfProducts(int start, int end){
        String SQL = "SELECT * FROM Products WHERE  BuyPrice BETWEEN ? AND ?";
        jdbcTemplateObject.update(SQL ,start,end);
        return;
 }

}
