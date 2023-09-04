package CryptOptima.server.domain.manager.dto;

import CryptOptima.server.domain.manager.entity.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    // MNG_ACCOUNT02 :: 관리자 계정 추가
    public Manager createManagerDtoToManager(ManagerDto.Create managerDto) {
        return Manager.builder()
                .accountId(managerDto.getAccountId())
                .password(managerDto.getPassword())
                .managerGrade(managerDto.getManagerGrade())
                .managerName(managerDto.getManagerName())
                .managerInfo(managerDto.getManagerInfo())
                .build();
    }

    // MNG_ACCOUNT03 :: 관리자 계정 수정
    public Manager updateManagerDtoToManager(ManagerDto.Update managerDto) {
        return Manager.builder()
                .password(managerDto.getPassword())
                .managerGrade(managerDto.getManagerGrade())
                .managerName(managerDto.getManagerName())
                .managerInfo(managerDto.getManagerInfo())
                .build();
    }

    public ManagerDto.Response managerToManagerResponseDto(Manager manager) {
        return ManagerDto.Response.builder()
                .managerId(manager.getManagerId())
                .managerName(manager.getManagerName())
                .managerGrade(manager.getManagerGrade())
                .managerInfo(manager.getManagerInfo())
                .build();
    }
}