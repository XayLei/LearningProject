package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * 和message相关的数据库操作
 *
 */
public class MessageDao {
	/**
	 * mybatis方法
	 * 根据查询条件查询列表
	 */
	public List<Message> queryMessageList(String command, String description){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//参数传递，将页面中输入的查询参数输入到sql语句中，因为下面的selectList中只能带有一个参数，则将传入的参数放入
			//新创建的message对象中，这样就实现了一次传入两个参数到MySQL语句中
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			//通过sqlSession执行SQL语句
			//Message是sql配置文件中mapper的namespace，queryMessageList是单个SQL语句的ID
            // messageList = sqlSession.selectList("Message.queryMessageList",message); //只能传入一个参数
			
			//通過接口编程的替代方法
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){	
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 实现数据库单条记录的删除，在xml文件中配置完成后，这里实现一个删除方法
	 */
	public void deleteOne(Integer id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();//增删改与查询不同，会改变数据库，所以在执行完SQL语句后需要手动提交
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){	
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 实现批量记录的删除，在xml文件中配置完成后，这里实现一个删除方法
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();//增删改与查询不同，会改变数据库，所以在执行完SQL语句后需要手动提交
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){	
				sqlSession.close();
			}
		}
	}
	
	/**
	 * jdbc方法
	 * 根据查询条件查询列表
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micromessage", "root",
//					"ni,hao,ya.");
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT FROM MESSAGE where 1=1");
//			/**
//			 * 查询操作匹配
//			 */
//			List<String> paramList = new ArrayList<>();
//			if (command != null && !"".equals(command.trim())) {
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if (description != null && !"".equals(description.trim())) {
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//
//			for (int i = 0; i < paramList.size(); i++) {
//				statement.setString(i + 1, paramList.get(i));
//			}
//
//			ResultSet rs = statement.executeQuery();
//			
//			while (rs.next()) {
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
