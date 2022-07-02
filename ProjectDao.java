package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projects.entity.Project;
import projects.exception.DbException;

public class ProjectDao extends DaoBase {

	private static final String Category_Table = "category";
	private static final String material_table = "material";
	private static final String project_table = "project";
	private static final String project_category_table = "project_category";
	private static final String step_table = "step";
	
	
	public Project insertProject(Project project) {
		
		String sql = ""
				+ "INSERT INTO " + project_table + " "
				+ "(project_name, estimated_hours, actual_hours, difficulty, notes"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?,)";
		
		try(Connection conn = DbConnection.getConnection()){
			startTransaction(conn);
			
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				setParameter(stmt, 1, project.getProjectName(), String.class);
				setParameter(stmt, 2, project.getEstimatedHours(),BigDecimal.class);
				setParameter(stmt, 3,project.getActualHours(),BigDecimal.class);
				setParameter(stmt, 4, project.getDifficulty(), Integer.class);
				setParameter(stmt, 5, project.getNotes(), String.class);
				
				stmt.executeUpdate();
				
				Integer projectId = getLastInsertId(conn, project_table);
				commitTransaction(conn);
				
				project.setProjectId(projectId);
				return project;
				
			}
			catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
				
			}
		}
		catch(SQLException e) {
			throw new DbException(e);
		}
	
}


	private void rollbackTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}


	private void startTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}


	private void commitTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}


	private Integer getLastInsertId(Connection conn, String projectTable) {
		// TODO Auto-generated method stub
		return null;
	}


	private void setParameter(PreparedStatement stmt, int i, BigDecimal actualHours, Class<BigDecimal> class1) {
		// TODO Auto-generated method stub
		
	}


	private void setParameter(PreparedStatement stmt, int i, Integer difficulty, Class<Integer> class1) {
		// TODO Auto-generated method stub
		
	}


	private void setParameter(PreparedStatement stmt, int i, String notes, Class<String> class1) {
		// TODO Auto-generated method stub
	}	
	
}