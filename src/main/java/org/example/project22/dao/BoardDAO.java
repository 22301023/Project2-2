package org.example.project22.dao;

import org.example.project22.bean.BoardVO;
import org.example.project22.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into BOARD (firstname, lastname, age, gender, occupation) values (?, ?, ?, ?, ?)";
    private final String BOARD_LIST = "select * from BOARD order by id";
    private final String BOARD_DELETE = "delete from BOARD where id = ?";

    public int deleteByID(int id) {
        conn = JDBCUtil.getConnection();
        int retval = 0;

        try{
            pstmt = conn.prepareStatement(BOARD_DELETE);
            pstmt.setInt(1, id);
            retval = pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return retval;
    }

    public List<BoardVO> getBoardList(){
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_LIST);
            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardVO board = new BoardVO();
                board.setId(rs.getInt("id"));
                board.setFirstname(rs.getString("firstname"));
                board.setLastname(rs.getString("lastname"));
                board.setAge(rs.getInt("age"));
                board.setGender(rs.getString("gender"));
                board.setOccupation(rs.getString("occupation"));
                board.setRegdate(rs.getDate("regdate"));
                boardList.add(board);
            }
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return boardList;
    }


    public int insertBoard(BoardVO vo){
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try{
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_INSERT);
            pstmt.setString(1, vo.getFirstname());
            pstmt.setString(2, vo.getLastname());
            pstmt.setInt(3, vo.getAge());
            pstmt.setString(4, vo.getGender());
            pstmt.setString(5, vo.getOccupation());
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        BoardVO vo = new BoardVO("Sangsook", "Won", 55, "femal", "housewife");
//        BoardDAO dao = new BoardDAO();
//        int result = dao.insertBoard(vo);
//        if(result == 1){
//            System.out.println("데이터 추가 완료");
//        }
//    }
}