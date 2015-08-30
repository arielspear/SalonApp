import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String client_name;
  private String client_phone;

  public int getId() {
    return id;
  }

  public String getClientName() {
    return client_name;
  }

  public String getClientPhone() {
    return client_phone;
  }

  public Client(String clientName, String clientPhone) {
    this.client_name = clientName;
    this.client_phone = clientPhone;
  }

  public static List<Client> all() {
    String sql = "SELECT id, client_name, client_phone FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }
}
