package com.Spring_Boot_DataJPA.Data_JPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Lazy;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*It will exclude course entity while fetching By LAZY */
@ToString(
        exclude = "course"
)
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    /*One to one mapping */
    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.EAGER /*It Defines which data should access all or only this class entity*/
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
