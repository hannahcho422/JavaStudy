package com.example.demo_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// JDBC 사용해 데이터베이스 테이블 조회
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 프로젝트에 포함된 JDBC 드라이버 로딩
        // 파라미터: java.sqlq.Driver 인터페이스가 구현된 클래스 객체 이름 전달
        Class.forName("com.mysql.cj.jdbc.Driver"); 

        // 데이터베이스에 연결
        // 파라미터: 데이터베이스 url, 계정 정보
        try (
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8",
                "myuser",
                "Mypassw0rd!"
            );
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM members");
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            // 조회된 멤버 수만큼 반복문 통해 하나씩 컬럼 이름 사용해 컬럼 데이터 가져오기
            while (resultSet.next()) {
                var user = new Members(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age")
                );
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
