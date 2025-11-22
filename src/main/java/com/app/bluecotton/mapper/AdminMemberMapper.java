package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminAllMemberDTO;
import com.app.bluecotton.domain.vo.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMemberMapper {

    public List<AdminAllMemberDTO> selectAllMember();

    public List<AdminAllMemberDTO> selectSocialLoginMember();

    public List<MemberVO> selectRankByMember(String memberRank);

    public List<MemberVO> selectCandyByMember(Integer memberCandy);

    public Optional<AdminAllMemberDTO> selectMemberByMemberId(Long id);
}
