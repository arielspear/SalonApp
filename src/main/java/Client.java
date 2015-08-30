import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String clientName;
  private String clientPhone;

  public int getId() {
    return id;
  }

  public String getClientName() {
    return clientName;
  }

  public String getClientPhone() {
    return clientPhone;
  }

  public Client(String clientName, String clientPhone) {
    this.clientName = clientName;
    this.clientPhone = clientPhone;
  }

  public static List<Client> all() {
    String sql = "SELECT id, client_name, client_phone FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }
}
