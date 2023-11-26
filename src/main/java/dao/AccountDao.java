package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Account;

public class AccountDao {

	Connection c = null;

	PreparedStatement ps = null;

	public Account checkSignIn(String user, String pass) {

		c = DbContext.getConnect();

		String query = "select *\r\n" + "  from account\r\n" + "  where username=? and password= ?";

		try {
			ps = c.prepareStatement(query);

			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void insertAccount(Account model) {

		c = DbContext.getConnect();

		String query = "insert into account(username,password,isSell,isAdmin)\r\n" + "   values(?,?,?,?)";

		try {
			ps = c.prepareStatement(query);

			ps.setString(1, model.getUsername());
			ps.setString(2, model.getPassword());
			ps.setInt(3,model.getIsSell());
			ps.setInt(4,model.getIsAdmin());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Account checkUserExist(String user) {

		c = DbContext.getConnect();

		String query = "select *\r\n" + "  from account\r\n" + "  where username=?";

		try {
			ps = c.prepareStatement(query);

			ps.setString(1, user);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void updateAccount(Account account) {

		c = DbContext.getConnect();

		String query = "update account\r\n" + "set password=?,isSell=?,isAdmin=?\r\n" + "where id=?\r\n";

		try {

			ps = c.prepareStatement(query);

			ps.setString(1, account.getPassword());
			ps.setInt(2, account.getIsSell());
			ps.setInt(3, account.getIsAdmin());
			ps.setInt(4, account.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAccount(Account ac) {
		c = DbContext.getConnect();

		String query = "delete from account where id=?";

		try {
			ps = c.prepareStatement(query);

			ps.setInt(1, ac.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Account> finallAccount() {
		c = DbContext.getConnect();

		String query = "select *\r\n" + "  from account\r\n";

		try {
			ps = c.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			List<Account> list = new ArrayList<Account>();

			while (rs.next()) {
				Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				list.add(a);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
