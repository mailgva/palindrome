package com.gorbatenko.polindrome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Generated(GenerationTime.INSERT)
    @Column(name = "date_time", columnDefinition = "timestamp default now()")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @NotNull
    @Column(name = "num_value")
    private Long numValue;

    public History(User user, Long numValue) {
        this.user = user;
        this.numValue = numValue;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", numValue=" + numValue +
                '}';
    }
}