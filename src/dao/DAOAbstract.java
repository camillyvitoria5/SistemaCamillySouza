/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1

/**
 *
 * @author amand
 */
public abstract class DAOAbstract {
<<<<<<< HEAD

    public Session session;

    public DAOAbstract() {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public abstract void insert(Object objeto);

    public abstract void update(Object objeto);

    public abstract void delete(Object objeto);

    public abstract Object list(int codigo);

    public abstract List listAll();
=======
        protected Connection cnt;
     public DAOAbstract() {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, pass;
            //url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            //user = "marcos_vilhanueva";
            //pass = "marcos_vilhanueva";
            //url = "jdbc:mysql://10.7.0.51:33062/db_camilly_souza";
            //user = "camilly_souza";
            //pass = "camilly_souza";
            url = "jdbc:mysql://127.0.0.1/db_camilly_souza";
            user = "root";
            pass = "";
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id    );
    public abstract Object listAll();
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1
}
