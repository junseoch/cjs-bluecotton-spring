package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminAllMemberDTO;
import com.app.bluecotton.domain.vo.member.MemberSocialVO;
import com.app.bluecotton.domain.vo.member.MemberVO;

import java.util.List;
import java.util.Optional;

public interface AdminMemberService {
    public List<AdminAllMemberDTO> selectAllMember();

    public List<AdminAllMemberDTO> selectSocialMember(MemberSocialVO memberSocialVO);

    public List<MemberVO> selectCandyByMember(Integer memberCandy);

    public List<MemberVO> selectRankByMember(String memberRank);

    public Optional<AdminAllMemberDTO> selectMemberByMemberId(Long id);
}
