//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class JdbcMemberRepository {
//    // Datasource: Jdbc와 DB를 연동하는 드라이버
//
//    private final DataSource dataSource;
//
//    @Autowired
//    public JdbcMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void save(Member member) throws SQLException {
//        String sql = "insert into member(name) values(?)";
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        // 드라이버를 통해 DB정보를 가져와 connection을 맺는다.
//        connection = dataSource.getConnection();
//        // key를 꺼내어서 preparedStatment에 담고 있게 하는 것
//        preparedStatement = connection.prepareStatement(sql);
//        // jdbc를 통해서 쿼리를 수행하면 그 결과 객체는 ResultSet 객체이다
//        preparedStatement.setString(1, member.getName());
//        // excuteQuery는 조회 시, excuteUpdate는 insert 또는 update
//        preparedStatement.executeUpdate();
//    }
//
//    public List<Member> findAll() throws SQLException {
//        String sql = "select * from member";
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        // 드라이버를 통해 DB정보를 가져와 connection을 맺는다.
//        connection = dataSource.getConnection();
//        // key를 꺼내어서 preparedStatment에 담고 있게 하는 것
//        preparedStatement = connection.prepareStatement(sql);
//        // jdbc를 통해서 쿼리를 수행하면 그 결과 객체는 ResultSet 객체이다
//        resultSet = preparedStatement.executeQuery();
//        List<Member> lst = new ArrayList<>();
//        while(resultSet.next()){  // 값이 있으면 하나씩 소모, 없으면 false
//            Member member = new Member();
//            member.setId(resultSet.getLong("id"));
//            member.setName(resultSet.getString("name"));
//            lst.add(member);
//        }
//
//        return lst;
//    }
//
//    public Member findById(Long id) throws SQLException {
//
//        String sql = "select * from member where id = ?"; //?는 일단 비운다는 의미
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        // 드라이버를 통해 DB정보를 가져와 connection을 맺는다.
//        connection = dataSource.getConnection();
//        // key를 꺼내어서 preparedStatment에 담고 있게 하는 것
//        preparedStatement = connection.prepareStatement(sql);
//        // jdbc를 통해서 쿼리를 수행하면 그 결과 객체는 ResultSet 객체이다
//        preparedStatement.setLong(1, id);
//        resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()){
//            Member member = new Member();
//            member.setId(resultSet.getLong("id"));
//            member.setName(resultSet.getString("name"));
//            return member;
//        }
//
//        return null;
//    }
//
//    public List<Member> findByName(String name){
//
//        return null;
//    }
//}
