package password.manager.sandbox;


import lombok.*;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Log4j
@Data
class LombokExample {

    private String name;
    private Long age;

    public void foo() {
        log.info("asdas");
    }

}
