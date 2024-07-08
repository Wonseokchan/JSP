package login;

import common.MyBatisSession;

public class LogInService {
	private LogInMapper mapper;
	private static LogInService instance = new LogInService();

	private LogInService() {
		mapper = MyBatisSession.session.getMapper(LogInMapper.class);
	}

	public static LogInService getInstance() {
		return instance;
	}

	public MemberVO findByEmailAndPassword(LoginVO login) {
		return mapper.findByEmailAndPassword(login);
	}
}
