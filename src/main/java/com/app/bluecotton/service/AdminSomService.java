package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminSomCheckDetailDTO;
import com.app.bluecotton.domain.dto.AdminSomCheckResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AdminSomService {

    public List<AdminSomCheckResponseDTO> selectConfirmByMember();

    public void updateSomCheckIsChecked(Long id);

    public void bulkUpdateSomCheckIsChecked(List<Long> somCheckIds);

    public Optional<AdminSomCheckDetailDTO> selectDetailSom(Long id);
}
