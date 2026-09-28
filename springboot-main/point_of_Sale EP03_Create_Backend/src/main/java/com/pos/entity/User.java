package com.pos.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String username;
    @Column(nullable = false, length = 255)
    private String password;


    @Column(nullable = false, length = 150)
    private String fullName;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false)
    private Boolean enabled = true;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}