package com.app.bluecotton.api.publicapi;


import com.app.bluecotton.domain.dto.AdminAllMemberDTO;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.vo.member.MemberSocialVO;
import com.app.bluecotton.domain.vo.member.MemberVO;
import com.app.bluecotton.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/members/*")
public class AdminMemberApi {

    private final AdminMemberService adminMemberService;

    @GetMapping("all")
    public ResponseEntity<ApiResponseDTO<List<AdminAllMemberDTO>>> selectAllMembers() {
        List<AdminAllMemberDTO> allMemberList = adminMemberService.selectAllMember();
        ApiResponseDTO<List<AdminAllMemberDTO>> apiResponseDTO = new ApiResponseDTO<>("전체 사용자 조회 성공", allMemberList);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("social")
    public ResponseEntity<ApiResponseDTO<List<AdminAllMemberDTO>>> selectSocialMember(MemberSocialVO memberSocialVO) {
        List<AdminAllMemberDTO> socialMemberList = adminMemberService.selectSocialMember(memberSocialVO);
        ApiResponseDTO<List<AdminAllMemberDTO>> apiResponseDTO = new ApiResponseDTO<>("소셜 로그인 사용자 조회 성공", socialMemberList);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("rank")
    public ResponseEntity<ApiResponseDTO<List<MemberVO>>> selectRankByMember(String memberRank) {
        List<MemberVO> rankMember = adminMemberService.selectRankByMember(memberRank);
        ApiResponseDTO<List<MemberVO>> apiResponseDTO = new ApiResponseDTO<>("랭크 조회 성공",   rankMember);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("candy")
    public ResponseEntity<ApiResponseDTO<List<MemberVO>>> selectCandyByMember(Integer memberCandy) {
        List<MemberVO> candyMember = adminMemberService.selectCandyByMember(memberCandy);
        ApiResponseDTO<List<MemberVO>> apiResponseDTO = new ApiResponseDTO<>("캔디 조회 성공",  candyMember);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("single")
    public ResponseEntity<ApiResponseDTO<Optional<AdminAllMemberDTO>>> selectMemberByMemberId(@RequestParam Long id) {
        Optional<AdminAllMemberDTO> singleMember = adminMemberService.selectMemberByMemberId(id);
        ApiResponseDTO<Optional<AdminAllMemberDTO>> apiResponseDTO = new ApiResponseDTO<>("유저 정보 조회 성공",  singleMember);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }
}
