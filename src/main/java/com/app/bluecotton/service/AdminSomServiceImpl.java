package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminSomCheckDetailDTO;
import com.app.bluecotton.domain.dto.AdminSomCheckResponseDTO;
import com.app.bluecotton.domain.dto.MyPageSomCheckImageDTO;
import com.app.bluecotton.repository.AdminSomDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminSomServiceImpl implements AdminSomService {

    private final AdminSomDAO adminSomDAO;

    @Override
    public List<AdminSomCheckResponseDTO> selectConfirmByMember() {
        return adminSomDAO.selectConfirmByMember();
    }

    @Override
    public void updateSomCheckIsChecked(Long id) {
        adminSomDAO.updateSomCheckIsChecked(id);
    }

    @Override
    public void bulkUpdateSomCheckIsChecked(List<Long> somCheckIds) {
        if (somCheckIds == null || somCheckIds.isEmpty()) return;
        adminSomDAO.bulkUpdateSomCheckIsChecked(somCheckIds);
    }

    @Override
    public Optional<AdminSomCheckDetailDTO> selectDetailSom(Long id) {
        return adminSomDAO.selectDetailSom(id);
    }
}
