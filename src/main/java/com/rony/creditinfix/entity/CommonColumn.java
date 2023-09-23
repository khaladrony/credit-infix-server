package com.rony.creditinfix.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class CommonColumn {

    @Version
    @Column(name = "version", columnDefinition = "int DEFAULT 0", nullable = false)
    private int version;

    @Column(name = "created_by")
    private Long createdBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Calendar createdAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Calendar updatedAt;
}
