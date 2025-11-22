package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminAllMemberDTO;
import com.app.bluecotton.domain.vo.member.MemberSocialVO;
import com.app.bluecotton.domain.vo.member.MemberVO;
import com.app.bluecotton.repository.AdminMemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {

    private final AdminMemberDAO  adminMemberDAO;

    @Override
    public List<AdminAllMemberDTO> selectAllMember() {
        return adminMemberDAO.selectAllMember();
    }

    @Override
    public List<AdminAllMemberDTO> selectSocialMember(MemberSocialVO memberSocialVO) {
        return adminMemberDAO.selectSocialMember(memberSocialVO);
    }

    @Override
    public List<MemberVO> selectCandyByMember(Integer memberCandy) {
        return adminMemberDAO.selectCandyMember(memberCandy);
    }

    @Override
    public List<MemberVO> selectRankByMember(String memberRank) {
        return adminMemberDAO.selectRankMember(memberRank);
    }

    @Override
    public Optional<AdminAllMemberDTO> selectMemberByMemberId(Long id) {
        return adminMemberDAO.selectByMemberId(id);
    }
}
