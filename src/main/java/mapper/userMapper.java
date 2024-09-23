package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.newsModel;
import model.roleModel;
import model.userModel;

public class userMapper implements rowMapper<userModel> {

	@Override
	public userModel mapRow(ResultSet rs) {
		

		try {
			userModel users = new userModel();
			users.setId(rs.getLong("id"));
			users.setUserName(rs.getString("username"));
			users.setPassword(rs.getString("password"));
			users.setFullName(rs.getString("fullname"));
			users.setStatus(rs.getInt("status"));
			try {
				roleModel role = new roleModel();
				role.setCodeRole(rs.getString("coderole"));
				role.setNameRole(rs.getString("namerole"));

				users.setRole(role);
			}catch (SQLException e){
				System.out.printf(e.getMessage());
			}
//			users.setRole_Id(rs.getLong("role_id"));
//			users.setCreateAt(rs.getTimestamp("create_at"));
//			users.setCreateBy(rs.getString("createby"));
//			if(rs.getTimestamp("modifile_at") != null) {
//				users.setModifileAt(rs.getTimestamp("modifile_at"));
//			}
//			if(rs.getTimestamp("modifileby") != null) {
//				users.setModifileBy(rs.getString("modifileby"));
//			}
			return users;
		} catch (SQLException e) {
			return null;
		}
	}

}
