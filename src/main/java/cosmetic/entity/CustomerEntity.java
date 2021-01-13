package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cosmetic.validator.Phone;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Column
    @Length(min = 5)
    @NotNull(message = "Your name is not null !!")
    private String nameCustomer;

    @Column
    @NotBlank
    @NotEmpty(message = "Your Phone is not null")
    @Phone(message = "Phone Number is invalid !!")
    private String phone;

    @Column
    @NotEmpty(message = "Email is not null")
    @Email
    private String email;

    @Column
    private String password;

    @Transient
    private String rePass;

    @OneToMany(mappedBy = "customerEntity")
    @JsonIgnore
    private List<OrdersEntity> orderEntities;

    @ManyToMany(fetch=FetchType.EAGER)
    @JsonIgnore // bo qua cac truong do
    @JoinTable(
            joinColumns = @JoinColumn(name = "idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<RoleEntity> roleEntityList;

    public CustomerEntity() {

    }



}
