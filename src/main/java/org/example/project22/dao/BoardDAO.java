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
    //private final String BOARD_LIST = "select * from BOARD";
    private final String BOARD_DELETE = "delete from BOARD where id = ?";
    //private final String BOARD_SEARCH = "select * from BOARD where ? like %?%";

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
        return getBoardList(null, null);
    }

    public List<BoardVO> getBoardList(String key, String keyword){
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        System.out.println("===> JDBC로 getBoardList(search) 기능 처리");

        // 기본 쿼리
        String sql = "select * from BOARD";

        // 검색 조건 유효성 검사 플래그
        boolean isSearch = false;

        // key값이 유효한 컬럼명인지 확인 (SQL Injection 방지용 화이트리스트 체크)
        if(key != null && !key.isEmpty() && keyword != null && !keyword.isEmpty()){
            if("lastname".equals(key) || "gender".equals(key) || "occupation".equals(key)) {
                // 컬럼명은 ?로 바인딩 불가능하므로 문자열 결합 사용 (안전함)
                sql += " WHERE " + key + " LIKE ?";
                isSearch = true;
            }
        }

        sql += " order by id desc"; // 최신순 정렬

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);

            // 검색 조건이 유효할 때만 ?에 값을 설정
            if(isSearch) {
                // LIKE 검색을 위해 앞뒤에 % 추가
                pstmt.setString(1, "%" + keyword + "%");
            }

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
            e.printStackTrace();
        }
        return boardList;
    }

//    public List<BoardVO> getBoardList(String key, String keyword){
//        List<BoardVO> boardList = new ArrayList<BoardVO>();
//        System.out.println("===> JDBC로 getBoardList() 기능 처리");
//
//        String sql = "select * from BOARD";
//
//        if(key != null && !key.isEmpty() && keyword != null && !keyword.isEmpty()){
//            // SQL Injection 방지를 위해 key값은 화이트리스트 체크 혹은 고정값 매핑을 권장하나,
//            // 여기서는 간단히 문자열 결합으로 처리하되 유효한 컬럼만 허용하도록 구성
//            if(key.equals("lastname") || key.equals("gender") || key.equals("occupation")) {
//                sql += " WHERE " + key + " LIKE '%" + keyword + "%'";
//            }
//        }
//
//        try {
//            conn = JDBCUtil.getConnection();
//            pstmt = conn.prepareStatement(BOARD_LIST);
//            rs = pstmt.executeQuery();
//            while(rs.next()){
//                BoardVO board = new BoardVO();
//                board.setId(rs.getInt("id"));
//                board.setFirstname(rs.getString("firstname"));
//                board.setLastname(rs.getString("lastname"));
//                board.setAge(rs.getInt("age"));
//                board.setGender(rs.getString("gender"));
//                board.setOccupation(rs.getString("occupation"));
//                board.setRegdate(rs.getDate("regdate"));
//                boardList.add(board);
//            }
//            rs.close();
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        return boardList;
//    }


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