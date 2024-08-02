package com.Spring_Boot_DataJPA.Data_JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "Name",
                        column = @Column(name = "guardian_name")
                ),
                @AttributeOverride(
                        name = "Email",
                        column = @Column(name = "guardian_email")
                ),
                @AttributeOverride(
                        name = "Mobile",
                        column = @Column(name = "guardian_mobile")
                )
        }
)
public class Guardian {
    /*Guardian Entity*/
    private String Name;
    private String Email;
    private String Mobile;
}
