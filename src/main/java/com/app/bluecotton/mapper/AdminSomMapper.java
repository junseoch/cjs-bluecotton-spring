package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminSomCheckDetailDTO;
import com.app.bluecotton.domain.dto.AdminSomCheckResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminSomMapper {

    public List<AdminSomCheckResponseDTO> selectConfirmByMember();

    public void updateSomCheckIsChecked(Long id);

    public void bulkUpdateSomCheckIsChecked(List<Long> somCheckIds);

    public Optional<AdminSomCheckDetailDTO> selectDetailSom(Long id);
}
