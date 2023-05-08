package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private JdbcConnectionUtil util;

	public MemberDao() {
		util = JdbcConnectionUtil.getInstance();
	}

	// C
	public int insertMember(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = util.getConncetion();
			System.out.println("접속 성공!");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO SCOTT.MEMBER ");
			query.append("VALUES (MEMBER_SEQ.nextval, ?, ?, ?, sysdate)");

			System.out.println(query.toString());

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getNickname());

			result = pstmt.executeUpdate();

			System.out.println(result + "행이 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// R
	public MemberVo selectMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo result = null;
		
		try {
			conn = util.getConncetion();
			System.out.println("접속 성공!");
			pstmt = conn.prepareStatement("select * from \"MEMBER\" where \"NUM\"=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new MemberVo(
						rs.getInt("NUM"),
						rs.getString("MEMBERID"),
						rs.getString(3),
						rs.getString(4));
				result.setRegdate(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public List<MemberVo> selectMemberALL() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> result = new ArrayList<>();
		
		try {
			conn = util.getConncetion();
			System.out.println("접속 성공!");
			pstmt = conn.prepareStatement("select * from \"MEMBER\"");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString("MEMBERPW"),
						rs.getString(4)
				);
				vo.setRegdate(rs.getDate("REGDATE"));

				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// U
	public int updateMember(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = util.getConncetion();
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("update \"MEMBER\" ");
			query.append("set \"MEMBERPW\"=?, \"NICKNAME\"=? ");
			query.append("where \"NUM\"=?");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getMemberPw());
			pstmt.setString(2, vo.getNickname());
			pstmt.setInt(3, vo.getNum());
			
			result = pstmt.executeUpdate();

			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// D
	public int deleteMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = util.getConncetion();
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("delete from \"MEMBER\" ");
			query.append("where \"NUM\"=?");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();

			System.out.println(result + "행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
