package ucuenca.ejemplo.store.customerservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_CUSTOMERS")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "numberID is required")
    @Size(min = 10, max = 10, message = "numberID must be 10 characters long")
    @Column(name = "number_id", unique = true, length = 10, nullable = false)
    private String numberID;

    @NotEmpty(message = "firstname is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "lastname is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "email is required")
    @Email(message = "email is invalid")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull(message = "region is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    private String state;

}
