package th.mfu.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.Customer;
import th.mfu.domain.Product;
import th.mfu.dto.CustomerDTO;
import th.mfu.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateProductFromDto(ProductDTO dto, @MappingTarget Product entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateProductFromEntity(Product entity,@MappingTarget ProductDTO dto);

}