package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminAllMemberDTO;
import com.app.bluecotton.domain.vo.member.MemberSocialVO;
import com.app.bluecotton.domain.vo.member.MemberVO;
import com.app.bluecotton.mapper.AdminMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminMemberDAO {

    private final AdminMemberMapper adminMemberMapper;

    public List<AdminAllMemberDTO> selectAllMember() {
        return adminMemberMapper.selectAllMember();
    }

    public List<AdminAllMemberDTO> selectSocialMember(MemberSocialVO memberSocialVO) {
        return adminMemberMapper.selectSocialLoginMember();
    }

    public List<MemberVO> selectRankMember(String memberRank) {
        return adminMemberMapper.selectRankByMember(memberRank);
    }

    public List<MemberVO> selectCandyMember(Integer memberCandy) {
        return adminMemberMapper.selectCandyByMember(memberCandy);
    }

    public Optional<AdminAllMemberDTO> selectByMemberId(Long id) {
        return adminMemberMapper.selectMemberByMemberId(id);
    }
}
