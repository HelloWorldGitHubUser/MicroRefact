package buildingblocks.core.model;
 import jakarta.persistence;
import lombok;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;
import java.util.Objects;
@MappedSuperclass
@FilterDef(name = "softDeleteFilter", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
@Filter(name = "softDeleteFilter", condition = "is_deleted = :isDeleted")
// Required by JPA
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseEntity {

@Id
 protected  T id;

@CreatedDate
 protected  LocalDateTime createdAt;

@CreatedBy
 protected  Long createdBy;

@LastModifiedDate
 protected  LocalDateTime lastModified;

@LastModifiedBy
 protected  Long lastModifiedBy;

@Version
 protected  Long version;

 protected  boolean isDeleted;


}