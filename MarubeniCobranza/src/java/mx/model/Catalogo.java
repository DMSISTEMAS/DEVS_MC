 package mx.model;
 
 import java.io.Serializable;
 
 public class Catalogo implements Serializable {
   private int id;
   private String subcuenta;
   private String cliente;
   
   public Catalogo() {}
   
   public Catalogo(int id) {
     this.id = id;
   }
   
   public Catalogo(int id, String subcuenta, String cliente) {
     this.id = id;
     this.subcuenta = subcuenta;
     this.cliente = cliente;
   }
   
   public int getId() {
     return this.id;
   }
   
   public void setId(int id) {
     this.id = id;
   }
   
   public String getSubcuenta() {
     return this.subcuenta;
   }
   
   public void setSubcuenta(String subcuenta) {
     this.subcuenta = subcuenta;
   }
   
   public String getCliente() {
     return this.cliente;
   }
   
   public void setCliente(String cliente) {
     this.cliente = cliente;
    }
}
