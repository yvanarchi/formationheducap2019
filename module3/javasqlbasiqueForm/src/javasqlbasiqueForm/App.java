package javasqlbasiqueForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App {

	public static void main(String[] args) {
		
		try {
			// le driver mysql s'enregistre a son chargement aupr�s du driverManager
			Class.forName("com.mysql.jdbc.Driver");
			
			// r�cup�ration de la connection de la base mysql
			Connection base = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/base_java1",
					"root",
					"");
			// dans base, j'ai une mysqlConnection
			// cet objet permet, entre autre de gerer la connection
			// a la base et de r�cup�rer des statement
			// un statement permet de requeter la base
			System.out.println("nous somme connect� � la base!");
			
			
			//Statement query2 = base.createStatement();
			// une requete de modification (insert, update, delete) ne renvoie
			// pas a proprement parler de donn�e, cela renvoie juste une information
			// � savoir le nombre de ligne affect�e
			// ca ne renvoie pas un resultset
			// ce n'est pas la m�me m�thode
		
			Scanner reader = new Scanner(System.in);
			PreparedStatement query4 = base.prepareStatement(
					"DELETE FROM `contact` WHERE `id`=?");
			
			System.out.println("id de l'acteur � effacer ?");
			int id = Integer.parseInt(reader.nextLine());
			query4.setInt(1, id);
			
			int nbrows = query4.executeUpdate();
			System.out.println("nombre de lignes supprim�es: " + nbrows);
			
			
			/*
			PreparedStatement query3 = base.prepareStatement(
					"UPDATE `contact` SET `email`=?, `nom`=? WHERE `id`=?");
			System.out.println("id de l'acteur � modifier ?");
			int id = Integer.parseInt(reader.nextLine());
			System.out.println("nouveau nom ?");
			String nom = reader.nextLine();
			System.out.println("nouvel email ?");
			String email = reader.nextLine();
			
			query3.setString(1, email);
			query3.setString(2,  nom);
			query3.setInt(3, id);
			
			int nbrows = query3.executeUpdate();
			System.out.println("nombre de lignes affect�es: " + nbrows);
			*/
			
			
			/*	
			System.out.println("nom acteur? ");
			String nom = reader.nextLine();
			System.out.println("prenom acteur? ");
			String prenom = reader.nextLine();
			System.out.println("email acteur? ");
			String email = reader.nextLine();
			
			PreparedStatement query2= 
					base.prepareStatement("INSERT INTO `contact` (`nom`, `prenom`, `email`) "
										+ "VALUES(?,?,?)");
			query2.setString(1, nom);
			query2.setString(2, prenom);
			query2.setString(3, email);
			
			int nbrows = query2.executeUpdate();
			System.out.println("nombre de lignes affect�es: " + nbrows);
			*/
			
	/*
			String insertsql =  
						"INSERT INTO `contact` (`nom`, `prenom`, `email`) " + 
						"VALUES ('" + nom +  "', '"+ prenom + "', '" + email + "');";
			System.out.println(insertsql);	
			// c'est execute update pour insert, update ou delete
			int nbrows = query2.executeUpdate(insertsql);
			System.out.println("nombre de lignes affect�es " + nbrows);
		*/	
			
			// requetteur pr�t � l'emploie
			Statement query1 = base.createStatement();
			
			// execution d'une requette
			// comme la requete est : SELECT `id`,`nom`,`prenom`,`email` FROM `contact`
			// c'est un select, cela renvoie des donn�es sous forme tabulaire
			// il nous faut un resultset pour parcourir les r�sultats
			
			ResultSet rs1 = query1.executeQuery(
						"SELECT `id`,`nom`,`prenom`,`email` FROM `contact`"
												);
			// le resultSet est en quelque sorte un curseur sur les donn�es renvoy�es par la
			// requete
			// next positionne le curseur sur la ligne suivante
			while(rs1.next()) {
				System.out.println(rs1.getString("nom"));
			}
			rs1.close();
			
			
			base.close();
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
		
		

	}

}
