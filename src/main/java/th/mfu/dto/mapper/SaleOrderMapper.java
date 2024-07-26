package th.mfu.dto.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.SaleOrder;
import th.mfu.dto.SaleOrderDTO;

@Mapper(componentModel = "spring")

public interface SaleOrderMapper {
  //map from dto to entity
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public void updateSaleOrderFromDto(SaleOrderDTO dto, @MappingTarget SaleOrder entity);
    
//map from Entity to dto
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public void updateSaleOrderFromEntity(Collection<SaleOrder> orders ,@MappingTarget List<SaleOrderDTO> dtos);
    
//map from list of Entity to list of DTO
@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public void updateSaleOrderFromEntity(List<SaleOrder> entities ,@MappingTarget List<SaleOrderDTO> dtos);

   

}

