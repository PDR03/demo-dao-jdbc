import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.implDAO.CidadeImpl;
import dao.implDAO.Estadoimpl;
import model.Estados;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scr = new Scanner(System.in);

        try {
            Connection conn = MySQLConnection.getConnection();

            if (conn != null) {
                System.out.println("Conexão feita com sucesso!");

                Estadoimpl estadoDAO = new Estadoimpl(conn);
                List<Estados> estados = estadoDAO.ListEstados();

                for (Estados estado : estados) {
                    System.out.println(estado.toString()); 
                }

                System.out.println("Selecione o estado que deseja deletar:");
                int estadoDel = scr.nextInt();

                 CidadeImpl cidadeDAO = new CidadeImpl(conn);
                 cidadeDAO.deleteByEstadoId(estadoDel);
                estadoDAO.DeleteById(estadoDel);
                
                System.out.println("Estado e suas cidades foram deletados com sucesso.");
            }

        } catch (SQLException e) {
            System.out.println("Erro!! Não conectamos ao banco de dados. Error:" + e.getMessage());
        }
    }
}
