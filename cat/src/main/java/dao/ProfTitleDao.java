//201802104065闫天意
package dao;

import domain.ProfTitle;
import helper.JdbcHelper;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

public final class ProfTitleDao {
	//创建私有的静态的ProfTitleDao对象
	private static ProfTitleDao profTitleDao = new ProfTitleDao();
	//创建私有的静态的集合profTitles
	private static Collection<ProfTitle> profTitles = new HashSet<ProfTitle>();
	//定义私有的构造器
	private ProfTitleDao(){}
	//定义getInstance()方法,返回profTitleDao指向对象
	public static ProfTitleDao getInstance(){
		return profTitleDao;
	}
	//定义findAll()方法,返回profTitles集合
	public static Collection<ProfTitle> findAll() throws SQLException{
		profTitles.clear();
		Connection connection = JdbcHelper.getConn();
		//在该连接上创建语句盒子对象
		Statement stmt = connection.createStatement();
		//执行SQL查询语句并获得结果集对象
		ResultSet resultSet = stmt.executeQuery("select * from ProfTitle");
		while (resultSet.next()){
			ProfTitle profTitle = new ProfTitle(resultSet.getInt("id"),resultSet.getString("description"),resultSet.getString("no"),resultSet.getString("remarks"));
			profTitles.add(profTitle);
		}
		return profTitles;
	}
	//定义find()方法
	public ProfTitle find(Integer id) throws SQLException{
		Connection connection = JdbcHelper.getConn();
		String updateProfTitle_sql = "SELECT * FROM ProfTitle where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(updateProfTitle_sql);
		pstmt.setInt(1,id);
		ResultSet resultSet = pstmt.executeQuery();
		ProfTitle profTitle = null;
		if (resultSet.next()) {
			profTitle = new ProfTitle(resultSet.getInt("id"), resultSet.getString("description"), resultSet.getString("no"), resultSet.getString("remarks"));
		}
		JdbcHelper.close(pstmt,connection);
		return profTitle;
	}
	//通过向集合中添加profTitle，实现添加功能
	public boolean add(ProfTitle profTitle) throws SQLException {
		Connection connection = JdbcHelper.getConn();
		//创建sql语句
		String addProfTitle_sql="Insert into ProfTitle (no,description,remarks) values (?,?,?)";
		//在该连接上创建预编译语句对象
		PreparedStatement pstmt =connection.prepareStatement(addProfTitle_sql);
		//为预编译参数赋值
		pstmt.setString(1, profTitle.getNo());
		pstmt.setString(2, profTitle.getDescription());
		pstmt.setString(3, profTitle.getRemarks());
		profTitles.add(profTitle);
		//执行预编译对象的excuteUpdate方法，获取添加的记录行数
		int affectedRowNum=pstmt.executeUpdate();
		//显示添加的记录的行数
		System.out.println("添加了"+affectedRowNum+"条记录");
		JdbcHelper.close(pstmt,connection);
		return affectedRowNum > 0;
	}
	//定义delete()方法
	public boolean delete(ProfTitle profTitle) throws SQLException{
		Connection connection = JdbcHelper.getConn();
		//创建sql语句
		String deleteProfTitle_sql="Delete from ProfTitle where id=? ";
		//在该连接上创建预编译语句对象
		PreparedStatement pstmt =connection.prepareStatement(deleteProfTitle_sql);
		//为预编译参数赋值
		pstmt.setInt(1,profTitle.getId());
		//执行预编译对象的excuteUpdate方法
		int affectedRowNum=pstmt.executeUpdate();
		//显示删除的记录的行数
		System.out.println("删除了"+affectedRowNum+"条记录");
		JdbcHelper.close(pstmt,connection);
		return true ;
	}
	public boolean update(ProfTitle profTitle) throws ClassNotFoundException,SQLException{
		Connection connection = JdbcHelper.getConn();
		//写sql语句
		String updateProfTitle_sql = " update profTitle set description=?,no=?,remarks=? where id=?";
		//在该连接上创建预编译语句对象
		PreparedStatement preparedStatement = connection.prepareStatement(updateProfTitle_sql);
		//为预编译参数赋值
		preparedStatement.setString(1,profTitle.getDescription());
		preparedStatement.setString(2,profTitle.getNo());
		preparedStatement.setString(3,profTitle.getRemarks());
		preparedStatement.setInt(4,profTitle.getId());
		//执行预编译语句，获取改变记录行数并赋值给affectedRowNum
		int affectedRows = preparedStatement.executeUpdate();
		System.out.println("更新了" + affectedRows + "条记录");
		//关闭资源		
		JdbcHelper.close(preparedStatement,connection);
		return affectedRows>0;
	}
}

