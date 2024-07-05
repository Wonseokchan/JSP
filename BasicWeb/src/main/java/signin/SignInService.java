package signin;

import config.MybatisConfig;
import member.MemberVO;

public class SignInService {
	private final SignInMapper mapper;

	public SignInService() {
		mapper = MybatisConfig.session.getMapper(SignInMapper.class);
	}

	public MemberVO findByEmail(SignInVO signin) {
		return mapper.findByEmail(signin);
	}
}
