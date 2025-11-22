package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminSomCheckDetailDTO;
import com.app.bluecotton.domain.dto.AdminSomCheckResponseDTO;
import com.app.bluecotton.mapper.AdminSomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminSomDAO {

    private final AdminSomMapper adminSomMapper;

    public List<AdminSomCheckResponseDTO> selectConfirmByMember() {
        return  adminSomMapper.selectConfirmByMember();
    }

    public void updateSomCheckIsChecked(Long id) {
         adminSomMapper.updateSomCheckIsChecked(id);
    }

    public void bulkUpdateSomCheckIsChecked(List<Long> somCheckIds) {
        adminSomMapper.bulkUpdateSomCheckIsChecked(somCheckIds);
    }

    public Optional<AdminSomCheckDetailDTO> selectDetailSom(Long id) {
        return  adminSomMapper.selectDetailSom(id);
    }
}
