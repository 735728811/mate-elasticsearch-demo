package vip.mate.elasticsearch.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1809041336715990704L;

    private Long id;
    private String name;
    private String desc;
}
