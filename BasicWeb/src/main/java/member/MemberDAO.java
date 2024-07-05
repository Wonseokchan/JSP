package member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	private SqlSession session;

	private MemberDAO() {
		String resource = "mybatis-config.xml";

		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public List<MemberVO> selectMembers() {
//		List<MemberVO> list = session.selectList("member.MemberMapper.selectMembers");
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		List<MemberVO> list = mapper.selectMembers();
		return list;
	}

	public MemberVO selectMember(long searchId) {
		MemberVO member = session.selectOne("member.MemberMapper.selectMember", searchId);
		return member;
	}

	public int insertMember(MemberVO member) {
		int executeUpdate = session.selectOne("member.MemberVO.insertMember", member);
		return executeUpdate;
	}

	public int updateMember(MemberVO member) {
		int executeUpdate = session.selectOne("member.MemberVO.updateMember", member);
		return executeUpdate;
	}

	public int deleteMember(long deleteid) {
		int executeUpdate = session.selectOne("member.MemberVO.deleteMember", deleteid);
		return executeUpdate;
	}
}
