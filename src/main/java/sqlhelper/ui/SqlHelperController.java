package sqlhelper.ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sqlhelper.com.DbConnection;
import sqlhelper.impl.SqlHelperServiceImpl;


/**
 * @Class Name : SqlHelperController.java
 * @Description : SqlHelper Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2018.12.09           최초생성
 *
 * @author MIN
 * @version 1.0
 * 
 */

@Controller
public class SqlHelperController {

	/** SqlHelperService */
	@Resource(name = "sqlHelperService")
	private SqlHelperServiceImpl sqlHelperService;
	
	/**
	 * sql helper main page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sqlhelper.do")
	public String sqlHelper(ModelMap model) throws Exception {


		return "sqlhelper/sqlhelper";
	}
	
	/**
	 * db connection
	 * @param map
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dbConnection.do")
	public List<Map<String,Object>> dbConnection (Map<String,Object> map, ModelMap model) throws Exception {

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		Connection conn = null; 
		
		try {
			
			String user = (String) map.get("USER");
			String pwd = (String) map.get("PWD");
			String url = (String) map.get("URL");
			
			String sql = "SELECT * FROM tabs";
			
			conn = DbConnection.getConnection(user, pwd, url);

			
		 } finally {
			// DB Connection close
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return result;
	}

}


