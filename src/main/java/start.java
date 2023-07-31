import static com.javaba.mixologyconnect.common.JDBCTemplate.close;
import static com.javaba.mixologyconnect.common.JDBCTemplate.getConnection;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.javaba.mixologyconnect.cocktail.model.vo.Ingredient;
import com.javaba.mixologyconnect.cocktail.model.vo.IngredientType;

public class start extends HttpServlet {

	@Override
	public void init() throws ServletException {

		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM INGREDIENT_TYPE");
			while(rs.next()) {
				int no = rs.getInt("INGR_TYPE");
				IngredientType.maps.put(no + "",
										new IngredientType(no,
														   rs.getString("TYPE_NM"),
														   rs.getString("TYPE_IMG")));
			}
			rs = stmt.executeQuery("SELECT * FROM INGREDIENT");
			while(rs.next()) {
				int no = rs.getInt("INGR_CODE");
				Ingredient.maps.put(no + "",
									new Ingredient(no,
												   rs.getString("INGR_NAME"),
												   IngredientType.maps.get(rs.getInt("INGR_TYPE") + "")));
			}
			close(rs);
			close(stmt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

}
