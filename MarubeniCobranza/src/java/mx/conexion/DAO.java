package mx.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import mx.model.Usuario;

public class DAO {

    Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    private Connection cn;
    private Connection cnSAE;

    public Connection getCn() {
        return this.cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Connection getCnSAE() {
        return this.cnSAE;
    }

    public void setCnSAE(Connection cnSAE) {
        this.cnSAE = cnSAE;
    }

    public void Conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.cn = DriverManager.getConnection("jdbc:sqlserver://10.220.221.158\\SQLEXPRESS;databaseName=gastos", "gastos_usrdb", "k1CruJ@raDix");
            //this.cn = DriverManager.getConnection("jdbc:sqlserver://ASPEL;databaseName=gastos", "gastos", "k1CruJ@raDix");
            //this.cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-557O6CE\\SQLEXPRESS;databaseName=gastos", "sa", "dmsistemas");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void Cerrar() throws SQLException {
        try {
            if ((this.cn != null)
                    && (!this.cn.isClosed())) {
                this.cn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public void ConectarSAE() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.cnSAE = DriverManager.getConnection("jdbc:sqlserver://10.130.22.211\\SQL2014;databaseName=SAE80Empre01", "sa", "aspel$2020");
            //this.cnSAE = DriverManager.getConnection("jdbc:sqlserver://ASPEL;databaseName=SAE70Empre01", "gastos", "k1CruJ@raDix");
            //this.cnSAE = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-557O6CE\\SQLEXPRESS;databaseName=SAE70Empre01", "sa", "dmsistemas");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void CerrarSAE() throws SQLException {
        try {
            if ((this.cnSAE != null)
                    && (!this.cnSAE.isClosed())) {
                this.cnSAE.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
