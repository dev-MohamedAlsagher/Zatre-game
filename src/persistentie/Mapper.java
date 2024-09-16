package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domein.Gebruiker;

public class Mapper {
	private static final String INSERT_SPELER = "INSERT INTO `ID372816_g68`.`Gebruikers` (`id`, `GebruikersNaam`, `geboorteJaar`, `speelkansen`)"
			+ " VALUES(?, ?, ?, ?);";
	private static final String UPDATE_SPELER = "UPDATE ID372816_g68.Gebruikers SET speelkansen = ? WHERE GebruikersNaam = ? and geboorteJaar = ?;";
	String url = "jdbc:mysql://ID372816_g68.db.webhosting.be:3306/?user=ID372816_g68";
	String username = "ID372816_g68";
	String passwd = "schoolproject68";
	private int speelkansen;

	public void setSpeelkansen(int speelkansen) {
		this.speelkansen = speelkansen;
	}

	public int getSpeelkansen() {
		return this.speelkansen;
	}

	public Mapper() {

	}

	public void voegToe(Gebruiker speler) {
		try (Connection conn = DriverManager.getConnection(url, username, passwd);
				PreparedStatement query = conn.prepareStatement(INSERT_SPELER)) {
			query.setInt(1, 0);
			query.setString(2, speler.getGebruikersNaam());
			query.setInt(3, speler.getGeboorteJaar());
			query.setInt(4, speler.setSpeelKansen());
			query.executeUpdate();
			// todo nut code?
			speler = new Gebruiker(speler.getGebruikersNaam(), speler.getGeboorteJaar());
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public int geefSpeelkansen(String gebruikersnaam, int geboortejaar) {
		try (Connection conn = DriverManager.getConnection(url, username, passwd);
				PreparedStatement query = conn.prepareStatement(
						"SELECT speelkansen FROM ID372816_g68.Gebruikers WHERE GebruikersNaam = ? and geboorteJaar = ?;")) {
			query.setString(1, gebruikersnaam);
			query.setInt(2, geboortejaar);

			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				speelkansen = rs.getInt("speelkansen");
				setSpeelkansen(speelkansen);

			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return getSpeelkansen();
	}

	public Gebruiker geefSpeler(String gebruikersnaam, int geboortejaar) {
		Gebruiker speler = null;

		try (Connection conn = DriverManager.getConnection(url, username, passwd);
				PreparedStatement query = conn.prepareStatement(
						"SELECT * FROM ID372816_g68.Gebruikers WHERE GebruikersNaam = ? and geboorteJaar = ?")) {
			query.setString(1, gebruikersnaam);
			query.setInt(2, geboortejaar);
			try (ResultSet rs = query.executeQuery()) {
				if (rs.next()) {
					String gebruikersNaam = rs.getString("GebruikersNaam");
					int geboorteJaar = rs.getInt("geboorteJaar");

					speler = new Gebruiker(gebruikersNaam, geboorteJaar);
				}
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return speler;
	}

	public void slaSpeelkansenOp(String Gebruikersnaam, int geboortejaar) {
		Gebruiker speler = new Gebruiker(Gebruikersnaam, geboortejaar);
		try (Connection conn = DriverManager.getConnection(url, username, passwd);
				PreparedStatement query = conn.prepareStatement(UPDATE_SPELER)) {
			query.setInt(1, speler.updateSpeelKansen(Gebruikersnaam, geboortejaar));
			query.setString(2, Gebruikersnaam);
			query.setInt(3, geboortejaar);
			query.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}
}